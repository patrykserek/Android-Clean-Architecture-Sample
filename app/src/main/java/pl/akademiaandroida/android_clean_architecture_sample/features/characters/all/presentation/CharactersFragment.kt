package pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation

import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import pl.akademiaandroida.android_clean_architecture_sample.BR
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.base.platform.BaseFragment
import pl.akademiaandroida.android_clean_architecture_sample.databinding.FragmentCharactersBinding

class CharactersFragment : BaseFragment<CharactersViewModel, FragmentCharactersBinding>(
    BR.viewModel, R.layout.fragment_characters
) {

    private val characterAdapter: CharacterAdapter by lifecycleScope.inject()
    override val viewModel: CharactersViewModel by lifecycleScope.viewModel(this)

    override fun initViews(binding: FragmentCharactersBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentCharactersBinding) {
        with(binding.recyclerView) {
            setHasFixedSize(true)
            adapter = characterAdapter
        }
        characterAdapter.setOnCharacterClickListener { viewModel.onCharacterClick(it) }
    }
}
