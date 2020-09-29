package pl.akademiaandroida.android_clean_architecture_sample.core.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

fun View.makeVisible() = run { visibility = View.VISIBLE }

fun View.makeGone() = run { visibility = View.GONE }