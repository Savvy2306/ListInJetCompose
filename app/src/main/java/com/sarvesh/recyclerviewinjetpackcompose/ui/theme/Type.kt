package com.sarvesh.recyclerviewinjetpackcompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sarvesh.recyclerviewinjetpackcompose.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val HeadingMulishBold = Typography(
    titleSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_bold)),
        fontSize = 16.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_bold)),
        fontSize = 18.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_bold)),
        fontSize = 22.sp
    ),
)
val HeadingMerriweatherBlack = Typography(
    titleSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.merriweather_black)),
        fontSize = 16.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.merriweather_black)),
        fontSize = 18.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.merriweather_black)),
        fontSize = 22.sp
    ),
)
val ContentTextMulishBold = Typography(
    titleSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_bold)),
        fontSize = 12.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_bold)),
        fontSize = 14.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_bold)),
        fontSize = 16.sp
    ),
)
val ContentMulishRegular = Typography(
    titleSmall = TextStyle(
        color = LightGrey,
        fontFamily = FontFamily(Font(R.font.mulish_regular)),
        fontSize = 12.sp
    ),
    titleMedium = TextStyle(
        color = LightGrey,
        fontFamily = FontFamily(Font(R.font.mulish_regular)),
        fontSize = 14.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_regular)),
        fontSize = 16.sp
    ),
)