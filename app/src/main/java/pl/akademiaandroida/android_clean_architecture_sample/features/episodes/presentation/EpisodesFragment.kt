package pl.akademiaandroida.android_clean_architecture_sample.features.episodes.presentation

import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_episodes.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.platform.BaseFragment

class EpisodesFragment : BaseFragment<EpisodesViewModel>() {

    private val layoutManager: RecyclerView.LayoutManager by lifecycleScope.inject()
    private val divider: DividerItemDecoration by lifecycleScope.inject()
    private val adapter: EpisodeAdapter by lifecycleScope.inject()

    override val layoutRes: Int = R.layout.fragment_episodes

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
            adapter.setItems(it)
        }
    }

    private fun initRecycler() {
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(divider)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }
}
