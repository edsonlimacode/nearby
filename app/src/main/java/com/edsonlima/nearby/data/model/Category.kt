package com.edsonlima.nearby.data.model

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val id: String,
    val name: String
) {
    @get:DrawableRes
    val icon: Int? get() = CategoryFilter.fromDescription(name)?.icon

}
