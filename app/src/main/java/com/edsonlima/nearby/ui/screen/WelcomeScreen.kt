package com.edsonlima.nearby.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edsonlima.nearby.ui.components.buttom.NearbyButtom
import com.edsonlima.nearby.ui.components.welcome.WelcomContent
import com.edsonlima.nearby.ui.components.welcome.WelcomeHeader


@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 40.dp, vertical = 48.dp)
            .verticalScroll(state = rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        WelcomeHeader()
        WelcomContent()
        NearbyButtom(
            modifier = Modifier.fillMaxWidth(),
            text = "Começar",
            onClick = {
                onNavigateToHome()
            }
        )

    }
}

@Preview
@Composable
private fun WelcomeScreenPrev() {
    WelcomeScreen(onNavigateToHome = {})
}