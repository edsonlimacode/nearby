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
import com.edsonlima.nearby.data.model.mocks.marketList
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
        markets = marketList,
        onClick = {}
    )
}