package pl.akademiaandroida.android_clean_architecture_sample.features.characters.details.presentation

import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import pl.akademiaandroida.android_clean_architecture_sample.BR
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.base.platform.BaseFragment
import pl.akademiaandroida.android_clean_architecture_sample.databinding.FragmentCharacterDetailsBinding

class CharacterDetailsFragment :
    BaseFragment<CharacterDetailsViewModel, FragmentCharacterDetailsBinding>(
        BR.viewModel,
        R.layout.fragment_character_details
    ) {

    override val viewModel: CharacterDetailsViewModel by lifecycleScope.viewModel(this)

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }
}