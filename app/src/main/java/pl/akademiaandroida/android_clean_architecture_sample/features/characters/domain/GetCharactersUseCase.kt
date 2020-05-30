package pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain

import pl.akademiaandroida.android_clean_architecture_sample.core.domain.UseCase
import pl.akademiaandroida.android_clean_architecture_sample.features.domain.RickAndMortyRepository

class GetCharactersUseCase(private val repository: RickAndMortyRepository) :
    UseCase<List<Character>, Unit>() {

    override suspend fun action(params: Unit) = repository.getCharacters()

}