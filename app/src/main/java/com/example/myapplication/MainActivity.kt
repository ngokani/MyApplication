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
    private var displayName by mutableStateOf("Android")
    private var enteredName by mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                    val focusManager = LocalFocusManager.current

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            NameTextField()
                            Spacer(modifier = Modifier.width(16.dp))
                            UpdateButton(focusManager)
                        }

                        // On Windows, Ctrl + Click `Greeting`, to see where it is defined
                        // On Mac, Cmd + Click `Greeting`, to see where it is defined
                        Greeting(
                            name = displayName, // Use the updated name
                            modifier = Modifier.padding(16.dp)
                        )
                    }
            }
        }
    }

    @Composable
    private fun NameTextField() {
        val focusManager = LocalFocusManager.current

        OutlinedTextField(
            value = enteredName,
            onValueChange = { enteredName = it },
            label = { Text(stringResource(R.string.name_label)) },
            placeholder = { Text(stringResource(R.string.enter_your_name_placeholder)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Right)
            }, onDone = {
                updateDisplayName()
                focusManager.clearFocus()
            })
        )
    }

    @Composable
    private fun UpdateButton(focusManager: FocusManager) {
        Button(onClick = {
            updateDisplayName()
            focusManager.clearFocus()
        }) {
            Text(text = stringResource(R.string.update_text))
        }
    }

    private fun updateDisplayName() {
        displayName = enteredName.trim().ifEmpty { "Android" }
        enteredName = ""
    }
}