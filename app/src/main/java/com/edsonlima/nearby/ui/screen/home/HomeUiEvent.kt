package com.edsonlima.nearby.ui.screen.home

sealed class HomeUiEvent {
    data object GetCategories : HomeUiEvent()
    data class GetMarkets(val categoryId: String) : HomeUiEvent()
}