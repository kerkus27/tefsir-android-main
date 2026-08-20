package com.tefsir.app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tefsir.app.feature.dhikr.DhikrScreen
import com.tefsir.app.feature.home.HomeScreen
import com.tefsir.app.feature.prayertimes.PrayerTimesScreen
import com.tefsir.app.feature.profile.MoreScreen
import com.tefsir.app.feature.quran.QuranScreen

@Composable
fun TefsirNavHost(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { TefsirBottomBar(navController) },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = TefsirDestination.Home.route,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(TefsirDestination.Home.route) { HomeScreen() }
            composable(TefsirDestination.PrayerTimes.route) { PrayerTimesScreen() }
            composable(TefsirDestination.Quran.route) { QuranScreen() }
            composable(TefsirDestination.Dhikr.route) { DhikrScreen() }
            composable(TefsirDestination.More.route) { MoreScreen() }
        }
    }
}

@Composable
private fun TefsirBottomBar(navController: NavHostController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination

    NavigationBar {
        TefsirDestination.entries.forEach { destination ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == destination.route } == true
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(destination.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(destination.icon, contentDescription = null) },
                label = { Text(stringResource(destination.labelRes)) },
            )
        }
    }
}
