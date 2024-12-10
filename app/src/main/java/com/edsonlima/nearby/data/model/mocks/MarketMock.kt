package com.edsonlima.nearby.data.model.mocks

import com.edsonlima.nearby.data.model.Market

val marketList = listOf(
    Market(
        id = "1",
        categoryId = "1",
        name = "Mercado",
        description = "Mercado de alimentos, bebidas e demais produtos",
        coupons = 10,
        rules = emptyList(),
        latitude = 23.557784,
        longitude = -46.65565,
        address = "Vila União",
        phone = "88993022323",
        cover = ""
    ), Market(
        id = "2",
        categoryId = "2",
        name = "Caféteria",
        description = "Café da manhã e demais produtos",
        coupons = 10,
        rules = emptyList(),
        latitude = 23.557784,
        longitude = -46.65565,
        address = "Vila União",
        phone = "88993022323",
        cover = ""
    )
)