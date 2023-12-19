package com.example.tzapp.presentation.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.tzapp.presentation.components.OnBoardingScreen
import com.example.tzapp.presentation.components.SpacerHeight
import com.example.tzapp.presentation.theme.Grey
import com.example.tzapp.presentation.theme.LargeSpacing
import com.example.tzapp.presentation.theme.MediumSpacing

@Composable
fun LastTypeScreen(
    scrollState: ScrollState,
    screen: OnBoardingScreen.LastTypeItem,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
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
    }
}