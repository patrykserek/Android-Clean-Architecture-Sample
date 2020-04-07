package pl.akademiaandroida.android_clean_architecture_sample.core.platform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : BaseViewModel> : Fragment() {

    @get:LayoutRes
    abstract val layoutRes: Int

    abstract val viewModel: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(layoutRes, container, false)
        bindViewModelToLifecycle()
        initViews()
        initObservables()
        return root
    }

    private fun bindViewModelToLifecycle() {
        lifecycle.addObserver(viewModel)
    }

    open fun initViews() {}

    open fun initObservables() {}

}