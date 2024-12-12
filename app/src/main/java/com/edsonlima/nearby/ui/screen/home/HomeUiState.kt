package com.edsonlima.nearby.ui.screen.home

import com.edsonlima.nearby.data.model.Category
import com.edsonlima.nearby.data.model.Market
import com.google.android.gms.maps.model.LatLng

data class HomeUiState(
    val categories: List<Category>? = null,
    val markets: List<Market>? = null,
    val marketLocation: List<LatLng>? = null
)
