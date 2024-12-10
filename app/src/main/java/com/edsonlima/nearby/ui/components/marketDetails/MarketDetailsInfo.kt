package com.edsonlima.nearby.ui.components.marketDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edsonlima.nearby.R
import com.edsonlima.nearby.data.model.Market
import com.edsonlima.nearby.data.model.mocks.marketList
import com.edsonlima.nearby.ui.theme.Gray400
import com.edsonlima.nearby.ui.theme.Gray500
import com.edsonlima.nearby.ui.theme.Typography

@Composable
fun MarketDetailsInfo(
    modifier: Modifier = Modifier,
    market: Market
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        Text(text = "Informações", style = Typography.headlineSmall, color = Gray400)

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    tint = Gray500,
                    painter = painterResource(id = R.drawable.ic_ticket),
                    contentDescription = "Cupons"
                )
                Text(
                    text = "${market.coupons} cupons disponivéis",
                    style = Typography.bodyMedium.copy(fontSize = 12.sp),
                    color = Gray400
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    tint = Gray500,
                    painter = painterResource(id = R.drawable.ic_map_pin),
                    contentDescription = "Map"
                )
                Text(
                    text = market.address,
                    style = Typography.bodyMedium.copy(fontSize = 12.sp),
                    color = Gray400
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    tint = Gray500,
                    painter = painterResource(id = R.drawable.ic_phone),
                    contentDescription = "Telefone"
                )
                Text(
                    text = market.phone,
                    style = Typography.bodyMedium.copy(fontSize = 12.sp),
                    color = Gray400
                )
            }
        }
    }
}

@Preview
@Composable
private fun MarketDetailsInfoPrev() {

    MarketDetailsInfo(
        modifier = Modifier.fillMaxWidth(),
        market = marketList.first()
    )

}