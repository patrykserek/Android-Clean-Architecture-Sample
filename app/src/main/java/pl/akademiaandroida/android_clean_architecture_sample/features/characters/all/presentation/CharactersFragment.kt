package pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation

import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.base.platform.BaseFragment
import pl.akademiaandroida.android_clean_architecture_sample.core.extensions.viewBinding
import pl.akademiaandroida.android_clean_architecture_sample.databinding.FragmentCharactersBinding

class CharactersFragment : BaseFragment<CharactersViewModel>(R.layout.fragment_characters) {

    private val characterAdapter: CharacterAdapter by lifecycleScope.inject()
    private val binding by viewBinding(FragmentCharactersBinding::bind)

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
            layoutManager = lifecycleScope.get<GridLayoutManager>()
            setHasFixedSize(true)
            adapter = characterAdapter
        }
        characterAdapter.setOnCharacterClickListener { viewModel.onCharacterClick(it) }
    }
}
