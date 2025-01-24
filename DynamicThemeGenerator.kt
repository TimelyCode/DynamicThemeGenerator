package com.timelycode.notedly

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color


object DynamicThemeGenerator {

    data class ColorConfig(
        val saturation: SaturationConfig = SaturationConfig(),
        val lightness: LightnessConfig = LightnessConfig(),
    )

    data class SaturationConfig(
        val background: Float = 0.05f,
        val primary: Float = 0.85f
    )

    data class LightnessConfig(
        val background: ThemeLightness = ThemeLightness(light = 0.96f, dark = 0.02f),
        val primary: ThemeLightness = ThemeLightness(light = 0.42f, dark = 0.70f),
        val primaryContainer: ThemeLightness = ThemeLightness(light = 0.82f, dark = 0.18f),
        val text: ThemeLightness = ThemeLightness(light = 0.02f, dark = 0.98f),
        val outline: ThemeLightness = ThemeLightness(
            light = background.light - 0.1f,
            dark = background.dark + 0.1f
        )
    )

    data class ThemeLightness(val light: Float, val dark: Float)

    private fun generateColor(
        hue: Int,
        saturation: Float,
        isDarkMode: Boolean,
        lightnessConfig: ThemeLightness
    ): Color = Color.hsl(
        hue.toFloat(),
        saturation,
        if (isDarkMode) lightnessConfig.dark else lightnessConfig.light
    )

    fun createColorScheme(
        hue: Int,
        isDarkMode: Boolean,
        config: ColorConfig = ColorConfig()
    ): ColorScheme {
        val primaryColor = generateColor(
            hue = hue,
            saturation = config.saturation.primary,
            isDarkMode = isDarkMode,
            lightnessConfig = config.lightness.primary
        )

        val secondaryColor = generateColor(
            hue = (hue + 60) % 360,
            saturation = config.saturation.primary,
            isDarkMode = isDarkMode,
            lightnessConfig = config.lightness.primary
        )

        val tertiaryColor = generateColor(
            hue = (hue - 60) % 360,
            saturation = config.saturation.primary,
            isDarkMode = isDarkMode,
            lightnessConfig = config.lightness.primary
        )

        val tertiaryContainerColor = generateColor(
            hue = (hue - 60) % 360,
            saturation = config.saturation.primary,
            isDarkMode = isDarkMode,
            lightnessConfig = config.lightness.primaryContainer
        )
        val primaryContainerColor = generateColor(
            hue = hue,
            saturation = config.saturation.primary,
            isDarkMode = isDarkMode,
            lightnessConfig = config.lightness.primaryContainer
        )
        val secondaryContainerColor = generateColor(
            hue = (hue + 60) % 360,
            saturation = config.saturation.primary,
            isDarkMode = isDarkMode,
            lightnessConfig = config.lightness.primaryContainer
        )


        val backgroundColor = generateColor(
            hue = hue,
            saturation = config.saturation.background,
            isDarkMode = isDarkMode,
            lightnessConfig = config.lightness.background
        )

        val textColor = generateColor(
            hue = hue,
            saturation = config.saturation.primary,
            isDarkMode = isDarkMode,
            lightnessConfig = config.lightness.text
        )

        val containerColors = listOf(-0.01f, -0.03f, -0.05f, -0.07f, -0.09f)
            .map { offset ->
                generateColor(
                    hue = hue,
                    saturation = config.saturation.background,
                    isDarkMode = isDarkMode,
                    lightnessConfig = ThemeLightness(
                        light = config.lightness.background.light + offset,
                        dark = config.lightness.background.dark - offset
                    )
                )
            }

        val errorColor = generateColor(
            hue = 0,
            saturation = config.saturation.primary,
            isDarkMode = isDarkMode,
            lightnessConfig = config.lightness.primary
        )

        return ColorScheme(
            primary = primaryColor,
            onPrimary = backgroundColor,
            primaryContainer = primaryContainerColor,
            onPrimaryContainer = textColor,
            inversePrimary = primaryContainerColor,
            secondary = secondaryColor,
            onSecondary = backgroundColor,
            secondaryContainer = secondaryContainerColor,
            onSecondaryContainer = textColor,
            tertiary = tertiaryColor,
            onTertiary = backgroundColor,
            tertiaryContainer = tertiaryContainerColor,
            onTertiaryContainer = textColor,
            background = backgroundColor,
            onBackground = textColor,
            surface = backgroundColor,
            onSurface = textColor,
            surfaceVariant = containerColors[2],
            onSurfaceVariant = textColor,
            surfaceTint = primaryColor,
            inverseSurface = textColor,
            inverseOnSurface = backgroundColor,
            error = errorColor,
            onError = backgroundColor,
            errorContainer = generateColor(
                hue = 0,
                saturation = config.saturation.primary,
                isDarkMode = isDarkMode,
                lightnessConfig = config.lightness.primaryContainer
            ),
            onErrorContainer = textColor,
            outline = generateColor(
                hue = hue,
                saturation = config.saturation.background,
                isDarkMode = isDarkMode,
                lightnessConfig = config.lightness.outline
            ),
            outlineVariant = generateColor(
                hue = hue,
                saturation = config.saturation.background,
                isDarkMode = isDarkMode,
                lightnessConfig = config.lightness.outline
            ),
            scrim = backgroundColor,
            surfaceContainerLowest = containerColors[0],
            surfaceContainerLow = containerColors[1],
            surfaceContainer = containerColors[2],
            surfaceContainerHigh = containerColors[3],
            surfaceContainerHighest = containerColors[4],
            surfaceBright = backgroundColor,
            surfaceDim = backgroundColor
        )
    }


    val AmoledLightness = LightnessConfig(
        background = ThemeLightness(light = 0.99f, dark = 0.01f),
        primary = ThemeLightness(light = 0.42f, dark = 0.70f),
        primaryContainer = ThemeLightness(light = 0.82f, dark = 0.18f),
        text = ThemeLightness(light = 0f, dark = 1f),
    )
}

