# Android Development Starter Project
This project is a simple Android application built with Jetpack Compose, designed to help beginners get started with Android development. It showcases basic concepts and best practices for building modern Android UIs.

## Features
*   **Jetpack Compose:** The entire UI is built using Jetpack Compose, a modern toolkit for building native Android UIs in a declarative way.
*   **State Management:** Demonstrates how to manage UI state using `remember` and `mutableStateOf`.
*   **Layout:** Shows how to use basic layout composables like `Column` and `Row` to arrange UI elements.
*   **Text Input:** Includes an `OutlinedTextField` for user input and handling text changes.
*   **Button Interaction:** Demonstrates how to create a button and handle click events.
*   **Focus Management:** Shows how to use `FocusManager` to control focus within UI elements.
*   **Theming:** Provides a basic example of applying a theme to the UI.
*   **Previews:** Includes a preview composable to visualise the UI during development.

## Code Overview
Here's a breakdown of the key code files and components:
*   **`MainActivity.kt`:** The main activity of the app, responsible for setting up the UI. [See code](app/src/main/java/com/example/myapplication/MainActivity.kt#L38)
*   **`DisplayNameScreen.kt`:** A composable function that creates the main screen of the app, including the name input field and greeting message. [See code](app/src/main/java/com/example/myapplication/MainActivity.kt#L64)
*   **`NameInputRow.kt`:** A composable function that creates a row containing the text input field and update button. [See code](app/src/main/java/com/example/myapplication/MainActivity.kt#L109)
*   **`Greeting.kt`:** A composable function that displays a greeting message. [See code](app/src/main/java/com/example/myapplication/GreetingView.kt#L18)

## Project Structure
*   **`res/values`:** This directory contains XML files that define various resources used in your app, such as strings, colors, styles, and dimensions. These resources help you manage and organise the styling and text content of your app in a centralised way.
    *   **`strings.xml`:** Stores text strings used throughoutyour app, allowing for easy localisation and translation. You can define placeholders within your strings to dynamically insert values at runtime.
    *   **`colors.xml`:** Defines color values used for theming and styling your UI elements. You can define colors in various formats (hexadecimal, RGB, ARGB) and reference them by name in your layouts and composables.
    *   **`styles.xml`:** Contains style definitions that define the appearance of UI components, helping you maintain a consistent look and feel across your app. Styles can inherit from other styles, allowing you to create a hierarchy of styles and reuse common attributes.
    *   **`dimens.xml`:** Stores dimension values (e.g., margins, padding) used for layout and spacing, ensuring consistency across different screen sizes. Defining dimensions in this file allows you to easily adjust spacing and sizes for different screen densities.
*   **`res/drawable`:** This directory holds images and other drawable resources used in your app. These can include icons, background images, and other graphical assets. You can organise drawables into subdirectories for better management.
    *   **Vector Drawables:** Consider using vector drawables whenever possible as they scale without losing quality and reduce the overall size of your app.
*   **`res/mipmap`:** This directory is specifically for app launcher icons. It contains different versions of your app icon at various resolutions to support different screen densities. Android automatically selects the appropriate icon based on the device's screen density.
*   **`AndroidManifest.xml`:** This file is the core configuration file for your Android app. It declares essential information about your app, such as its package name, components (activities, services, broadcast receivers, content providers), permissions, and hardware/software requirements. Understanding the `AndroidManifest.xml` is crucial for configuring how your app interacts with the Android system.
*   **`Gradle Build Files`:** Gradle is the build system used for Android projects. The build files (typically `build.gradle` at the project and module level) define dependencies, build configurations, and other settings for your app. Learning the basics of Gradle is essential for managing external libraries and customizing the build process.

## Getting Started
1.  **Clone the Repository:** Clone this repository to your local machine using Git:
    ```
    git clone https://github.com/ngokani/MyApplication.git
    ```
2.  **Open in Android Studio:** Open the project in Android Studio, which is the official IDE for Android development.
3.  **Build and Run:** Build the project and run it on an Android emulator or a physical Android device connected to your computer.

## Key Concepts for Beginners
*   **Activities:** Activities represent single screens in your app. They are the primary way users interact with your application.
*   **Layouts:** Layouts define the structure and arrangement of UI elements on a screen. You can use XML or Jetpack Compose to create layouts.
*   **Views:** Views are the basic building blocks of UI elements, such as text views, buttons, and images.
*   **Intents:** Intents are messages that allow you to start activities, services, or broadcast receivers. They are used for communication between different components of your app.
*   **Data Persistence:** Learn about different ways to store data in your app, such as using Shared Preferences, databases (like Room), or files.

## Useful Resources
*   **Android Developer Documentation:** The official documentation is your go-to resource for everything Android: [https://developer.android.com/](https://developer.android.com/)
*   **Jetpack Compose Basics:** [https://developer.android.com/jetpack/compose/tutorial](https://developer.android.com/jetpack/compose/tutorial)
*   **State in Compose:** [https://developer.android.com/jetpack/compose/state](https://developer.android.com/jetpack/compose/state)
*   **Layouts in Compose:** [https://developer.android.com/jetpack/compose/layouts](https://developer.android.com/jetpack/compose/layouts)
*   **Text Fields in Compose:** [https://developer.android.com/jetpack/compose/text](https://developer.android.com/jetpack/compose/text)
*   **Buttons in Compose:** [https://developer.android.com/jetpack/compose/components/button](https://developer.android.com/jetpack/compose/components/button)

## Contributing
Contributions are welcome! Feel free to open issues or pull requests to suggest improvements or add new features.