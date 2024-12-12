package com.edsonlima.nearby.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edsonlima.nearby.data.model.Market
import com.edsonlima.nearby.data.model.mocks.categoriesList
import com.edsonlima.nearby.data.model.mocks.marketList
import com.edsonlima.nearby.ui.components.category.NearbyCategoryFilterChipList
import com.edsonlima.nearby.ui.components.market.MarketCardList
import com.edsonlima.nearby.ui.theme.Gray100
import com.google.maps.android.compose.GoogleMap

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToMarketDetails: (Market) -> Unit
) {

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    val isBottomSheetOpen by remember { mutableStateOf(true) }

    val configuration = LocalConfiguration.current

    if (isBottomSheetOpen) {
        BottomSheetScaffold(
            modifier = modifier,
            scaffoldState = bottomSheetScaffoldState,
            sheetContainerColor = Gray100,
            sheetPeekHeight = configuration.screenHeightDp.dp * 0.5f,
            sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            sheetContent = {
                MarketCardList(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    markets = marketList,
                    onClick = {
                        onNavigateToMarketDetails(it)
                    }
                )
            },
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                ) {
                    GoogleMap(
                        modifier = Modifier.fillMaxSize()
                    )

                    NearbyCategoryFilterChipList(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp)
                            .align(Alignment.TopStart),
                        categories = categoriesList,
                        onSelectedCategoryChanged = {}
                    )
                }
            }
        )
    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    HomeScreen(onNavigateToMarketDetails = {})
}