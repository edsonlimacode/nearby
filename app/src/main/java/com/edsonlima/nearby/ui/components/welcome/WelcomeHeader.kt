package com.edsonlima.nearby.ui.components.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.edsonlima.nearby.R
import com.edsonlima.nearby.ui.theme.Typography

@Composable
fun WelcomeHeader(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.img_logo_logo_icon),
            contentDescription = "Logo topo"
        )
        Spacer(modifier.height(24.dp))
        Text(text = "Bem vindo!", style = Typography.headlineLarge)
        Text(
            text = "Tenha cupuns de vantegem na sua região, e usar nos seus estabelecimento preferidos",
            style = Typography.bodyLarge
        )
    }
}