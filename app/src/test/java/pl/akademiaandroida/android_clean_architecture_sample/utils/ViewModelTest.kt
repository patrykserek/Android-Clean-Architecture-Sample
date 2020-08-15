package pl.akademiaandroida.android_clean_architecture_sample.utils

import androidx.arch.core.executor.ArchTaskExecutor
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

open class ViewModelTest {

    @BeforeEach
    fun setUp() {
        ArchTaskExecutor.getInstance()
            .setDelegate(FakeMainThreadExecutor)
    }

    @AfterEach
    fun tearDown() {
        ArchTaskExecutor.getInstance().setDelegate(null)
    }

}