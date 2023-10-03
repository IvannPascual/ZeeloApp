package com.example.zeelo.data

import com.example.zeelo.common.data.featureflags.FeatureFlagsRepository
import junit.framework.TestCase.assertFalse
import org.junit.Test

class FeatureFlagsRepositoryTest {

    private val sut = FeatureFlagsRepository()

    @Test
    fun `WHEN we call to flag simulateGetBooksApiIsNotAvailable THEN always must be false `() {
        assertFalse(sut.simulateGetBooksApiIsNotAvailable)
    }
}