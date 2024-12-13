package com.example.navigation.navigation.drawer

import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.navigation.navigation.Screens

@Composable
fun AppDrawer(
    modifier: Modifier = Modifier,
    selectedRoute: String,
    drawerItems: List<DrawerItem>,
    navigationTo:(Screens)-> Unit
) {

    ModalDrawerSheet {
        drawerItems.forEach { item->
            NavigationDrawerItem(
                label = {
                    Text(
                        text = item.name
                    )
                },
                selected = selectedRoute == item.route.toString(),
                onClick = {
                    navigationTo(item.route)
                },
                icon = {Icon(imageVector = item.icon,contentDescription = item.description) }

            )

        }
    }

}