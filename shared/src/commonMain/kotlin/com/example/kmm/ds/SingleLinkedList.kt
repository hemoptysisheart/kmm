package com.example.kmm.ds

interface SingleLinkedList<E> {
    val size: Int

    fun add(element: E)

    @Throws(IndexOutOfBoundsException::class)
    fun add(index: Int, element: E)

    fun first(): E?

    fun last(): E?

    @Throws(IndexOutOfBoundsException::class)
    operator fun get(index: Int): E

    fun contains(element: E): Boolean

    @Throws(IndexOutOfBoundsException::class)
    fun remove(index: Int): E
}