package ar.edu.unlam.mobile.scaffolding.domain.model

data class Pokemon(val id: String,val name: String = "?", val image: String = "")

fun Pokemon.toTriviaOption() = TriviaOption(this.copy(name = name.uppercase()), false)