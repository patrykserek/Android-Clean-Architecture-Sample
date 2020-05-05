package pl.akademiaandroida.android_clean_architecture_sample.features.episodes.presentation

import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.platform.BaseFragment

class EpisodesFragment : BaseFragment<EpisodesViewModel>() {

    override val layoutRes: Int = R.layout.fragment_episodes

    override val viewModel: EpisodesViewModel by lifecycleScope.viewModel(this)
}
