package br.com.oliveira.emanoel.events.utils


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class DatemillisConverterKtTest {

    @Test
    fun formattedDateReturnsCorrectly() {
        val result = DateMillisConverter(1534784400000)
        assertThat(result).isEqualTo("20/08/18 as 14:00 ")
    }
}