package ar.edu.unlam.mobile.scaffolding

import ar.edu.unlam.mobile.scaffolding.Pokemon

class Usuario (val nickname:String = "Nickname", val coins:Int = 0){

    val userPokemons = mutableListOf<Pokemon>()

}