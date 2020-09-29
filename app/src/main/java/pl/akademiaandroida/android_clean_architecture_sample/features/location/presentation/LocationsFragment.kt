package pl.akademiaandroida.android_clean_architecture_sample.features.location.presentation

import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.base.platform.BaseFragment
import pl.akademiaandroida.android_clean_architecture_sample.core.extensions.viewBinding
import pl.akademiaandroida.android_clean_architecture_sample.databinding.FragmentLocationsBinding

class LocationsFragment : BaseFragment<LocationViewModel>(R.layout.fragment_locations) {

    private val binding by viewBinding(FragmentLocationsBinding::bind)
    private val divider: DividerItemDecoration by lifecycleScope.inject()
    private val locationAdapter: LocationAdapter by lifecycleScope.inject()
    override val viewModel: LocationViewModel by lifecycleScope.viewModel(this)

    override fun initViews() {
        super.initViews()
        initRecycler()
    }

    override fun initObservers() {
        super.initObservers()
        observeLocations()
    }

    private fun observeLocations() {
        viewModel.locations.observe(this) {
            locationAdapter.setItems(it)
        }
    }

    private fun initRecycler() {
        with(binding.recyclerView) {
            addItemDecoration(divider)
            adapter = locationAdapter
        }
    }
}
