package com.edsonlima.nearby.ui.components.category

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edsonlima.nearby.data.model.Category
import com.edsonlima.nearby.ui.theme.Gray300
import com.edsonlima.nearby.ui.theme.Gray400
import com.edsonlima.nearby.ui.theme.GreenBase
import com.edsonlima.nearby.ui.theme.Typography

@Composable
fun NearbyCategoryFilterChip(
    modifier: Modifier = Modifier,
    category: Category,
    isSelected: Boolean,
    onClick: (isSelected: Boolean) -> Unit
) {
    FilterChip(
        selected = isSelected,
        onClick = { onClick(!isSelected) },
        label = {
            Text(
                text = category.name,
                style = Typography.bodyMedium,
                color = if (isSelected) Color.White else Gray400
            )
        },
        modifier = modifier
            .padding(2.dp)
            .heightIn(min = 36.dp),
        leadingIcon = {
            category.icon?.let {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = it),
                    contentDescription = "Icone da categoria",
                    tint = if (isSelected) Color.White else Gray400
                )
            }
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.White,
            selectedContainerColor = GreenBase
        ),
        elevation = FilterChipDefaults.filterChipElevation(
            elevation = 0.dp
        ),
        border = FilterChipDefaults.filterChipBorder(
            enabled = false,
            selected = isSelected,
            borderWidth = 1.dp,
            disabledBorderColor = Gray300,
            selectedBorderColor = Color.Transparent,
            selectedBorderWidth = 0.dp
        ),
    )
}

@Preview
@Composable
private fun NearbyCategoryFilterChipPreview() {
    NearbyCategoryFilterChip(
        modifier = Modifier,
        category = Category(
            id = "1",
            name = "Alimentação"
        ),
        isSelected = true,
        onClick = {}
    )
}

@Preview
@Composable
private fun NearbyCategoryNotSelectedFilterChipPreview() {
    NearbyCategoryFilterChip(
        modifier = Modifier,
        category = Category(
            id = "1",
            name = "Compras"
        ),
        isSelected = false,
        onClick = {}
    )
}