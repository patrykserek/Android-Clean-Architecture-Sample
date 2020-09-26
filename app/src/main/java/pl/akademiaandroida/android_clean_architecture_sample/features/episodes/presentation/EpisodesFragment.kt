package pl.akademiaandroida.android_clean_architecture_sample.features.episodes.presentation

import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.base.platform.BaseFragment
import pl.akademiaandroida.android_clean_architecture_sample.core.extensions.viewBinding
import pl.akademiaandroida.android_clean_architecture_sample.databinding.FragmentEpisodesBinding

class EpisodesFragment : BaseFragment<EpisodesViewModel>(R.layout.fragment_episodes) {

    private val binding by viewBinding(FragmentEpisodesBinding::bind)
    private val divider: DividerItemDecoration by lifecycleScope.inject()
    private val episodeAdapter: EpisodeAdapter by lifecycleScope.inject()

    override val viewModel: EpisodesViewModel by lifecycleScope.viewModel(this)

    override fun initViews() {
        super.initViews()
        initRecycler()
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            episodeAdapter.setItems(it)
        }
    }

    private fun initRecycler() {
        with(binding.recyclerView) {
            addItemDecoration(divider)
            setHasFixedSize(true)
            adapter = episodeAdapter
        }
    }
}
