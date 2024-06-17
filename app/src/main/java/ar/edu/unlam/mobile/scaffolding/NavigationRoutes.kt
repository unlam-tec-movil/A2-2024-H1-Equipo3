package ar.edu.unlam.mobile.scaffolding

sealed class NavigationRoutes(val route: String) {
    data object Menu : NavigationRoutes(route = "menu")
    data object StartGame : NavigationRoutes(route = "start_game")
    data object GameHistory : NavigationRoutes(route = "game_history")
}