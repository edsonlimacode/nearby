package com.edsonlima.nearby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.edsonlima.nearby.data.model.Market
import com.edsonlima.nearby.ui.route.Home
import com.edsonlima.nearby.ui.route.QrCodeScanner
import com.edsonlima.nearby.ui.route.Splash
import com.edsonlima.nearby.ui.route.Welcome
import com.edsonlima.nearby.ui.screen.home.HomeScreen
import com.edsonlima.nearby.ui.screen.home.HomeViewModel
import com.edsonlima.nearby.ui.screen.marketDetails.MarketDetailScreen
import com.edsonlima.nearby.ui.screen.marketDetails.MarketDetailsUiEvent
import com.edsonlima.nearby.ui.screen.marketDetails.MarketDetailsViewModel
import com.edsonlima.nearby.ui.screen.qrCode.QrCodeScannerScreen
import com.edsonlima.nearby.ui.screen.splash.SplashScreen
import com.edsonlima.nearby.ui.screen.welcome.WelcomeScreen
import com.edsonlima.nearby.ui.theme.NearbyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NearbyTheme {

                val navController = rememberNavController()

                val homeViewModel by viewModels<HomeViewModel>()
                val homeUiState by homeViewModel.uiState.collectAsStateWithLifecycle()

                val marketViewModel by viewModels<MarketDetailsViewModel>()
                val marketDetailUiState by marketViewModel.uiState.collectAsStateWithLifecycle()

                NavHost(
                    navController = navController,
                    startDestination = Splash
                ) {
                    composable<Splash> {
                        SplashScreen(
                            onNavigateToWelcome = {
                                navController.navigate(Welcome)
                            }
                        )
                    }
                    composable<Welcome> {
                        WelcomeScreen(onNavigateToHome = {
                            navController.navigate(Home)
                        })
                    }

                    composable<Home> {
                        HomeScreen(
                            onNavigateToMarketDetails = {
                                navController.navigate(it)
                            },
                            uiState = homeUiState,
                            onEvent = homeViewModel::onEvent
                        )
                    }

                    composable<Market> {
                        val selectedMarket = it.toRoute<Market>()
                        MarketDetailScreen(
                            market = selectedMarket,
                            onNavigateBack = {
                                navController.popBackStack()
                            },
                            uiState = marketDetailUiState,
                            onEvent = marketViewModel::onEvent,
                            onNavigateToQrCodeScanner = {
                                navController.navigate(QrCodeScanner)
                            }
                        )
                    }

                    composable<QrCodeScanner> {
                        QrCodeScannerScreen(
                            onCompletedScann = { qrCodeContent ->
                                if (qrCodeContent.isNotEmpty()) {
                                    marketViewModel.onEvent(
                                        MarketDetailsUiEvent.Coupon(
                                            qrCodeContent
                                        )
                                    )
                                }
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}