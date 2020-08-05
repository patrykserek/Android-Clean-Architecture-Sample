package pl.akademiaandroida.android_clean_architecture_sample.core.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.data.repository.CharacterRepositoryImpl
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.CharacterRepository
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.GetCharactersUseCase
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.presentation.CharactersFragment
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.presentation.CharactersViewModel
import pl.akademiaandroida.android_clean_architecture_sample.features.data.RickAndMortyRepositoryImpl
import pl.akademiaandroida.android_clean_architecture_sample.features.domain.RickAndMortyRepository
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.data.repository.EpisodeRepositoryImpl
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.EpisodeRepository
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.GetEpisodesUseCase
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.presentation.EpisodeAdapter
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.presentation.EpisodesFragment
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.presentation.EpisodesViewModel
import pl.akademiaandroida.android_clean_architecture_sample.features.location.data.repository.LocationRepositoryImpl
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.GetLocationsUseCase
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.LocationRepository
import pl.akademiaandroida.android_clean_architecture_sample.features.location.presentation.LocationViewModel
import pl.akademiaandroida.android_clean_architecture_sample.features.location.presentation.LocationsFragment

val featuresModule = module {
    single<RickAndMortyRepository> { RickAndMortyRepositoryImpl(get(), get(), get()) }

    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get()) }
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get()) }
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get()) }

    factory { GetEpisodesUseCase(get()) }
    factory { GetCharactersUseCase(get()) }
    factory { GetLocationsUseCase(get()) }

    scope(named<CharactersFragment>()) {
        viewModel { CharactersViewModel(get()) }
    }

    scope(named<EpisodesFragment>()) {
        viewModel { EpisodesViewModel(get()) }
        factory { EpisodeAdapter() }
    }

    scope(named<LocationsFragment>()) {
        viewModel { LocationViewModel(get()) }
    }

}