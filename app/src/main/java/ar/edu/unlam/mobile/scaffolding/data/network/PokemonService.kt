package ar.edu.unlam.mobile.scaffolding.data.network

import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote.model.detail.PokemonResponse
import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote.model.list.PokemonListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon")
    suspend fun getPokemons(@Query("limit") limit: Int, @Query("offset")offset: Int): PokemonListDto

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: String): PokemonResponse

}