package com.edsonlima.nearby.ui.screen.marketDetails

import com.edsonlima.nearby.data.model.Rule

data class MarketDetailUiState(
    val rules: List<Rule>? = null,
    val coupon: String? = null
)