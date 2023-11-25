package com.example.kmm.ds

import kotlin.test.Test
import kotlin.test.assertIs

@Suppress("NonAsciiCharacters")
class DoubleListTest : AbstractListTest<DoubleLinkedList<Long>>() {
    override fun list(): DoubleLinkedList<Long> = DoubleLinkedList()

    @Test
    fun `list - 테스트 실행용`() {
        // WHEN
        val list = list()
        println("[WHEN] list=$list")

        // THEN
        assertIs<DoubleLinkedList<Long>>(list)
    }
}
