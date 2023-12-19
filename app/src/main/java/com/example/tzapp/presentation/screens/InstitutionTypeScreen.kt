package com.example.tzapp.presentation.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.tzapp.R
import com.example.tzapp.presentation.components.BottomButton
import com.example.tzapp.presentation.components.OnBoardingScreen
import com.example.tzapp.presentation.components.OnboardingTextField
import com.example.tzapp.presentation.components.SpacerHeight
import com.example.tzapp.presentation.screens.onboarding.OnboardingEvent
import com.example.tzapp.presentation.screens.onboarding.OnboardingUiState
import com.example.tzapp.presentation.theme.ExtraLargeSpacing
import com.example.tzapp.presentation.theme.LargeSpacing

@Composable
fun InstitutionTypeScreen(
    screen: OnBoardingScreen.InstitutionTypeItem,
    scrollState: ScrollState,
    onNextPage: () -> Unit,
    onPreviesPage: () -> Unit,
    uiState: OnboardingUiState,
    onEvent: (OnboardingEvent) -> Unit,
    modifier: Modifier = Modifier
) {
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
            SpacerHeight(ExtraLargeSpacing)
            OnboardingTextField(
                modifier = Modifier,
                placeHolder = stringResource(id = R.string.total_area),
                text = uiState.totalArea,
                onValueChange = { onEvent(OnboardingEvent.OnTotalAreaChange(it)) }
            )
            SpacerHeight(ExtraLargeSpacing)
            OnboardingTextField(
                modifier = Modifier,
                placeHolder = stringResource(id = R.string.number_of_seats),
                text = uiState.numberOfSeats,
                onValueChange = { onEvent(OnboardingEvent.OnNumberOfSeatsChange(it)) }
            )
            SpacerHeight(ExtraLargeSpacing)
            OnboardingTextField(
                modifier = Modifier,
                placeHolder = stringResource(id = R.string.area_of_halls),
                text = uiState.areaOfHalls,
                onValueChange = { onEvent(OnboardingEvent.OnAreaOfHallsChange(it)) }
            )
            SpacerHeight(ExtraLargeSpacing)
            OnboardingTextField(
                modifier = Modifier,
                placeHolder = stringResource(id = R.string.kitchen_area),
                text = uiState.areaKitchen,
                onValueChange = { onEvent(OnboardingEvent.OnKitchenAreaChange(it)) }
            )
        }
        Spacer(modifier = Modifier.weight(0.8f))
        BottomButton(
            onNextPage = onNextPage,
            onPreviousPage = onPreviesPage
        )
    }
}