package com.example.m3textfields

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.m3textfields.ui.theme.M3TextFieldsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            M3TextFieldsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TextFields(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFields(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var textValue by remember {
            mutableStateOf("")
        }

        TextField(
            value = textValue,
            onValueChange = {
                textValue = it
            },
            //readOnly = true, // user can still copy the value
            //enabled = false, // user cannot copy the value
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black
            ),
            label = {
                Text(text = "Enter your age")
            },
            placeholder = {
                Text(text = "Age")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.DateRange,
                    contentDescription = "Enter your age"
                )
            },
            suffix = {
                Text(text = "year(s)")
            },
            supportingText = {
                Text(text = if (textValue.length > 2) "too old" else "*required")
            },
            isError = textValue.length > 2,
            //visualTransformation = PasswordVisualTransformation()
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = textValue,
            onValueChange = {
                textValue = it
            },
            label = {
                Text(text = "Enter your age")
            },
            placeholder = {
                Text(text = "Age")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.DateRange,
                    contentDescription = "Enter your age"
                )
            },
            suffix = {
                Text(text = "year(s)")
            },
            supportingText = {
                Text(text = if (textValue.length > 2) "too old" else "*required")
            },
            isError = textValue.length > 2,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    // close keyboard and use the entered value
                }
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    M3TextFieldsTheme {
        TextFields(modifier = Modifier.fillMaxSize())
    }
}