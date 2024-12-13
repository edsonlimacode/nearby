package com.edsonlima.nearby.ui.screen.marketDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.edsonlima.nearby.R
import com.edsonlima.nearby.data.model.Market
import com.edsonlima.nearby.data.model.mocks.marketList
import com.edsonlima.nearby.ui.components.buttom.NearbyButtom
import com.edsonlima.nearby.ui.components.marketDetails.MarketDetailsCupons
import com.edsonlima.nearby.ui.components.marketDetails.MarketDetailsInfo
import com.edsonlima.nearby.ui.components.marketDetails.MarketDetailsRules
import com.edsonlima.nearby.ui.theme.Typography

@Composable
fun MarketDetailScreen(
    modifier: Modifier = Modifier,
    market: Market,
    uiState: MarketDetailUiState,
    onEvent: (MarketDetailsUiEvent) -> Unit = {},
    onNavigateToQrCodeScanner: () -> Unit = {},
    onNavigateBack: () -> Unit = {}
) {

    LaunchedEffect(true) {
        onEvent(MarketDetailsUiEvent.GetRules(marketId = market.id))
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            contentDescription = "Imagem do local",
            contentScale = ContentScale.Crop,
            model = market.cover
        )

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
                .align(Alignment.BottomCenter)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Text(
                    text = market.name,
                    style = Typography.headlineLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = market.description,
                    style = Typography.bodyLarge
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                ) {
                    Column {

                        Spacer(modifier = Modifier.height(46.dp))

                        MarketDetailsInfo(market = market)

                        HorizontalDivider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 24.dp)
                        )

                        if (!uiState.rules.isNullOrEmpty()) {
                            MarketDetailsRules(rules = uiState.rules)
                        }

                        HorizontalDivider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 24.dp)
                        )
                        if (!uiState.coupon.isNullOrEmpty()) {
                            MarketDetailsCupons(
                                modifier = Modifier.fillMaxWidth(),
                                coupons = listOf(uiState.coupon)
                            )
                        }

                    }
                }


                NearbyButtom(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    text = "Ler qr code",
                    onClick = {
                        onNavigateToQrCodeScanner()
                    }
                )
            }

        }

        NearbyButtom(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(24.dp),
            iconRes = R.drawable.ic_arrow_left,
            onClick = {
                onNavigateBack()
            }
        )
    }
}

@Preview
@Composable
private fun MarketDetailScreenPrev() {
    MarketDetailScreen(
        market = marketList.first(),
        onNavigateBack = {},
        uiState = MarketDetailUiState(),
        onEvent = {},
        onNavigateToQrCodeScanner = {}
    )
}