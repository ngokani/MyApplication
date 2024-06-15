package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                DisplayNameScreen()
            }
        }
    }
}

@Composable
fun DisplayNameScreen() {
    var displayName by remember { mutableStateOf("Android") }
    var enteredName by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        NameInputRow(
            enteredName = enteredName,
            onNameChange = { enteredName = it },
            onUpdateClick = {
                displayName = enteredName.trim().ifEmpty { "Android" }
                enteredName = ""
                focusManager.clearFocus() // Clear focus after updating
            },
            focusManager = focusManager
        )

        // You can add multiple NameInputRow calls here,
        // but they would function independently with their own state.
        // Both, would update `Greeting`, below


        // On Windows, Ctrl + Click `Greeting`, to see where it is defined
        // On Mac, Cmd + Click `Greeting`, to see where it is defined
        Greeting(
            name = displayName,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun NameInputRow(
    enteredName: String,
    onNameChange: (String) -> Unit,
    onUpdateClick: () -> Unit,
    focusManager: FocusManager
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            value = enteredName,
            onValueChange = onNameChange,
            label = { Text(stringResource(R.string.name_label)) },
            placeholder = { Text(stringResource(R.string.enter_your_name_placeholder)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Right) },
                onDone = { onUpdateClick() } // Call onUpdateName when Done is pressed
            ),
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Button(onClick = onUpdateClick) { // Use onUpdateClick for the button click
            Text(text = stringResource(R.string.update_text))
        }
    }
}