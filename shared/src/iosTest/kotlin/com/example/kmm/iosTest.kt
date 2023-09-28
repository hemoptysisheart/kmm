package com.example.kmm

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.fail

class IosGreetingTest {
    @Test
    fun testExample() {
        // GIVEN
        val greeting = Greeting()

        // WHEN
        val actual = greeting.greet()

        // THEN
        assertTrue(actual.contains("iOS"), "Check iOS is mentioned")
    }

    @Test
    fun `test fail`(){
        fail("test fail.")
    }
}
