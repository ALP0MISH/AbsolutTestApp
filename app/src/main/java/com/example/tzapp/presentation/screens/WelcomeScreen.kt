package com.example.tzapp.presentation.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.tzapp.R
import com.example.tzapp.presentation.components.OnBoardingScreen
import com.example.tzapp.presentation.components.OnboardingTextField
import com.example.tzapp.presentation.components.SpacerHeight
import com.example.tzapp.presentation.screens.onboarding.OnboardingEvent
import com.example.tzapp.presentation.screens.onboarding.OnboardingUiState
import com.example.tzapp.presentation.theme.ExtraLargeSpacing
import com.example.tzapp.presentation.theme.Grey
import com.example.tzapp.presentation.theme.LabelSpacing
import com.example.tzapp.presentation.theme.LargeSpacing
import com.example.tzapp.presentation.theme.LightBlue
import com.example.tzapp.presentation.theme.MediumSpacing
import com.example.tzapp.presentation.utils.validateNameAndEmail

@Composable
fun WelcomeScreen(
    screen: OnBoardingScreen.WelcomeTypeItem,
    onEvent: (OnboardingEvent) -> Unit,
    uiState: OnboardingUiState,
    onNextPage: () -> Unit,
    scrollState: ScrollState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = LargeSpacing),
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
        OnboardingTextField(
            modifier = Modifier,
            placeHolder = stringResource(id = R.string.your_name),
            text = uiState.name,
            onValueChange = {
                onEvent(OnboardingEvent.OnNameChange(it))
            },
        )
        SpacerHeight(ExtraLargeSpacing)
        OnboardingTextField(
            modifier = Modifier,
            placeHolder = stringResource(id = R.string.your_number),
            text = uiState.emailOrNumber,
            onValueChange = { onEvent(OnboardingEvent.OnEmailChange(it)) },
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            enabled = validateNameAndEmail(
                name = uiState.name,
                email = uiState.emailOrNumber
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = ExtraLargeSpacing,
                    top = LabelSpacing
                )
                .clip(CircleShape),
            onClick = { onNextPage() },
            colors = ButtonDefaults.buttonColors(
                containerColor = LightBlue
            )
        ) {
            Text(
                text = stringResource(id = R.string.next),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
    }
}