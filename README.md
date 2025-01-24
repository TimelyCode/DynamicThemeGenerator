
# `DynamicThemeGenerator` - Dynamic Color Scheme for Jetpack Compose

## What is `DynamicThemeGenerator`?
`DynamicThemeGenerator` is a utility class that helps you generate dynamic color schemes for your app’s UI using Jetpack Compose and Material 3. It uses the **HSL (Hue, Saturation, Lightness)** color model to generate colors, allowing for precise control over the colors' appearance in both light and dark modes.

## Why Use It?
Using `DynamicThemeGenerator` ensures that your app follows best practices for theming with Material 3, while providing an easy way to generate color schemes dynamically based on your input. It also saves time by automatically adjusting colors for both light and dark modes, so you don't have to manually tweak them for each mode.

### Key Benefits:
- **HSL-Based Colors**: The color generation is based on the HSL model, allowing for better control over hue, saturation, and lightness.
- **Light & Dark Mode Support**: Automatically generates colors for both modes based on your configurations.
- **Customizable**: Easily tweak saturation, lightness, and other aspects of your theme.
- **Material 3 Compatibility**: Designed to work seamlessly with Jetpack Compose and Material 3 components.

## How to Install and Use

1. **Add the class to your project**:
   - Create a new Kotlin file with the name `DynamicThemeGenerator.kt`.
   - Copy the entire code of `DynamicThemeGenerator` into that file.

2. **Using the generator in your app**:
   - In your `Activity` or `Composable`, call the `createColorScheme` method to generate a `ColorScheme`.
   - Pass a `hue` value and the desired theme mode (light or dark).
   - Optionally, pass a custom `ColorConfig` for further customization.

### Example Usage:

```kotlin
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable


@Composable
fun AppTheme() {
    val colorScheme = DynamicThemeGenerator.createColorScheme(
        hue = 210, // Choose your preferred hue (e.g., for blue)
        isDarkMode = false // Set true for dark mode
    )

    MaterialTheme(
        colorScheme = colorScheme
    ) {
        // Your UI elements here
    }
}
```

## Customization Options

- **Saturation**: Controls the intensity of the colors for the background and primary elements.
- **Lightness**: Adjusts the brightness for background, primary, text, and container elements, allowing for fine-tuned control over the look in both light and dark modes.
- **Predefined Lightness Configurations**: You can use pre-defined configurations like `AmoledLightness` for specific design styles (e.g., AMOLED screens).


## Code
You can find the code for `DynamicThemeGenerator.kt` [here](https://github.com/TimelyCode/DynamicThemeGenerator/blob/main/DynamicThemeGenerator.kt).
