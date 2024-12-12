package com.edsonlima.nearby.data.model.mocks

import com.edsonlima.nearby.data.model.Market
import com.edsonlima.nearby.data.model.Rule

val marketList = listOf(
    Market(
        id = "1",
        categoryId = "1",
        name = "Mercado",
        description = "Mercado de alimentos, bebidas e demais produtos",
        coupons = 5,
        /*rules = listOf(
            Rule(
                "1", "Até dia 31 de dezembro", "1"
            ),
            Rule(
                "2", "50% off na primeira compra", "1"
            )
        ),*/
        latitude = 23.557784,
        longitude = -46.65565,
        address = "Centro",
        phone = "88993023456",
        cover = ""
    ), Market(
        id = "2",
        categoryId = "2",
        name = "Caféteria",
        description = "Café da manhã e demais produtos",
        coupons = 10,
//        rules = emptyList(),
        latitude = 23.557784,
        longitude = -46.65565,
        address = "Vila União, 28",
        phone = "88993022323",
        cover = ""
    )
)