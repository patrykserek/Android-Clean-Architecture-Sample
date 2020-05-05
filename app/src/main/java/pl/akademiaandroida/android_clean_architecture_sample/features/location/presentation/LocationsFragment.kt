package pl.akademiaandroida.android_clean_architecture_sample.features.location.presentation

import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.platform.BaseFragment

class LocationsFragment : BaseFragment<LocationViewModel>() {

    override val layoutRes: Int = R.layout.fragment_locations

    override val viewModel: LocationViewModel by lifecycleScope.viewModel(this)
}
