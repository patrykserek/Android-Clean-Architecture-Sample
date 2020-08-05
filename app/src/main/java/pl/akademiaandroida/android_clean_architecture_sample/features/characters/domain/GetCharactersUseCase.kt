package pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain

import pl.akademiaandroida.android_clean_architecture_sample.core.domain.UseCase

class GetCharactersUseCase(private val repository: CharacterRepository) :
    UseCase<List<Character>, Unit>() {

    override suspend fun action(params: Unit) = repository.getCharacters()

}