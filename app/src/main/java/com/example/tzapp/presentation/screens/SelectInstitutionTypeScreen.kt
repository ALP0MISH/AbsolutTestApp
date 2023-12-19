package com.example.tzapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tzapp.R
import com.example.tzapp.presentation.components.BottomButton
import com.example.tzapp.presentation.components.OnBoardingScreen
import com.example.tzapp.presentation.components.SpacerHeight
import com.example.tzapp.presentation.components.SpacerWidth
import com.example.tzapp.presentation.screens.onboarding.OnboardingEvent
import com.example.tzapp.presentation.theme.Grey
import com.example.tzapp.presentation.theme.LabelSpacing
import com.example.tzapp.presentation.theme.LargeSpacing
import com.example.tzapp.presentation.theme.LightBlue
import com.example.tzapp.presentation.theme.MediumSpacing

@Composable
fun SelectInstitutionTypeScreen(
    screen: OnBoardingScreen.SelectInstitutionTypeItem,
    onNextPage: () -> Unit,
    scrollState: ScrollState,
    onEvent: (OnboardingEvent) -> Unit,
    onPreviesPage: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isChecked by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = LargeSpacing)
        ) {
            Text(
                modifier = Modifier,
                text = stringResource(id = screen.title),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
            SpacerHeight(MediumSpacing)
            Text(
                modifier = Modifier,
                text = stringResource(id = screen.description),
                style = MaterialTheme.typography.bodyLarge,
                color = Grey
            )
            SpacerHeight(LabelSpacing)
            Row(
                modifier = Modifier.clickable {
                    isChecked = !isChecked
                    onEvent(OnboardingEvent.OnRestaurantChange(value = isChecked))
                },

                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.restaurant_icon),
                    contentDescription = null
                )
                SpacerWidth(LargeSpacing)
                Text(
                    text = stringResource(id = R.string.restaurant),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(0.8f))
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = {
                        isChecked = it
                        onEvent(OnboardingEvent.OnRestaurantChange(value = it))
                    },
                    modifier = Modifier,
                    colors = CheckboxDefaults.colors(
                        checkedColor = LightBlue,
                        checkmarkColor = Color.White
                    )
                )
            }
            Divider()
            var barState by rememberSaveable { mutableStateOf(false) }
            Row(
                modifier = Modifier.clickable {
                    barState = !barState
                    onEvent(OnboardingEvent.OnBarChange(value = barState))

                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.bar_icon),
                    contentDescription = null
                )
                SpacerWidth(LargeSpacing)
                Text(
                    text = stringResource(id = R.string.bar),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(0.8f))
                Checkbox(
                    checked = barState,
                    onCheckedChange = {
                        barState = it
                        onEvent(OnboardingEvent.OnBarChange(value = it))
                    },
                    modifier = Modifier,
                    colors = CheckboxDefaults.colors(
                        checkedColor = LightBlue,
                        checkmarkColor = Color.White
                    )
                )
            }
            Divider()
            var coffeeState by rememberSaveable { mutableStateOf(false) }
            Row(
                modifier = Modifier.clickable {
                    coffeeState = !coffeeState
                    onEvent(OnboardingEvent.OnCoffeeChange(value = barState))
                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.coffee_icon),
                    contentDescription = null
                )
                SpacerWidth(LargeSpacing)
                Text(
                    text = stringResource(id = R.string.coffee),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(0.8f))
                Checkbox(
                    checked = coffeeState,
                    onCheckedChange = {
                        coffeeState = it
                        onEvent(OnboardingEvent.OnCoffeeChange(value = it))
                    },
                    modifier = Modifier,
                    colors = CheckboxDefaults.colors(
                        checkedColor = LightBlue,
                        checkmarkColor = Color.White
                    )
                )
            }
            Divider()
            var canteenState by rememberSaveable { mutableStateOf(false) }
            Row(
                modifier = Modifier.clickable {
                    canteenState = !canteenState
                    onEvent(OnboardingEvent.OnCanteenChange(value = canteenState))
                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.canteen_icon),
                    contentDescription = null
                )
                SpacerWidth(LargeSpacing)
                Text(
                    text = stringResource(id = R.string.canteen),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(0.8f))
                Checkbox(
                    checked = canteenState,
                    onCheckedChange = {
                        canteenState = it
                        onEvent(OnboardingEvent.OnCanteenChange(value = it))
                    },
                    modifier = Modifier,
                    colors = CheckboxDefaults.colors(
                        checkedColor = LightBlue,
                        checkmarkColor = Color.White
                    )
                )
            }
            Divider()
            var coffeeHouseState by rememberSaveable { mutableStateOf(false) }
            Row(
                modifier = Modifier.clickable {
                    coffeeHouseState = !coffeeHouseState
                    onEvent(OnboardingEvent.OnCoffeeHouseChange(value = coffeeHouseState))
                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.coffee_house_icon),
                    contentDescription = null
                )
                SpacerWidth(LargeSpacing)
                Text(
                    text = stringResource(id = R.string.coffee_house),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(0.8f))
                Checkbox(
                    checked = coffeeHouseState,
                    onCheckedChange = {
                        coffeeHouseState = it
                        onEvent(OnboardingEvent.OnCanteenChange(value = it))
                    },
                    modifier = Modifier,
                    colors = CheckboxDefaults.colors(
                        checkedColor = LightBlue,
                        checkmarkColor = Color.White
                    )
                )
            }
            Divider()
            var cookingState by rememberSaveable { mutableStateOf(false) }
            Row(
                modifier = Modifier.clickable {
                    cookingState = !cookingState
                    onEvent(OnboardingEvent.OnCookingChange(value = cookingState))

                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.cooking_icon),
                    contentDescription = null
                )
                SpacerWidth(LargeSpacing)
                Text(
                    text = stringResource(id = R.string.cooking),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(0.8f))
                Checkbox(
                    checked = cookingState,
                    onCheckedChange = {
                        cookingState = it
                        onEvent(OnboardingEvent.OnCookingChange(value = it))
                    },
                    modifier = Modifier,
                    colors = CheckboxDefaults.colors(
                        checkedColor = LightBlue,
                        checkmarkColor = Color.White
                    )
                )
            }
            Divider()
            var otherState by rememberSaveable { mutableStateOf(false) }
            Row(
                modifier = Modifier.clickable {
                    otherState = !otherState
                    onEvent(OnboardingEvent.OnOthersChange(value = otherState))
                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.other_icon),
                    contentDescription = null
                )
                SpacerWidth(LargeSpacing)
                Text(
                    text = stringResource(id = R.string.other),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Checkbox(
                    checked = otherState,
                    onCheckedChange = {
                        otherState = it
                        onEvent(OnboardingEvent.OnOthersChange(value = it))
                    },
                    modifier = Modifier,
                    colors = CheckboxDefaults.colors(
                        checkedColor = LightBlue,
                        checkmarkColor = Color.White
                    )
                )
            }
            Divider()
        }
        Spacer(modifier = Modifier.weight(0.8f))
        BottomButton(
            onNextPage = onNextPage,
            onPreviousPage = onPreviesPage
        )
    }
}