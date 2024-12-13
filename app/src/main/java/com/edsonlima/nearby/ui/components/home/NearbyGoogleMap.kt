package com.edsonlima.nearby.ui.components.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import com.edsonlima.nearby.R
import com.edsonlima.nearby.data.model.mocks.mockUserLocation
import com.edsonlima.nearby.ui.screen.home.HomeUiState
import com.edsonlima.nearby.ui.screen.util.findNorthWestPoint
import com.edsonlima.nearby.ui.screen.util.findSouthWestPoint
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.internal.toImmutableList
import kotlin.math.roundToInt


@Composable
fun NearByGoogleMap(modifier: Modifier = Modifier, uiState: HomeUiState) {

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val density = LocalDensity.current

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(mockUserLocation, 13f)
    }

    val uiSettings by remember {
        mutableStateOf(MapUiSettings(zoomControlsEnabled = false))
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        uiSettings = uiSettings
    ) {
        //marcador de localização do usuário
        context.getDrawable(R.drawable.ic_user_location)?.let {
            Marker(
                state = MarkerState(position = mockUserLocation),
                icon = BitmapDescriptorFactory.fromBitmap(
                    it.toBitmap(
                        width = density.run { 72.dp.toPx().roundToInt() },
                        height = density.run { 72.dp.toPx().roundToInt() }
                    )
                )
            )
        }

        //marcador de localização dos estabelecimentos
        if (!uiState.markets.isNullOrEmpty()) {
            context.getDrawable(R.drawable.img_pin)?.let {

                uiState.marketLocation?.toImmutableList()
                    ?.forEachIndexed { index, location ->
                        Marker(
                            state = MarkerState(position = location),
                            icon = BitmapDescriptorFactory.fromBitmap(
                                it.toBitmap(
                                    width = density.run {
                                        36.dp.toPx().roundToInt()
                                    },
                                    height = density.run {
                                        36.dp.toPx().roundToInt()
                                    }
                                )
                            ),
                            title = uiState.markets[index].name
                        )
                    }.also {

                        coroutineScope.launch {
                            val allMarks =
                                uiState.marketLocation?.plus(mockUserLocation)
                            val southWest = findSouthWestPoint(allMarks.orEmpty())
                            val northWest = findNorthWestPoint(allMarks.orEmpty())

                            val centerPointLatitude =
                                (southWest.latitude + northWest.latitude) / 2
                            val centerPointLongitude =
                                (southWest.longitude + northWest.longitude) / 2
                            val cameraUpdate =
                                CameraUpdateFactory.newCameraPosition(
                                    CameraPosition(
                                        LatLng(
                                            centerPointLatitude,
                                            centerPointLongitude
                                        ),
                                        13f,
                                        0f,
                                        0f
                                    )
                                )
                            delay(200)
                            cameraPositionState.animate(
                                cameraUpdate,
                                durationMs = 500
                            )
                        }
                    }
            }
        }
    }
}