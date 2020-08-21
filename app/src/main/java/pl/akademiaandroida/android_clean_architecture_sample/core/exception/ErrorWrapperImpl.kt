package pl.akademiaandroida.android_clean_architecture_sample.core.exception

import retrofit2.HttpException

class ErrorWrapperImpl : ErrorWrapper {

    override fun wrap(throwable: Throwable): Throwable {
        return when (throwable) {
            is HttpException -> wrapServerError(throwable)
            else -> throwable
        }
    }

    private fun wrapServerError(httpException: HttpException): Throwable {
        return with(httpException) {
            when (code()) {
                500 -> ServerException.Internal(message())
                400 -> ServerException.BadRequest(message())
                else -> ServerException.Unknown(message())
            }
        }
    }
}

suspend fun <T> callOrThrow(
    errorWrapper: ErrorWrapper,
    apiCall: suspend () -> T
): T {
    return runCatching { apiCall() }
        .getOrElse { throw errorWrapper.wrap(it) }
}