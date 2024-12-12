package com.edsonlima.nearby.ui.components.marketDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edsonlima.nearby.R
import com.edsonlima.nearby.ui.theme.Gray400
import com.edsonlima.nearby.ui.theme.GreenBase
import com.edsonlima.nearby.ui.theme.GreenExtraLight
import com.edsonlima.nearby.ui.theme.Typography


@Composable
fun MarketDetailsCupons(
    modifier: Modifier = Modifier,
    coupons: List<String>
) {

    Column(
        modifier = Modifier.padding(bottom = 25.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Ultilize estes cupons", style = Typography.headlineSmall, color = Gray400)

        coupons.forEach { cupon ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenExtraLight)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    tint = GreenBase,
                    painter = painterResource(id = R.drawable.ic_ticket),
                    contentDescription = "Cupons"
                )
                Text(text = cupon, style = Typography.headlineSmall)
            }
        }
    }
}

@Preview
@Composable
private fun MarketDetailsCuponsPrev() {
    MarketDetailsCupons(
        modifier = Modifier.fillMaxWidth(),
        coupons = listOf("ABC123SW", "DEF123SW", "EFG123SW")
    )
}