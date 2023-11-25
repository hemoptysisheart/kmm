package com.example.kmm.ds

import com.example.kmm.RANDOM
import com.example.kmm.test.dataset
import com.example.kmm.test.given
import com.example.kmm.test.names
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

@OptIn(ExperimentalStdlibApi::class)
@Suppress("NonAsciiCharacters")
abstract class AbstractListTest<L : List<Long>> {
    private lateinit var list: L

    protected abstract fun list(): L

    /**
     * [add - 리스트 마지막에 데이터 추가]를 통과한다는 전제하에 다른 테스트에 쓸 수 있는 유틸리티 메서드.
     */
    private fun toList(source: kotlin.collections.List<Long>): L {
        val list = list()
        for (data in source) {
            list.add(data)
        }
        return list
    }

    @BeforeTest
    open fun setUp() {
        list = list()
        println("[SETUP] list=$list")
        println()
    }

    @Test
    fun `size - 새 리스트의 크기`() {
        // WHEN
        val size = list.size
        println("[WHEN] size=$size")

        // THEN
        assertEquals(0, size)
    }

    @Test
    fun `add - 새 리스트 마지막에 데이터 추가`() {
        // GIVEN
        val data = RANDOM.nextLong()
        println("[GIVEN] data=$data")

        // WHEN
        val index = list.add(data)
        println("[WHEN] index=$index")

        // THEN
        assertEquals(0, index)
        assertEquals(1, list.size)
        assertEquals(data, list.first)
        assertEquals(data, list.last)
        assertEquals(data, list[index])
        assertTrue(list.contains(data))
    }

    @Test
    fun `add - 리스트 마지막에 데이터 추가`() {
        given(
            names("list", "data"),
            dataset(list(), listOf(RANDOM.nextLong())),
            dataset(list(), listOf(RANDOM.nextLong(), RANDOM.nextLong())),
            dataset(list(), listOf(RANDOM.nextLong(), RANDOM.nextLong(), RANDOM.nextLong()))
        ) { list, data ->
            // WHEN
            val indexes = mutableListOf<Int>()
            for (d in data) {
                indexes.add(list.add(d))
            }
            println("[WHEN] list=$list")

            // THEN
            assertEquals(data.size, list.size)
            assertEquals(data[0], list.first)
            assertEquals(data[data.size - 1], list.last)
            assertEquals(data.indices.toList(), indexes)
            for (i in data.indices) {
                assertEquals(data[i], list[i])
            }
        }
    }

    @Test
    fun `add - 리스트에 데이터 추가`() {
        given(
            names("src", "index", "data"),
            dataset(listOf(), 0, RANDOM.nextLong()),
            dataset(listOf(RANDOM.nextLong()), 0, RANDOM.nextLong()),
            dataset(listOf(RANDOM.nextLong()), 1, RANDOM.nextLong()),
            dataset(listOf(RANDOM.nextLong(), RANDOM.nextLong()), 0, RANDOM.nextLong()),
            dataset(listOf(RANDOM.nextLong(), RANDOM.nextLong()), 1, RANDOM.nextLong()),
            dataset(listOf(RANDOM.nextLong(), RANDOM.nextLong()), 2, RANDOM.nextLong())
        ) { src, index, data ->
            // GIVEN
            val list = toList(src)
            val size = list.size
            println("[GIVEN] size=$size")

            // WHEN
            list.add(index, data)
            println("[WHEN] list=$list")

            // THEN
            assertEquals(size + 1, list.size)
            assertEquals(data, list[index])
            assertTrue(list.contains(data))
        }
    }

    @Test
    fun `add - 잘못된 위치에 추가`() {
        given(
            names("src", "index", "data"),
            dataset(listOf(), -1, RANDOM.nextLong()),
            dataset(listOf(), 1, RANDOM.nextLong()),
            dataset(listOf(RANDOM.nextLong()), -1, RANDOM.nextLong()),
            dataset(listOf(RANDOM.nextLong()), 2, RANDOM.nextLong()),
            dataset(listOf(RANDOM.nextLong(), RANDOM.nextLong()), -1, RANDOM.nextLong()),
            dataset(listOf(RANDOM.nextLong(), RANDOM.nextLong()), 3, RANDOM.nextLong()),
        ) { src, index, data ->
            // GIVEN
            val list = toList(src)
            val size = list.size
            val first = list.first
            val last = list.last
            println("[GIVEN] size=$size, first=$first, last=$last")

            // WHEN
            assertFailsWith<IndexOutOfBoundsException> {
                list.add(index, data)
            }
            println("[WHEN] list=$list")

            // THEN
            assertEquals(size, list.size)
            assertEquals(first, list.first)
            assertEquals(last, list.last)
            assertFalse(list.contains(data))
            for (i in src.indices) {
                assertEquals(src[i], list[i])
            }
        }
    }

    @Test
    fun `remove - 1개짜리 리스트에서 데이터 삭제하기`() {
        // GIVEN
        val data = RANDOM.nextLong()
        val list = list()
        list.add(data)
        println("[GIVEN] data=$data, list=$list")

        // WHEN
        val removed = list.remove(0)
        println("[WHEN] removed=$removed, list=$list")

        // THEN
        assertEquals(0, list.size)
        assertNull(list.first)
        assertNull(list.last)
        assertFalse(list.contains(data))
    }

    @Test
    fun `remove - 첫번째 데이터 삭제하기`() {
        given(
            "src",
            listOf(RANDOM.nextLong(), RANDOM.nextLong()),
            listOf(RANDOM.nextLong(), RANDOM.nextLong(), RANDOM.nextLong())
        ) { src ->
            // GIVEN
            val list = toList(src)
            val size = list.size
            val data = list[0]
            val last = list.last
            val second = list[1]
            println("[GIVEN] size=$size, data=$data, last=$last, expectedFirst=$second")

            // WHEN
            val removed = list.remove(0)
            println("[WHEN] removed=$removed")

            // THEN
            assertEquals(size - 1, list.size)
            assertEquals(second, list.first)
            assertEquals(last, list.last)
            assertFalse(list.contains(data))
        }
    }

    @Test
    fun `remove - 마지막 데이터 삭제하기`() {
        given(
            "src",
            listOf(RANDOM.nextLong(), RANDOM.nextLong()),
            listOf(RANDOM.nextLong(), RANDOM.nextLong(), RANDOM.nextLong())
        ) { src ->
            // GIVEN
            val size = src.size
            val first = src[0]
            val lastSecond = src[size - 2]
            val list = toList(src)
            println("[GIVEN] size=$size, first=$first, lastSecond=$lastSecond, list=$list")

            // WHEN
            val removed = list.remove(size - 1)
            println("[WHEN] removed=$removed")

            // THEN
            assertEquals(size - 1, list.size)
            assertEquals(first, list.first)
            assertEquals(lastSecond, list.last)
            assertFalse(list.contains(removed))
        }
    }

    @Test
    fun `remove - 데이터 삭제하기`() {
        given(
            "src",
            listOf(RANDOM.nextLong()),
            listOf(RANDOM.nextLong(), RANDOM.nextLong()),
            listOf(RANDOM.nextLong(), RANDOM.nextLong(), RANDOM.nextLong())
        ) { src ->
            // GIVEN
            val list = toList(src)
            val size = list.size
            val index = RANDOM.nextInt(size)
            val data = list[index]
            println("[GIVEN] list=$list, size=$size, index=$index, data=$data")

            // WHEN
            val removed = list.remove(index)
            println("[WHEN] list=$list")

            // THEN
            assertEquals(size - 1, list.size)
            assertEquals(data, removed)
            assertFalse(list.contains(data))
        }
    }

    @Test
    fun `remove - 없는 인덱스를 삭제하기`() {
        given(
            names("list", "index"),
            dataset(listOf(), -1),
            dataset(listOf(), 0),
            dataset(listOf(), 1),
            dataset(listOf(RANDOM.nextLong()), -1),
            dataset(listOf(RANDOM.nextLong()), 1),
            dataset(listOf(RANDOM.nextLong(), RANDOM.nextLong()), -1),
            dataset(listOf(RANDOM.nextLong(), RANDOM.nextLong()), 2)
        ) { src, index ->
            // GIVEN
            val list = toList(src)
            val size = list.size
            val first = list.first
            val last = list.last
            println("[GIVEN] size=$size, first=$first, last=$last, list=$list")

            // WHEN
            assertFailsWith<IndexOutOfBoundsException> {
                list.remove(index)
            }
            println("[WHEN] list=$list")

            // THEN
            assertEquals(size, list.size)
            assertEquals(first, list.first)
            assertEquals(last, list.last)
            for (i in src.indices) {
                assertEquals(src[i], list[i])
            }
        }
    }

    @Test
    fun `clear - 모든 데이터 삭제하기`() {
        given(
            "src",
            listOf(),
            listOf(RANDOM.nextLong()),
            listOf(RANDOM.nextLong(), RANDOM.nextLong()),
            listOf(RANDOM.nextLong(), RANDOM.nextLong(), RANDOM.nextLong())
        ) { src ->
            // GIVEN
            val list = toList(src)
            println("[GIVEN] list=$list")

            // WHEN
            list.clear()
            println("[WHEN] list=$list")

            // THEN
            assertEquals(0, list.size)
            assertNull(list.first)
            assertNull(list.last)
            for (data in src) {
                assertFalse(list.contains(data))
            }
        }
    }

    @Test
    fun `임의의 조작`() {
        // GIVEN
        val expected = mutableListOf<Long>()
        val opCount = RANDOM.nextInt(50, 500)
        println("[GIVEN] opCount=$opCount")

        // WHEN
        (0..<opCount).forEach { i ->
            val op = RANDOM.nextInt(3)
            when {
                (0 == op || 1 == op) && 0 < expected.size -> RANDOM.nextInt(expected.size).let {
                    println("[WHEN] expected.size=${expected.size} => list.remove(index=$it)")
                    expected.removeAt(it)
                    list.remove(it)
                    println("[WHEN] list=$list")
                }

                2 == op -> RANDOM.nextLong().let {
                    val index = RANDOM.nextInt(expected.size + 1)
                    println("[WHEN] expected.size=${expected.size} => list.add(index=$index, data=$it)")
                    expected.add(index, it)
                    list.add(index, it)
                    println("[WHEN] list=$list")
                }

                else -> RANDOM.nextLong().let {
                    println("[WHEN] expected.size=${expected.size} => list.add(data=$it)")
                    expected.add(it)
                    list.add(it)
                    println("[WHEN] list=$list")
                }
            }
            println()
        }
        println("[WHEN] expected=$expected")
        println("[WHEN] list=$list")

        // THEN
        assertEquals(expected.size, list.size)
        assertEquals(expected[0], list.first)
        assertEquals(expected[expected.size - 1], list.last)
        for (i in 0..<expected.size) {
            assertEquals(expected[i], list[i])
        }
    }
}
