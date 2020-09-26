package pl.akademiaandroida.android_clean_architecture_sample.features.location.presentation

import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.base.platform.BaseFragment
import pl.akademiaandroida.android_clean_architecture_sample.core.extensions.viewBinding
import pl.akademiaandroida.android_clean_architecture_sample.databinding.FragmentLocationsBinding

class LocationsFragment : BaseFragment<LocationViewModel>(R.layout.fragment_locations) {

    private val binding by viewBinding(FragmentLocationsBinding::bind)
    override val viewModel: LocationViewModel by lifecycleScope.viewModel(this)
}
