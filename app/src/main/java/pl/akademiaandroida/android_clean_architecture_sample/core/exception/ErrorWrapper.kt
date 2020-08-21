package pl.akademiaandroida.android_clean_architecture_sample.core.exception

interface ErrorWrapper {
    fun wrap(throwable: Throwable): Throwable
}