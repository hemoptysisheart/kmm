package com.example.kmm

import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.test.fail

class AndroidGreetingTest {
    @Test
    fun testExample() {
        // GIVEN
        val greeting = Greeting()
        println("[GIVEN] greeting=$greeting")

        // WHEN
        val actual = greeting.greet()
        println("[WHEN] actual=$actual")

        assertTrue("Check Android is mentioned", actual.contains("Android"))
    }

    @Test
    fun `test fail`(){
        fail("test fail.")
    }
}
