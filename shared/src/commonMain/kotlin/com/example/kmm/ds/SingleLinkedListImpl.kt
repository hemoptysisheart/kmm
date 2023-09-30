package com.example.kmm.ds

class SingleLinkedListImpl<E> : SingleLinkedList<E> {
    private data class Node<E>(
        val element: E,
        var next: Node<E>? = null
    )

    private var head: Node<E>? = null

    override val size: Int
        get() = TODO("Not yet implemented")

    override fun add(element: E) {
        TODO("Not yet implemented")
    }

    override fun add(index: Int, element: E) {
        TODO("Not yet implemented")
    }

    override fun first(): E? {
        TODO("Not yet implemented")
    }

    override fun last(): E? {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): E {
        TODO("Not yet implemented")
    }

    override fun contains(element: E): Boolean {
        TODO("Not yet implemented")
    }

    override fun remove(index: Int): E {
        TODO("Not yet implemented")
    }
}