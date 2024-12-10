package com.edsonlima.nearby.ui.components.market

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edsonlima.nearby.data.model.Market
import com.edsonlima.nearby.ui.theme.Typography

@Composable
fun MarketCardList(
    modifier: Modifier = Modifier,
    markets: List<Market>,
    onClick: (Market) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(text = "Explore locais perto de você", style = Typography.bodyLarge)
        }

        items(items = markets, key = { it.id }) { market ->
            MarketCard(
                market = market,
                onClick = {
                    onClick(market)
                }
            )
        }
    }
}

@Preview
@Composable
private fun MarketCardListPreview() {
    MarketCardList(
        markets = listOf(
            Market(
                id = "1",
                categoryId = "1",
                name = "Mercado",
                description = "Mercado de alimentos, bebidas e demais produtos",
                coupons = 10,
                rules = emptyList(),
                latitude = 23.557784,
                longitude = -46.65565,
                address = "Vila União",
                phone = "88993022323",
                cover = ""
            ), Market(
                id = "2",
                categoryId = "2",
                name = "Caféteria",
                description = "Café da manhã e demais produtos",
                coupons = 10,
                rules = emptyList(),
                latitude = 23.557784,
                longitude = -46.65565,
                address = "Vila União",
                phone = "88993022323",
                cover = ""
            )
        ),
        onClick = {}
    )
}