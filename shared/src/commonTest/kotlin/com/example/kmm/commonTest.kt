package com.example.kmm

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.fail

class CommonGreetingTest {
    @Test
    fun testExample() {
        // GIVEN
        val greeting = Greeting()
        println("[GIVEN] greeting=$greeting")

        // WHEN
        val actual = greeting.greet()
        println("[WHEN] actual=$actual")

        // THEN
        assertTrue(actual.contains("Hello"), "Check 'Hello' is mentioned")
    }

    @Test
    fun `test Fail`(){
        fail("test fail.")
    }
}
