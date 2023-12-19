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
import com.example.tzapp.presentation.theme.LabelSpacing
import com.example.tzapp.presentation.theme.LargeSpacing
import com.example.tzapp.presentation.theme.LightBlue

@Composable
fun ProvideInstitutionTypeScreen(
    screen: OnBoardingScreen.ProvideInstitutionTypeItem,
    scrollState: ScrollState,
    saveUser: (OnboardingEvent.OnUserSuccess) -> Unit = {},
    onNextPage: () -> Unit,
    onEvent: (OnboardingEvent) -> Unit,
    onPreviesPage: () -> Unit,
    modifier: Modifier = Modifier
) {
    var takeAwayState by rememberSaveable { mutableStateOf(false) }
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
            SpacerHeight(LabelSpacing)
            Row(
                modifier = Modifier.clickable { takeAwayState = !takeAwayState },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.restaurant_icon),
                    contentDescription = null
                )
                SpacerWidth(LargeSpacing)
                Text(
                    text = stringResource(id = R.string.takeaway),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(0.8f))
                Checkbox(
                    checked = takeAwayState,
                    onCheckedChange = {
                        takeAwayState = it
                        onEvent(OnboardingEvent.OnTakeAwayChange(value = it))
                    },
                    modifier = Modifier,
                    colors = CheckboxDefaults.colors(
                        checkedColor = LightBlue,
                        checkmarkColor = Color.White,
                        disabledCheckedColor = Color.Black,
                        disabledUncheckedColor = Color.Black,
                        disabledIndeterminateColor = Color.Black
                    )
                )
            }
            Divider()
            var inInstitutionState by rememberSaveable { mutableStateOf(false) }
            Row(
                modifier = Modifier.clickable { inInstitutionState = !inInstitutionState },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.bar_icon),
                    contentDescription = null
                )
                SpacerWidth(LargeSpacing)
                Text(
                    text = stringResource(id = R.string.in_institution),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(0.8f))
                Checkbox(
                    checked = inInstitutionState,
                    onCheckedChange = {
                        inInstitutionState = it
                        onEvent(OnboardingEvent.OnInInstitutionChange(value = it))
                    },
                    modifier = Modifier,
                    colors = CheckboxDefaults.colors(
                        checkedColor = LightBlue,
                        checkmarkColor = Color.White
                    )
                )
            }
            Divider()
            var deliveryState by rememberSaveable { mutableStateOf(false) }
            Row(
                modifier = Modifier.clickable { deliveryState = !deliveryState },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.coffee_icon),
                    contentDescription = null
                )
                SpacerWidth(LargeSpacing)
                Text(
                    text = stringResource(id = R.string.delivery),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(0.8f))
                Checkbox(
                    checked = deliveryState,
                    onCheckedChange = {
                        deliveryState = it
                        onEvent(OnboardingEvent.OnDeliveryChange(value = it))
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
            saveUser = saveUser,
            onNextPage = onNextPage,
            onPreviousPage = onPreviesPage
        )
    }
}