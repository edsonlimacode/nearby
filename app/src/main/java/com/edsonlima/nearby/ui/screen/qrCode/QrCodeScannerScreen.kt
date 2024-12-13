package com.edsonlima.nearby.ui.screen.qrCode

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat
import com.edsonlima.nearby.MainActivity
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions

@Composable
fun QrCodeScannerScreen(
    modifier: Modifier = Modifier,
    onCompletedScann: (String) -> Unit
) {
    val context = LocalContext.current

    val scanOptions = ScanOptions()
        .setDesiredBarcodeFormats(ScanOptions.QR_CODE)
        .setPrompt("Leia o Qr code do usuário")
        .setCameraId(0)
        .setBeepEnabled(true)
        .setOrientationLocked(false)
        .setBarcodeImageEnabled(true)

    val barCodeLauncher = rememberLauncherForActivityResult(
        ScanContract()
    ) { scannResult ->
        scannResult?.let {
            onCompletedScann(scannResult.contents.orEmpty())
        }
    }

    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            barCodeLauncher.launch(scanOptions)
        } else {
            ActivityResultContracts.RequestPermission()
        }
    }

    fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.CAMERA
            ) == android.content.pm.PackageManager.PERMISSION_GRANTED
        ) {
            barCodeLauncher.launch(scanOptions)
        } else if (shouldShowRequestPermissionRationale(
                context as MainActivity,
                android.Manifest.permission.CAMERA
            )
        ) {
            Toast.makeText(
                context,
                "Necessário permissao de camera, para continuar",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            cameraPermissionLauncher.launch(android.Manifest.permission.CAMERA)
        }
    }

    LaunchedEffect(true) {
        checkCameraPermission()
    }

    Column(modifier = Modifier.fillMaxSize()) {  }

}