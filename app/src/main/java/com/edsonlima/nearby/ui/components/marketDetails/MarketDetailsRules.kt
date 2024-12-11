package com.edsonlima.nearby.ui.components.marketDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edsonlima.nearby.data.model.Rule
import com.edsonlima.nearby.data.model.mocks.rulesList
import com.edsonlima.nearby.ui.theme.Gray400
import com.edsonlima.nearby.ui.theme.Gray500
import com.edsonlima.nearby.ui.theme.Typography

@Composable
fun MarketDetailsRules(
    modifier: Modifier = Modifier,
    rules: List<Rule>
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        Text(text = "Regulamento", style = Typography.headlineSmall, color = Gray400)

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = rules.joinToString(separator = "\n", transform = { " ${it.description} " }),
                style = Typography.labelMedium,
                lineHeight = 24.sp,
                color = Gray500
            )
        }

    }
}


@Preview
@Composable
private fun MarketDetailsRulesPrev() {

    MarketDetailsRules(
        modifier = Modifier.fillMaxWidth(),
        rules = rulesList
    )

}