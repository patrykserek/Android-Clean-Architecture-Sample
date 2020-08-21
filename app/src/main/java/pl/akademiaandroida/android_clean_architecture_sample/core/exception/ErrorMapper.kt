package pl.akademiaandroida.android_clean_architecture_sample.core.exception

interface ErrorMapper {
    fun map(throwable: Throwable): String
}