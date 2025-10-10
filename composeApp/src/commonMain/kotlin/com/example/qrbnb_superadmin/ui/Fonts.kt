package com.example.qrbnb_superadmin.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font

import qr_bnb_super_admin.composeapp.generated.resources.Res
import qr_bnb_super_admin.composeapp.generated.resources.plusjakartasans_bold
import qr_bnb_super_admin.composeapp.generated.resources.plusjakartasans_regular


@Composable // <--- ADD THIS ANNOTATION
fun plusJakartaSans(): FontFamily {
    return FontFamily(
        // The Font() constructor is a Composable function.
        Font(Res.font.plusjakartasans_bold, FontWeight.W700),

        Font(Res.font.plusjakartasans_regular, FontWeight.W400)
    )
}

@Composable
fun headline22Bold(): TextStyle {
    return TextStyle(
        fontFamily = plusJakartaSans(), // Your custom font
        fontWeight = FontWeight.W700,         // font-weight: 700
        fontSize = 22.sp,                     // font-size: 22px
        lineHeight = 28.sp,                   // line-height: 28px
        letterSpacing = 0.sp,                 // letter-spacing: 0px (0.sp is the default)
        textAlign = TextAlign.Center          // text-align: center
        // Note: 'font-style: Bold' is represented by the FontWeight.W700 itself.
        // Note: 'leading-trim: NONE' is a CSS property and does not have a direct
        // equivalent in Compose Text API, but standard Compose line-height management
        // often provides the desired result.
    )
}
@Composable
fun  body16Regular(): TextStyle{
    return TextStyle(
        fontFamily = plusJakartaSans(), // Your custom font
        fontWeight = FontWeight.W400,         // font-weight: 700
        fontSize = 16.sp,                     // font-size: 22px
        lineHeight = 24.sp,                   // line-height: 28px
        letterSpacing = 0.sp,                 // letter-spacing: 0px (0.sp is the default)
        textAlign = TextAlign.Center

    )
}
@Composable
fun  jakarta_regular_14px(): TextStyle{
    return TextStyle(
        fontFamily = plusJakartaSans(), // Your custom font
        fontWeight = FontWeight.W400,         // font-weight: 700
        fontSize = 14.sp,                     // font-size: 22px
        lineHeight = 21.sp,                   // line-height: 28px
        letterSpacing = 0.sp,                 // letter-spacing: 0px (0.sp is the default)
        textAlign = TextAlign.Center

    )
}
@Composable
fun  Loginbtn_style(): TextStyle{
    return TextStyle(
        fontFamily = plusJakartaSans(), // Your custom font
        fontWeight = FontWeight.W700,         // font-weight: 700
        fontSize = 14.sp,                     // font-size: 22px
        lineHeight = 21.sp,                   // line-height: 28px
        letterSpacing = 0.sp,                 // letter-spacing: 0px (0.sp is the default)
        textAlign = TextAlign.Center

    )
}