package com.example.navigation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navigation.navigation.drawer.AppDrawer
import com.example.navigation.navigation.drawer.DrawerParams
import com.example.navigation.presentation.dashboard.Dashboard
import com.example.navigation.presentation.entranz.Entranz
import com.example.navigation.presentation.help.Help
import com.example.navigation.presentation.registration.Registration
import com.example.navigation.presentation.registration.RegistrationViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: Screens.Registration.route

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(
                selectedRoute = currentRoute,
                drawerItems = DrawerParams.drawerList,
                navigationTo = { item->
                    if (item.route == Screens.Dashboard.route){
                        navController.navigate(item.route) {
                            popUpTo(item.route)

//                        launchSingleTop = true
//                        restoreState = true
                        }
                    }else{
                        navController.navigate(item.route)
                    }

                    coroutineScope.launch { drawerState.close() }

                }

            )
        }
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = { Text(text = currentRoute) },
                    modifier = Modifier.fillMaxWidth(),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch { drawerState.open() }
                        }, content = {
                            Icon(
                                imageVector = Icons.Default.Menu, contentDescription = null
                            )
                        })
                    },

                )

            }
        ){
            NavHost(
                modifier = Modifier
                    .padding(it),
                navController = navController,
                startDestination = Screens.Registration.route
            ) {
                composable(Screens.Registration.route){
                    val registrationViewModel = hiltViewModel<RegistrationViewModel>()
                    Registration(
                        state = registrationViewModel.registrationState,
                        onAction = registrationViewModel::onRegistrationEvent
                    )

                }
                composable(Screens.Dashboard.route){
                    Dashboard()
                }
                composable(Screens.Entranz.route){
                    Entranz()
                }
                composable(Screens.Help.route){
                    Help()
                }
            }

        }

    }



}