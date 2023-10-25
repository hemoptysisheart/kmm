package com.example.kmm.ds

import kotlin.test.Test
import kotlin.test.assertIs

@Suppress("NonAsciiCharacters")
class SingleLinkedListTest : AbstractListTest<SingleLinkedList<Long>>() {
    override fun list() = SingleLinkedList<Long>()

    @Test
    fun `list - 테스트 실행용`() {
        // WHEN
        val list = list()
        println("[WHEN] list=$list")

        // THEN
        assertIs<SingleLinkedList<Long>>(list)
    }
}
