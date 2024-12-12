package com.edsonlima.nearby.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MarketDetails(
    val id: String,
    val categoryId: String,
    val name: String,
    val description: String,
    val coupons: Int,
    val rules: List<Rule> = emptyList(),
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val phone: String,
    val cover: String,
)
