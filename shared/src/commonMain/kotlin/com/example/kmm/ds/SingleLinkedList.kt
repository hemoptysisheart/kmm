package com.example.kmm.ds

class SingleLinkedList<E> : List<E> {
    private data class Node<E>(
        val element: E,
        var next: Node<E>? = null
    )

    private var head: Node<E>? = null
    override val first: E?
        get() = TODO("Not yet implemented")

    override val last: E?
        get() = TODO("Not yet implemented")

    override val size: Int
        get() = TODO("Not yet implemented")

    override fun add(data: E): Int {
        TODO("Not yet implemented")
    }

    override fun add(index: Int, data: E) {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): E {
        TODO("Not yet implemented")
    }

    override fun contains(data: E): Boolean {
        TODO("Not yet implemented")
    }

    override fun remove(index: Int): E {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }
}
