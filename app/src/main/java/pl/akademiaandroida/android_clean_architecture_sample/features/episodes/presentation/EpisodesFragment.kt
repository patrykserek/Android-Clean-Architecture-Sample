package pl.akademiaandroida.android_clean_architecture_sample.features.episodes.presentation

import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import pl.akademiaandroida.android_clean_architecture_sample.BR
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.base.platform.BaseFragment
import pl.akademiaandroida.android_clean_architecture_sample.databinding.FragmentEpisodesBinding

class EpisodesFragment : BaseFragment<EpisodesViewModel, FragmentEpisodesBinding>(
    BR.viewModel,
    R.layout.fragment_episodes
) {

    private val linearLayoutManager: LinearLayoutManager by lifecycleScope.inject()
    private val divider: DividerItemDecoration by lifecycleScope.inject()
    private val adapter: EpisodeAdapter by lifecycleScope.inject()

    override val viewModel: EpisodesViewModel by lifecycleScope.viewModel(this)

    override fun initViews(binding: FragmentEpisodesBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            adapter.setItems(it)
        }
    }

    private fun initRecycler(binding: FragmentEpisodesBinding) {
        with(binding.recyclerView) {
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
            setHasFixedSize(true)
            adapter = adapter
        }
    }
}
