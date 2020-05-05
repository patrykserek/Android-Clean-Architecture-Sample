package pl.akademiaandroida.android_clean_architecture_sample.features.location.presentation

import androidx.fragment.app.viewModels
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.platform.BaseFragment

class LocationsFragment : BaseFragment<LocationViewModel>() {

    override val layoutRes: Int = R.layout.fragment_locations

    override val viewModel: LocationViewModel by viewModels()
}
