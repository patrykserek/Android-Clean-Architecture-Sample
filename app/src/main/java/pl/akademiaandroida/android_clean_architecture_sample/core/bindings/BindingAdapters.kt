package pl.akademiaandroida.android_clean_architecture_sample.core.bindings

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.akademiaandroida.android_clean_architecture_sample.core.adapter.BindableAdapter
import pl.akademiaandroida.android_clean_architecture_sample.core.base.platform.UiState

object BindingAdapters {

    @BindingAdapter("app:showOnPendingState")
    @JvmStatic
    fun showOnPendingState(view: ProgressBar, uiState: UiState) {
        view.visibility = if (uiState == UiState.Pending) View.VISIBLE else View.GONE
    }

    @BindingAdapter("app:items")
    @JvmStatic
    fun <T> setItems(recyclerView: RecyclerView, items: List<T>?) {
        if (items.isNullOrEmpty()) return
        (recyclerView.adapter as? BindableAdapter<T>)?.setItems(items)
    }

    @BindingAdapter(value = ["app:imageUrl", "app:placeholder"], requireAll = false)
    @JvmStatic
    fun setImageUrl(imageView: ImageView, imageUrl: String, @DrawableRes placeholder: Int) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .placeholder(placeholder)
            .into(imageView)
    }
}