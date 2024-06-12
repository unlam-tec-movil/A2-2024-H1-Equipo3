package ar.edu.unlam.mobile.scaffolding.domain.model

data class Pokemon(val nombre: String = "?", val tipos: String = "", val imagen: Int = 0)

fun Pokemon.toTriviaOption() = TriviaOption(this, false)