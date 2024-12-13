package com.edsonlima.nearby.ui.screen.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edsonlima.nearby.network.NearbyRemoteDataSource
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onEvent(event: HomeUiEvent) {
        when (event) {
            HomeUiEvent.GetCategories -> {
                getCategories()
            }

            is HomeUiEvent.GetMarkets -> {
                getMarkets(categoryId = event.categoryId)
            }
        }
    }

    private fun getCategories() = viewModelScope.launch {

        _uiState.update { currentUiState ->

            NearbyRemoteDataSource.getCategories().fold(
                onSuccess = { categoriesList ->
                    currentUiState.copy(categories = categoriesList)
                },
                onFailure = {
                    currentUiState.copy(categories = emptyList())
                })
        }
    }

    private fun getMarkets(categoryId: String) = viewModelScope.launch {
        _uiState.update { currentUiState ->

            NearbyRemoteDataSource.getMarkets(categoryId).fold(
                onSuccess = { marketsList ->
                    currentUiState.copy(
                        markets = marketsList,
                        marketLocation = marketsList.map {
                            LatLng(it.latitude, it.longitude)
                        }
                    )
                },
                onFailure = {
                    currentUiState.copy(
                        markets = emptyList(),
                        marketLocation = emptyList()
                    )
                }
            )
        }
    }
}