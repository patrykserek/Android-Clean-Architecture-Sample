package pl.akademiaandroida.android_clean_architecture_sample.core.base.domain

import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params> {

    abstract suspend fun action(params: Params): Type?

    suspend fun executeAction(
        params: Params,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ): Type? {
        return withContext(dispatcher) {
            action(params)
        }
    }

    open operator fun invoke(
        params: Params,
        viewModelScope: CoroutineScope,
        executionDispatcher: CoroutineDispatcher = Dispatchers.IO,
        onResult: (Result<Type?>) -> Unit = {}
    ) {
        viewModelScope.launch {
            val result: Result<Type?> =
                runCatching { executeAction(params, executionDispatcher) }
            onResult(result)
        }
    }

}