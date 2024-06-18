package ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote.model.detail

import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName(value = "official-artwork") val officialArtwork: OfficialArtwork
)
