package com.example.tzapp.presentation.screens.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.tzapp.R
import com.example.tzapp.presentation.components.MAX_PROGRESS
import com.example.tzapp.presentation.components.OnBoardingScreen
import com.example.tzapp.presentation.components.OnboardingType
import com.example.tzapp.presentation.components.SegmentedProgress
import com.example.tzapp.presentation.components.SpacerHeight
import com.example.tzapp.presentation.screens.ScreenByOnboardingTypeFactory
import com.example.tzapp.presentation.theme.ExtraLargeSpacing
import com.example.tzapp.presentation.theme.LargeSpacing
import com.example.tzapp.presentation.theme.LightBlue
import kotlinx.coroutines.launch

@Preview
@Composable
fun OnBoardingScreenPreview() {
    MaterialTheme {
        OnBoardingScreen()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier
) {
    val onBoardings = OnBoardingScreen.onBoardingType()
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState { onBoardings.size }
    val segmentProgress = MAX_PROGRESS / onBoardings.size.toFloat()
    var progress by rememberSaveable { mutableStateOf(segmentProgress) }
    var onboardingType by remember { mutableStateOf(OnboardingType.WELCOME) }
    val viewModel: OnBoardingViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.padding(horizontal = LargeSpacing)) {
            SpacerHeight(LargeSpacing)
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier.size(ExtraLargeSpacing),
                    painter = painterResource(id = R.drawable.absolude),
                    contentDescription = null
                )
                Text(
                    stringResource(id = R.string.absolude_pos),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(0.8f))
                if (onboardingType.shouldShowMissText()) {
                    Text(
                        modifier = Modifier.clickable {
                            progress += segmentProgress
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage.inc())
                            }
                        },
                        text = stringResource(id = R.string.miss),
                        style = MaterialTheme.typography.bodyMedium,
                        color = LightBlue,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            SpacerHeight(LargeSpacing)
            SegmentedProgress(
                segmentsSize = onBoardings.size.toFloat(),
                progress = progress,
            )
        }
        SpacerHeight(LargeSpacing)
        LaunchedEffect(key1 = pagerState.currentPage) {
            onboardingType = onBoardings[pagerState.currentPage].onboardingType
        }
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp),
            state = pagerState,
            userScrollEnabled = false
        ) { position ->
            val screen = onBoardings[position]
            ScreenByOnboardingTypeFactory(
                screen = screen,
                onNextPage = {
                    progress += segmentProgress
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage.inc())
                    }
                },
                onPreviousPage = {
                    progress -= segmentProgress
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage.dec())
                    }
                },
            )
        }
    }
}