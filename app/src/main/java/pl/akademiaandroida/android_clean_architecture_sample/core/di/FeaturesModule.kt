package pl.akademiaandroida.android_clean_architecture_sample.core.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation.CharacterAdapter
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation.CharactersFragment
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation.CharactersViewModel
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.data.repository.CharacterRepositoryImpl
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.details.presentation.CharacterDetailsFragment
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.details.presentation.CharacterDetailsViewModel
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.CharacterRepository
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.domain.GetCharactersUseCase
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.navigator.CharacterNavigator
import pl.akademiaandroida.android_clean_architecture_sample.features.characters.navigator.CharacterNavigatorImpl
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.data.repository.EpisodeRepositoryImpl
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.EpisodeRepository
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.domain.GetEpisodesUseCase
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.presentation.EpisodeAdapter
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.presentation.EpisodesFragment
import pl.akademiaandroida.android_clean_architecture_sample.features.episodes.presentation.EpisodesViewModel
import pl.akademiaandroida.android_clean_architecture_sample.features.location.data.repository.LocationRepositoryImpl
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.GetLocationsUseCase
import pl.akademiaandroida.android_clean_architecture_sample.features.location.domain.LocationRepository
import pl.akademiaandroida.android_clean_architecture_sample.features.location.presentation.LocationAdapter
import pl.akademiaandroida.android_clean_architecture_sample.features.location.presentation.LocationsFragment
import pl.akademiaandroida.android_clean_architecture_sample.features.location.presentation.LocationsViewModel

val featuresModule = module {
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get(), get()) }
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get(), get()) }
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get(), get()) }

    factory { GetEpisodesUseCase(get()) }
    factory { GetCharactersUseCase(get()) }
    factory { GetLocationsUseCase(get()) }

    factory<CharacterNavigator> { CharacterNavigatorImpl(get()) }

    scope(named<CharactersFragment>()) {
        viewModel { CharactersViewModel(get(), get(), get()) }
        factory { CharacterAdapter() }
    }

    scope(named<EpisodesFragment>()) {
        viewModel { EpisodesViewModel(get(), get()) }
        factory { EpisodeAdapter() }
    }

    scope(named<LocationsFragment>()) {
        viewModel { LocationsViewModel(get(), get()) }
        factory { LocationAdapter() }
    }

    scope(named<CharacterDetailsFragment>()) {
        viewModel { CharacterDetailsViewModel() }
    }

}