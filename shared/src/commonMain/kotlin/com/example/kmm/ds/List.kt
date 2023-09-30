package com.example.kmm.ds

interface List<E> {
    /**
     * 데이터 갯수.
     */
    val size: Int

    fun add(data: E):Int

    @Throws(IndexOutOfBoundsException::class)
    fun add(index: Int, data: E)

    fun first(): E?

    fun last(): E?

    @Throws(IndexOutOfBoundsException::class)
    operator fun get(index: Int): E

    fun contains(data: E): Boolean

    @Throws(IndexOutOfBoundsException::class)
    fun remove(index: Int): E
}