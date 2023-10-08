package com.example.waterinquiry.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.waterinquiry.ui.theme.Border
import com.example.waterinquiry.ui.theme.Primary


@Composable
fun AppThemeTextField(
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    textFieldValue: TextFieldValue,
    onTextFieldValueChange: (TextFieldValue) -> Unit,
    placeholder: @Composable (() -> Unit)? = null,
    singleLine: Boolean = true,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    OutlinedTextField(
        leadingIcon = leadingIcon,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        placeholder = placeholder,
        modifier = modifier.background(Color.White, shape = RoundedCornerShape(10.dp)).height(51.dp),
        value = textFieldValue,
        onValueChange = onTextFieldValueChange,
        singleLine = singleLine,
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Border,
            unfocusedBorderColor = Border,
        ),
        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Start, fontSize = 15.sp)
    )
}