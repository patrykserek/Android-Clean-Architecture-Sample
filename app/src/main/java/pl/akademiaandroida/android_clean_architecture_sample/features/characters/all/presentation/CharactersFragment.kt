package pl.akademiaandroida.android_clean_architecture_sample.features.characters.all.presentation

import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_episodes.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.base.platform.BaseFragment

class CharactersFragment : BaseFragment<CharactersViewModel>(R.layout.fragment_characters) {

    private val gridLayoutManager: GridLayoutManager by lifecycleScope.inject()
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
        with(recyclerView) {
            layoutManager = gridLayoutManager
            setHasFixedSize(true)
            adapter = characterAdapter
        }
        characterAdapter.setOnCharacterClickListener { viewModel.onCharacterClick(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        with(recyclerView) {
            layoutManager = null
            adapter = null
        }
    }
}
