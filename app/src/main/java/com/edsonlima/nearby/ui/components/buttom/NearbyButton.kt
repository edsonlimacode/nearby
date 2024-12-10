package com.edsonlima.nearby.ui.components.buttom

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edsonlima.nearby.R
import com.edsonlima.nearby.ui.theme.GreenBase
import com.edsonlima.nearby.ui.theme.Typography
import java.util.Locale

@Composable
fun NearbyButtom(
    modifier: Modifier = Modifier,
    text: String? = null,
    @DrawableRes iconRes: Int? = null,
    onClick: () -> Unit
) {

    Button(
        modifier = modifier.heightIn(min = 56.dp),
        shape = RoundedCornerShape(16.dp),
        contentPadding = if(text == null && iconRes != null) PaddingValues(horizontal = 0.dp) else ButtonDefaults.ContentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenBase,
        ),
        onClick = onClick
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            iconRes?.let {
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = "Botão com icone"
                )
            }

            text?.let {
                Text(
                    text = text.uppercase(Locale.ROOT), style = Typography.labelLarge
                )
            }
        }
    }
}


@Preview
@Composable
private fun NearbyButtomPreview() {
    NearbyButtom(
        modifier = Modifier.fillMaxWidth(),
        text = "Confirmar",
        iconRes = R.drawable.ic_scan
    ) {}
}

@Preview
@Composable
private fun NearbyButtomIconPreview() {
    NearbyButtom(
        modifier = Modifier,
        iconRes = R.drawable.ic_arrow_left
    ) {}
}

@Preview
@Composable
private fun NearbyButtomNoIconPreview() {
    NearbyButtom(
        modifier = Modifier.fillMaxWidth(),
        text = "Confirmar"
    ) {}
}