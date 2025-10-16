package com.example.qrbnb_superadmin.presentation.screen.clientDetails


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import qr_bnb_super_admin.composeapp.generated.resources.Res
import qr_bnb_super_admin.composeapp.generated.resources.addicon
import qr_bnb_super_admin.composeapp.generated.resources.profile
import qr_bnb_super_admin.composeapp.generated.resources.profilepic


@Composable
fun ClientAvatar(avatarUrl: String) {

    Image(
        painter = painterResource(Res.drawable.profilepic),
        contentDescription = "Client Avatar for ${avatarUrl}",

        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(128.dp)
            .clip(CircleShape)
            .background(Color(0xFFF0F0F0))
    )
}