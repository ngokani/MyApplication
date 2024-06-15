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


// This is the main activity of your Android app. It's the entry point for the user
// to interact with your application.
class MainActivity : ComponentActivity() {

    // This method is called when the activity is created. It's where you set up
    // the initial UI and perform any necessary setup.
    override fun onCreate(savedInstanceState: Bundle?) {
        // Call the superclass method to ensure proper initialization.
        super.onCreate(savedInstanceState)

        // Configure the activity to extend its layout to the edges of the screen.
        enableEdgeToEdge()

        // Set the content of the activity using Jetpack Compose.
        // Compose is a modern toolkit for building UIs in Android.
        setContent {
            // Apply your app's theme to the content. Themes define the look and feel
            // of your UI elements.
            MyApplicationTheme {
                // This composable function is responsible for displaying content
                // on the screen, such as the user's name.
                DisplayNameScreen()
            }
        }
    }
}

@Composable
fun DisplayNameScreen() {
    // State variable to store the displayed name, initially "Android"
    var displayName by remember { mutableStateOf("Android") }

    // State variable to store the text entered by the user
    var enteredName by remember { mutableStateOf("") }

    // Get the FocusManager to control focus of UI elements
    val focusManager = LocalFocusManager.current

    // Arrange UI elements vertically
    Column(
        modifier = Modifier
            .fillMaxWidth() // Fill the available width
            .fillMaxHeight() // Fill the available height
            .padding(16.dp), // Add padding around the Column
        horizontalAlignment = Alignment.CenterHorizontally, // Center horizontally
        verticalArrangement = Arrangement.Center // Center vertically
    ) {
        // Custom composable for entering and updating a name
        NameInputRow(
            enteredName = enteredName, // Pass the entered name
            onNameChange = { enteredName = it }, // Update enteredName when text changes
            onUpdateClick = {
                displayName = enteredName.trim().ifEmpty { "Android" } // Update displayName
                enteredName = "" // Clear the entered text
                focusManager.clearFocus() // Clear focus from input field
            },
            focusManager = focusManager // Pass the FocusManager
        )

        // You can add multiple NameInputRow calls here,
        // but they would function independently with their own state.

        // This is a Custom composable to display a greeting message.
        // On Windows, Ctrl + Click `Greeting`, to see where it is defined
        // On Mac, Cmd + Click `Greeting`, to see where it is defined
        Greeting(
            name = displayName, // Pass the displayed name
            modifier = Modifier.padding(16.dp) // Add padding around the greeting
        )
    }
}

@Composable
fun NameInputRow(
    enteredName: String, // Text entered by the user
    onNameChange: (String) -> Unit, // Callback when entered text changes
    onUpdateClick: () -> Unit, // Callback when Update button is clicked
    focusManager: FocusManager // Used to control focus
) {
    // Arrange the text field and button horizontally
    Row(verticalAlignment = Alignment.CenterVertically){
        // Text field for entering a name
        OutlinedTextField(
            value = enteredName, // Current text in the text field
            onValueChange = onNameChange, // Called when text changes
            label = { Text(stringResource(R.string.name_label)) }, // Label for the text field
            placeholder = { Text(stringResource(R.string.enter_your_name_placeholder)) }, // Placeholder text. Visible when the text field is empty.
            singleLine = true, // Single-line text field
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done), // Show "Done" action on keyboard
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Next) }, // Move focus when "Next" is pressed
                onDone = { onUpdateClick() } // Call onUpdateClick when "Done" is pressed
            ),
            modifier = Modifier.weight(1f) // Occupy available space
        )
        // Space between the text field and the button
        Spacer(modifier = Modifier.width(16.dp))
        // Button to update the displayed name
        Button(onClick = onUpdateClick) { // Call onUpdateClick when clicked
            Text(text = stringResource(R.string.update_text)) // Text on the button
        }
    }
}