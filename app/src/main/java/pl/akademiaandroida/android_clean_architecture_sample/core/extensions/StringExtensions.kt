package pl.akademiaandroida.android_clean_architecture_sample.core.extensions

fun String.Companion.empty() = ""

fun String.getOrNullIfUnknown() =
    if (this == "unknown") null
    else this