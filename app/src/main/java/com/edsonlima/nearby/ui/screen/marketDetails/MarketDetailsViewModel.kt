package com.edsonlima.nearby.ui.screen.marketDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edsonlima.nearby.network.NearbyRemoteDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MarketDetailsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MarketDetailUiState())
    val uiState: StateFlow<MarketDetailUiState> = _uiState.asStateFlow()

    fun onEvent(event: MarketDetailsUiEvent) {
        when (event) {
            is MarketDetailsUiEvent.Coupon -> {
                getCoupon(qrCodeContent = event.qrCodeContent)
            }

            is MarketDetailsUiEvent.GetRules -> {
                getRules(marketId = event.marketId)
            }

            MarketDetailsUiEvent.resetCoupon -> {
                resetCoupon()
            }
        }
    }

    private fun getCoupon(qrCodeContent: String) = viewModelScope.launch {

        NearbyRemoteDataSource.patchCoupon(couponId = qrCodeContent)
            .onSuccess { coupon ->
                _uiState.update { currentUiState ->
                    currentUiState.copy(coupon = coupon.coupon)
                }
            }.onFailure {
                _uiState.update { currentUiState ->
                    currentUiState.copy(coupon = "")
                }
            }

    }

    private fun getRules(marketId: String) = viewModelScope.launch {

        NearbyRemoteDataSource.getMarketDetails(marketId)
            .onSuccess { marketDetails ->
                _uiState.update { currentUiState ->
                    currentUiState.copy(rules = marketDetails.rules)
                }
            }.onFailure {
                _uiState.update { currentUiState ->
                    currentUiState.copy(rules = emptyList())
                }
            }

    }

    private fun resetCoupon() {
        _uiState.update { currentUiState ->
            currentUiState.copy(coupon = null)
        }
    }

}