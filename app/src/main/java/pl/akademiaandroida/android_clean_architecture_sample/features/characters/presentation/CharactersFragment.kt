package pl.akademiaandroida.android_clean_architecture_sample.features.characters.presentation

import androidx.fragment.app.viewModels
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.platform.BaseFragment

class CharactersFragment : BaseFragment<CharactersViewModel>() {

    override val layoutRes: Int = R.layout.fragment_characters

    override val viewModel: CharactersViewModel by viewModels()
}
