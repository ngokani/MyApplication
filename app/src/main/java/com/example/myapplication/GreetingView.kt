package com.example.myapplication

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

/**
 * Displays a greeting message with the provided name.
 *
 * @param name The name to display in the greeting.
 * @param modifier Modifier to be applied to the greeting text.
 */
// This composable function displays a greeting message.
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {// Display the greeting text using the provided name and modifier.
    Text(
        text = stringResource(R.string.hello_name_text, name), // Formatted greeting text
        modifier = modifier // Apply any provided modifiers for customization
    )
}

// This composable function provides a preview of the Greeting composable.
@Preview(showBackground = true) // Show a background in the preview
@Composable
fun GreetingPreview() {
    // Apply the app's theme to the preview.
    MyApplicationTheme {
        // Display a Greeting with the name "Android".
        Greeting("Android")
    }
}