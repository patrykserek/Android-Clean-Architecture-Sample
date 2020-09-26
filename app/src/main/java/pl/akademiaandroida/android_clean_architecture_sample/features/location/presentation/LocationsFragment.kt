package pl.akademiaandroida.android_clean_architecture_sample.features.location.presentation

import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import pl.akademiaandroida.android_clean_architecture_sample.BR
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.base.platform.BaseFragment
import pl.akademiaandroida.android_clean_architecture_sample.databinding.FragmentLocationsBinding

class LocationsFragment : BaseFragment<LocationViewModel, FragmentLocationsBinding>(
    BR.viewModel,
    R.layout.fragment_locations
) {

    override val viewModel: LocationViewModel by lifecycleScope.viewModel(this)
}
