package com.example.hiltdemo.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.hiltdemo.data.AlbumEntity
import com.example.hiltdemo.usecase.GetAlbumsUseCase
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()

    private lateinit var testViewModel: MainViewModel
    private val getAlbumsUseCase: GetAlbumsUseCase = mock()
    private val mockAlbumResult: List<AlbumEntity> by lazy { listOf(AlbumEntity(id = "2", title = "title1")) }

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        testViewModel = MainViewModel(getAlbumsUseCase = getAlbumsUseCase)
    }

    @After
    fun reset() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `When fetching album successfully, show data in presentation`() = runBlockingTest {
        whenever(getAlbumsUseCase.invoke()) doReturn mockAlbumResult

        testViewModel.fetchAlbums()

        assertEquals(testViewModel.albumList.value, mockAlbumResult)
    }

}