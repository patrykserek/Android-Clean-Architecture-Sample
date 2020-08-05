package pl.akademiaandroida.android_clean_architecture_sample.features.characters.presentation

import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.platform.BaseFragment

class CharactersFragment : BaseFragment<CharactersViewModel>(R.layout.fragment_characters) {

    override val viewModel: CharactersViewModel by lifecycleScope.viewModel(this)
}
