package com.edsonlima.nearby.network

import android.util.Log
import com.edsonlima.nearby.data.model.Category
import com.edsonlima.nearby.data.model.Coupon
import com.edsonlima.nearby.data.model.Market
import com.edsonlima.nearby.data.model.MarketDetails
import com.edsonlima.nearby.network.KtorHttpClient.httpClientAndroid
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch

object NearbyRemoteDataSource {

    //para acessar a api, e preciso passar o ip do emulador
    private const val LOCAL_HOST_EMULATOR_BASE_URL = "http://10.0.2.2:3333"
    private const val FISICAL_HOST_EMULATOR_BASE_URL = "http://192.168.1.7:3333"

    private const val BASE_URL = FISICAL_HOST_EMULATOR_BASE_URL


    suspend fun getCategories(): Result<List<Category>> {
        try {
            val categories = httpClientAndroid.get("$BASE_URL/categories")
                .body<List<Category>>()

            return Result.success(categories)
        } catch (ex: Exception) {
            return Result.failure(ex)
        }
    }

    suspend fun getMarkets(categoryId: String): Result<List<Market>> {
        try {
            val markets =
                httpClientAndroid.get("$BASE_URL/markets/category/$categoryId")
                    .body<List<Market>>()

            return Result.success(markets)
        } catch (ex: Exception) {
            return Result.failure(ex)
        }
    }

    suspend fun getMarketDetails(marketId: String): Result<MarketDetails> {
        try {
            val markets =
                httpClientAndroid.get("$BASE_URL/markets/$marketId")
                    .body<MarketDetails>()

            return Result.success(markets)
        } catch (ex: Exception) {
            return Result.failure(ex)
        }
    }

    suspend fun patchCoupon(couponId: String): Result<Coupon> {
        try {
            val coupon = httpClientAndroid.patch("$BASE_URL/coupons/${couponId}").body<Coupon>()

            return Result.success(coupon)
        } catch (ex: Exception) {
            return Result.failure(ex)
        }
    }

}