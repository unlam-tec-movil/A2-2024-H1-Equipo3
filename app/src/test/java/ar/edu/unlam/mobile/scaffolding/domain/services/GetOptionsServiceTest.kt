package ar.edu.unlam.mobile.scaffolding.domain.services

import ar.edu.unlam.mobile.scaffolding.domain.usecases.PokemonRepository
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetOptionsUseCase
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class GetOptionsServiceTest {

    private lateinit var getOptionsService: GetOptionsUseCase
    private val pokemonRepository: PokemonRepository = FakePokemonRepository()
    @Before
    fun setUp() {
        getOptionsService = GetOptionsService(pokemonRepository)
    }

    @Test
    fun `getOptions should return 4 options`() {
        val options = getOptionsService.getOptions()
        assertEquals(4, options.size)
    }

    @Test
    fun `getOptions should return 4 different options`() {
        val options = getOptionsService.getOptions()
        val distinctOptions = options.distinctBy { it.option }
        assertEquals(4, distinctOptions.size)
    }

    @Test
    fun `getOptions should return 1 correct option`() {
        val options = getOptionsService.getOptions()
        val correctOptions = options.filter { it.isCorrect }
        assertEquals(1, correctOptions.size)
    }

    @Test
    fun `getOptions should return 3 incorrect options`() {
        val options = getOptionsService.getOptions()
        val incorrectOptions = options.filter { !it.isCorrect }
        assertEquals(3, incorrectOptions.size)
    }

    @Test
    fun `getOptions should return shuffled options`() {
        val optionsWithoutShuffle = pokemonRepository.getOptions().take(4)
        val options = getOptionsService.getOptions()
        assertNotEquals(options, optionsWithoutShuffle)
    }
}