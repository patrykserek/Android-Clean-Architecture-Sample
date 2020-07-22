package pl.akademiaandroida.android_clean_architecture_sample

/**
 * Created by jaroslawmichalik on 22/07/2020
 */
import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

class InstantExecutorExtension : BeforeEachCallback, AfterEachCallback {

    override fun beforeEach(context: ExtensionContext?) {
        ArchTaskExecutor.getInstance()
            .setDelegate(fakeMainThreadExecutor)
    }

    override fun afterEach(context: ExtensionContext?) {
        ArchTaskExecutor.getInstance().setDelegate(null)
    }
}

private val fakeMainThreadExecutor = object : TaskExecutor() {
    override fun executeOnDiskIO(runnable: Runnable) = runnable.run()

    override fun postToMainThread(runnable: Runnable) = runnable.run()

    override fun isMainThread(): Boolean = true
}

fun withInstantExecution(action: () -> Unit) {
    ArchTaskExecutor.getInstance().setDelegate(fakeMainThreadExecutor)
    action.invoke()
    ArchTaskExecutor.getInstance().setDelegate(null)
}