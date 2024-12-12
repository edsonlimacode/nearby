package com.edsonlima.nearby.ui.screen.marketDetails

sealed class MarketDetailsUiEvent {

    data class GetRules(val marketId: String) : MarketDetailsUiEvent()
    data class Coupon(val qrCodeContent: String) : MarketDetailsUiEvent()
    data object resetCoupon : MarketDetailsUiEvent()

}