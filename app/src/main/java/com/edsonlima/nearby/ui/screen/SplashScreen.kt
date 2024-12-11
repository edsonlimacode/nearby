package com.edsonlima.nearby.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.edsonlima.nearby.R
import com.edsonlima.nearby.ui.theme.GreenLight

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .background(GreenLight)
            .fillMaxSize()
    ) {

        Image(
            modifier = modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.img_logo_logo_logo_text),
            contentDescription = "Logo"
        )

        Image(
            modifier = modifier.align(Alignment.BottomCenter),
            painter = painterResource(id = R.drawable.bg_splash_screen),
            contentDescription = "Logo"
        )
    }
}

@Preview
@Composable
private fun SplashScreenPrev() {
    SplashScreen()
}