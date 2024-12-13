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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.edsonlima.nearby.data.model.Market
import com.edsonlima.nearby.ui.components.category.NearbyCategoryFilterChipList
import com.edsonlima.nearby.ui.components.home.NearByGoogleMap
import com.edsonlima.nearby.ui.components.market.MarketCardList
import com.edsonlima.nearby.ui.theme.Gray100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToMarketDetails: (Market) -> Unit,
    uiState: HomeUiState,
    onEvent: (HomeUiEvent) -> Unit
) {

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()

    val configuration = LocalConfiguration.current

    //executa uma unica vez, assim que a tela é iniciada
    LaunchedEffect(true) {
        onEvent(HomeUiEvent.GetCategories)
    }

    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = bottomSheetScaffoldState,
        sheetContainerColor = Gray100,
        sheetPeekHeight = configuration.screenHeightDp.dp * 0.5f,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetContent = {
            if (!uiState.markets.isNullOrEmpty()) {
                MarketCardList(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    markets = uiState.markets,
                    onClick = {
                        onNavigateToMarketDetails(it)
                    }
                )
            }

        },
        content = {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        bottom = it
                            .calculateBottomPadding()
                            .minus(10.dp)
                    )
            ) {

                NearByGoogleMap(uiState = uiState)

                if (!uiState.categories.isNullOrEmpty()) {
                    NearbyCategoryFilterChipList(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp)
                            .align(Alignment.TopStart),
                        categories = uiState.categories,
                        onSelectedCategoryChanged = { category ->
                            onEvent(HomeUiEvent.GetMarkets(categoryId = category.id))
                        }
                    )
                }
            }
        }
    )

}


/*
@Preview
@Composable
private fun HomeScreenPrev() {
    HomeScreen(onNavigateToMarketDetails = {}, uiState = HomeUiState(), onEvent = {})
}*/
