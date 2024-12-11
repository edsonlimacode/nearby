package com.edsonlima.nearby.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.edsonlima.nearby.R
import com.edsonlima.nearby.ui.components.welcome.WelcomeItWorks
import com.edsonlima.nearby.ui.theme.Typography


@Composable
fun WelcomContent(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(text = "Veja como funciona", style = Typography.bodyLarge)

        WelcomeItWorks(
            title = "Encontre estabelecimentos",
            subtitle = "Veja locais perto de você, e veja como funcinoa",
            iconRes = R.drawable.ic_map_pin
        )

        WelcomeItWorks(
            title = "Ative o cupom com QR Code",
            subtitle = "Escaneie o código no estabelecimento para usar o benefício",
            iconRes = R.drawable.ic_qrcode
        )

        WelcomeItWorks(
            title = "Garanta vantagens perto de você",
            subtitle = "Ative cupons onde estiver, em diferentes tipos de estabelecimento",
            iconRes = R.drawable.ic_ticket
        )
    }
}