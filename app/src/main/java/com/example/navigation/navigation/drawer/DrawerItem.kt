package com.example.navigation.navigation.drawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.navigation.navigation.Screens


data class DrawerItem(
    val name: String,
    val icon: ImageVector,
    val description: String= "Description",
    val route: Screens
)

object DrawerParams{
    val drawerList = arrayListOf<DrawerItem>(
        DrawerItem(
            name = "Registration",
            icon = Icons.Default.Home,
            route = Screens.Registration
        ),
        DrawerItem(
            name = "Dashboard",
            icon = Icons.Default.Dashboard,
            route = Screens.Dashboard
        ),
        DrawerItem(
            name = "Entranz",
            icon = Icons.Default.Apps,
            route = Screens.Entranz
        ),
        DrawerItem(
            name = "Help",
            icon = Icons.Default.ChatBubble,
            route = Screens.Help
        ),
    )
}