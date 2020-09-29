package pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation

import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.base.platform.BaseFragment
import pl.akademiaandroida.android_clean_architecture_sample.core.extensions.viewBinding
import pl.akademiaandroida.android_clean_architecture_sample.databinding.FragmentCharactersBinding

class CharactersFragment : BaseFragment<CharactersViewModel>(R.layout.fragment_characters) {

    private val binding by viewBinding(FragmentCharactersBinding::bind)
    private val characterAdapter: CharacterAdapter by lifecycleScope.inject()

    override val viewModel: CharactersViewModel by lifecycleScope.viewModel(this)

    override fun initViews() {
        super.initViews()
        initRecycler()
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    private fun observeEpisodes() {
        viewModel.characters.observe(this) {
            characterAdapter.setCharacters(it)
        }
    }

    private fun initRecycler() {
        with(binding.recyclerView) {
            setHasFixedSize(true)
            adapter = characterAdapter
        }
        characterAdapter.setOnCharacterClickListener { viewModel.onCharacterClick(it) }
    }
}
