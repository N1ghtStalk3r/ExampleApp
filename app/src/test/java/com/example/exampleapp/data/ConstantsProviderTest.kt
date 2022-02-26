package com.example.exampleapp.data

import com.google.common.truth.Truth
import org.junit.Test

internal class ConstantsProviderTest {

    @Test
    fun getBaseUrl() {
        Truth.assertThat(ConstantsProvider.getBaseUrl()).isEqualTo("jsonplaceholder.typicode.com")
    }
}