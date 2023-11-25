package com.example.kmm.ds

class DoubleLinkedList<E> : List<E> {
    private data class Node<E>(
        val data: E,
        var pre: Node<E>? = null,
        var next: Node<E>? = null
    ) {
        override fun toString() = "$data"
    }

    private var head: Node<E>? = null

    private fun node(index: Int): Node<E> {
        when {
            0 > index ->
                throw IndexOutOfBoundsException("negative index=$index")

            null == head ->
                throw IndexOutOfBoundsException("empty double linked list : size=0, index=$index")

            else -> {
                var current = head
                var i = 0
                while (null != current && i < index) {
                    i++
                    current = current.next
                }

                if (null == current) {
                    throw IndexOutOfBoundsException("size=$size, index=$index")
                } else {
                    return current
                }
            }
        }
    }

    override val size: Int
        get() {
            if (null == head) {
                return 0
            }

            var size = 1
            var current = head
            while (null != current?.next) {
                current = current.next
                size++
            }
            return size
        }
    override val first: E?
        get() = head?.data
    override val last: E?
        get() {
            if (null == head) {
                return null
            }

            var current = head
            while (null != current?.next) {
                current = current.next
            }
            return current?.data
        }

    override fun get(index: Int): E {
        val node = node(index)
        return node.data
    }

    override fun remove(index: Int): E {
        val node = node(index)
        val pre = node.pre
        val next = node.next

        if (null == pre) { // node == head
            head = next
        } else {
            pre.next = next
        }
        next?.pre = pre

        return node.data
    }

    override fun clear() {
        head = null
    }

    override fun contains(data: E): Boolean {
        if (null == head) {
            return false
        }

        var node = head
        while (null != node) {
            if (data == node.data) {
                return true
            } else {
                node = node.next
            }
        }
        return false
    }

    override fun add(index: Int, data: E) {
        when {
            0 > index ->
                throw IndexOutOfBoundsException("negative index : index=$index")

            0 == index -> {
                val node = Node(data, null, head)
                head?.pre = node
                head = node
            }

            else -> {
                val pre = node(index - 1)
                val next = pre.next
                val node = Node(data, pre, next)

                pre.next = node
                next?.pre = node
            }
        }
    }

    override fun add(data: E): Int {
        return if (null == head) {
            head = Node(data)
            0
        } else {
            var index = 0
            var current: Node<E> = head!!
            while (null != current.next) {
                current = current.next!!
                index++
            }
            val node = Node(data, current)
            current.next?.pre = node
            current.next = node
            index + 1
        }
    }

    override fun toString(): String {
        val sb = StringBuilder("[")
        var node = head
        while (null != node) {
            sb.append(node.data)
            if (null != node.next) {
                sb.append(", ")
            }
            node = node.next
        }

        sb.append("]")
        return sb.toString()
    }
}
