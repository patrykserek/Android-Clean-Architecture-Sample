package pl.akademiaandroida.android_clean_architecture_sample.core.adapter

interface BindableAdapter<T> {
    fun setItems(items: List<T>)
}