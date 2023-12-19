package com.example.tzapp.presentation.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.tzapp.presentation.theme.Grey
import com.example.tzapp.presentation.theme.LargeSpacing
import com.example.tzapp.presentation.theme.LightBlue
import com.example.tzapp.presentation.theme.MediumSpacing
import com.example.tzapp.presentation.theme.SmallSpacing
import com.example.tzapp.presentation.utils.validateInstitutionCityAndAddress

@Composable
fun CreateTypeScreen(
    screen: OnBoardingScreen.CreateTypeItem,
    onNextPage: () -> Unit,
    scrollState: ScrollState,
    uiState: OnboardingUiState,
    onEvent: (OnboardingEvent) -> Unit,
    onPreviesPage: () -> Unit,
    modifier: Modifier = Modifier
) {
    var checkedState by remember {
        mutableStateOf(true)
    }
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
            SpacerHeight(ExtraLargeSpacing)
            OnboardingTextField(modifier = Modifier,
                placeHolder = stringResource(id = R.string.institution_name),
                text = uiState.institutionName,
                onValueChange = { onEvent(OnboardingEvent.OnInstitutionNameChange(it)) })
            SpacerHeight(SmallSpacing)
            Text(
                modifier = Modifier.padding(start = LargeSpacing),
                text = stringResource(id = R.string.add_institution),
                style = MaterialTheme.typography.bodySmall,
                color = Grey
            )
            SpacerHeight(LargeSpacing)
            OnboardingTextField(modifier = Modifier,
                placeHolder = stringResource(id = R.string.city_and_country),
                text = uiState.cityName,
                onValueChange = {
                    onEvent(OnboardingEvent.OnCityChange(it))
                }
            )
            SpacerHeight(SmallSpacing)
            Text(
                modifier = Modifier.padding(start = LargeSpacing),
                text = stringResource(id = R.string.select_sity),
                style = MaterialTheme.typography.bodySmall,
                color = Grey
            )
            SpacerHeight(LargeSpacing)
            OnboardingTextField(modifier = Modifier,
                placeHolder = stringResource(id = R.string.address),
                text = uiState.address,
                onValueChange = { onEvent(OnboardingEvent.OnAddressChange(it)) })
            SpacerHeight(ExtraLargeSpacing)
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkedState, onCheckedChange = {
                        checkedState = !checkedState
                    }, modifier = Modifier, colors = CheckboxDefaults.colors(
                        checkedColor = LightBlue, checkmarkColor = Color.White
                    )
                )
                Column {
                    Text(
                        stringResource(id = screen.checkBoxTitle),
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        stringResource(id = screen.checkBoxDescription),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Grey
                    )
                }
            }
            if (!checkedState) {
                SpacerHeight(ExtraLargeSpacing)
                OnboardingTextField(modifier = Modifier,
                    placeHolder = stringResource(id = R.string.automation_system),
                    text = uiState.automationSystem,
                    onValueChange = { onEvent(OnboardingEvent.OnAutomationSystemChange(it)) })
                Text(
                    modifier = Modifier.padding(start = LargeSpacing),
                    text = stringResource(id = R.string.name_system),
                    style = MaterialTheme.typography.bodySmall,
                    color = Grey
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        BottomButton(
            enabled = validateInstitutionCityAndAddress(
                institution = uiState.institutionName,
                city = uiState.cityName,
                address = uiState.address
            ),
            onNextPage = onNextPage,
            onPreviousPage = onPreviesPage,
        )
    }
}