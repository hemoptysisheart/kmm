package com.example.kmm.ds

class SingleLinkedList<E> : List<E> {
    private data class Node<E>(
        val data: E,
        var next: Node<E>? = null
    )

    private var head: Node<E>? = null

    override val size: Int
        get() {
            var count = 0
            var node = head
            while (null != node) {
                count++
                node = node.next
            }

            return count
        }

    override val first: E?
        get() = head?.data

    override val last: E?
        get() {
            var node = head
            while (null != node?.next) {
                node = node.next
            }

            return node?.data
        }

    private fun node(index: Int): Node<E>? = if (0 == index) {
        head
    } else {
        var current = 0
        var node = head
        while (current < index) {
            current++
            node = node?.next
        }
        node
    }

    private fun lastNode(): Node<E>? = if (null == head) {
        null
    } else {
        var node = head
        while (null != node?.next) {
            node = node.next
        }
        node
    }

    override fun add(data: E): Int {
        var index = 0

        if (null == head) {
            head = Node(data)
        } else {
            val last = lastNode()
            last?.next = Node(data)
        }

        return index
    }

    override fun add(index: Int, data: E) {
        if (0 > index || size < index) {
            throw IndexOutOfBoundsException("index=$index, size=$size")
        }

        if (0 == index) {
            head = Node(data, head)
        } else {
            val pre = node(index - 1)
            pre?.next = Node(data, pre?.next)
        }
    }

    override fun get(index: Int): E {
        var currentIndex = 0
        var node = head
        while (currentIndex < index) {
            currentIndex++
            node = node?.next
        }

        return node!!.data
    }

    override fun contains(data: E): Boolean {
        var node = head
        do {
            if (data == node?.data) {
                return true
            }
            node = node?.next
        } while (null != node)

        return false
    }

    override fun remove(index: Int): E {
        if (0 > index || size <= index) {
            throw IndexOutOfBoundsException("index=$index, size=$size")
        }

        val preNode = if (0 == index) {
            null
        } else {
            node(index - 1)
        }

        return when (size) {
            1 -> {
                val data = head!!.data
                head = null
                data
            }

            else -> {
                val node = node(index)
                if (head === node) {
                    head = node?.next
                } else {
                    preNode?.next = node?.next
                }

                node!!.data
            }
        }
    }

    override fun clear() {
        head = null
    }
}
