package com.example.tzapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tzapp.presentation.theme.Grey

@Preview
@Composable
fun OnboardingTextFieldPreview() {
    OnboardingTextField(
        placeHolder = String(),
        onValueChange = {},
        text = String(),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingTextField(
    placeHolder: String,
    onValueChange: (String) -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = TextFieldDefaults.textFieldColors(
            disabledIndicatorColor = Color.Gray,
            focusedIndicatorColor = Color.Gray,
            unfocusedIndicatorColor = Color.Gray,
            disabledTextColor = Color.Gray,
            disabledLabelColor = Color.Gray,
            unfocusedLabelColor = Color.Gray,
            containerColor = Color.Transparent,
            cursorColor = Color.Gray,
            errorIndicatorColor = Color.Red,
            errorLabelColor = Color.Red,
            errorCursorColor = Color.Red
        ),
        maxLines = 1,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text
        ),
        placeholder = {
            Text(
                text = placeHolder,
                style = MaterialTheme.typography.bodyMedium,
                color = Grey,
            )
        },
    )
}