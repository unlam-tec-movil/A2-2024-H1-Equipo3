package ar.edu.unlam.mobile.scaffolding

sealed class NavigationRoutes(val route: String) {
    data object Menu : NavigationRoutes(route = "menu")
    data object StartGame : NavigationRoutes(route = "start_game")
    data object GameHistory : NavigationRoutes(route = "game_history")

    data object FinishGame : NavigationRoutes(route = "finish_game/{game_score}")
}