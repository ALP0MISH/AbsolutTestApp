package com.example.tzapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tzapp.R
import com.example.tzapp.presentation.screens.onboarding.OnboardingEvent
import com.example.tzapp.presentation.theme.ExtraLargeSpacing
import com.example.tzapp.presentation.theme.LabelSpacing
import com.example.tzapp.presentation.theme.LargeSpacing
import com.example.tzapp.presentation.theme.LightBlue
import com.example.tzapp.presentation.theme.MediumSpacing

@Preview
@Composable
fun BottomButtonPreview() {
    MaterialTheme {
        BottomButton(
            onNextPage = {},
            onPreviousPage = {},
            modifier = Modifier,
        )
    }
}

@Composable
fun BottomButton(
    enabled: Boolean = true,
    saveUser: (OnboardingEvent.OnUserSuccess) -> Unit = {},
    onNextPage: () -> Unit,
    onPreviousPage: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(top = LabelSpacing),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider()
        Column(
            modifier = Modifier.padding(horizontal = LargeSpacing)
        ) {
            SpacerHeight(LargeSpacing)
            Row(
                modifier = Modifier.padding(bottom = ExtraLargeSpacing),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedIconButton(
                    modifier = Modifier
                        .fillMaxWidth(0.11f)
                        .clip(CircleShape),
                    onClick = {
                        onPreviousPage()
                    },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrrow_back),
                        contentDescription = null
                    )
                }
                SpacerWidth(MediumSpacing)
                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.98f)
                        .height(40.dp)
                        .clip(CircleShape), onClick = {
                        onNextPage()
                        saveUser(OnboardingEvent.OnUserSuccess)

                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = LightBlue
                    ),
                    enabled = enabled
                ) {
                    Text(
                        text = stringResource(id = R.string.next),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White,
                    )
                }
            }
        }
    }
}