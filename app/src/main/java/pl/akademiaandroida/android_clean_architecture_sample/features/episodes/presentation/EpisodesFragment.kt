package pl.akademiaandroida.android_clean_architecture_sample.features.episodes.presentation

import androidx.fragment.app.viewModels
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.platform.BaseFragment

class EpisodesFragment : BaseFragment<EpisodesViewModel>() {

    override val layoutRes: Int = R.layout.fragment_dashboard

    override val viewModel: EpisodesViewModel by viewModels()
}
