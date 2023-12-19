package com.example.tzapp.presentation.screens

import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.tzapp.presentation.components.OnBoardingScreen
import com.example.tzapp.presentation.screens.onboarding.OnBoardingViewModel

@Composable
fun ScreenByOnboardingTypeFactory(
    screen: OnBoardingScreen,
    onNextPage: () -> Unit,
    onPreviousPage: () -> Unit,
) {
    val scrollState = rememberScrollState()
    val viewModel: OnBoardingViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    return when (screen) {
        is OnBoardingScreen.WelcomeTypeItem -> {
            WelcomeScreen(
                screen = screen,
                onNextPage = onNextPage,
                scrollState = scrollState,
                onEvent = viewModel::onEvent,
                uiState = uiState
            )
        }

        is OnBoardingScreen.CreateTypeItem -> {
            CreateTypeScreen(
                onNextPage = onNextPage,
                onPreviesPage = onPreviousPage,
                screen = screen,
                scrollState = scrollState,
                uiState =uiState,
                onEvent = viewModel::onEvent
            )
        }

        is OnBoardingScreen.SelectInstitutionTypeItem -> {
            SelectInstitutionTypeScreen(
                onNextPage = onNextPage,
                onPreviesPage = onPreviousPage,
                screen = screen,
                scrollState = scrollState,
                onEvent = viewModel::onEvent
            )
        }

        is OnBoardingScreen.InstitutionTypeItem -> {
            InstitutionTypeScreen(
                onNextPage = onNextPage,
                onPreviesPage = onPreviousPage,
                screen = screen,
                scrollState = scrollState,
                uiState =uiState,
                onEvent = viewModel::onEvent
            )
        }

        is OnBoardingScreen.ProvideInstitutionTypeItem -> {
            ProvideInstitutionTypeScreen(
                onNextPage = onNextPage,
                onPreviesPage = onPreviousPage,
                screen = screen,
                saveUser = viewModel::onEvent,
                scrollState = scrollState,
                onEvent = viewModel::onEvent
            )
        }

        is OnBoardingScreen.LastTypeItem -> {
            LastTypeScreen(
                screen = screen,
                scrollState = scrollState
            )
        }
    }
}