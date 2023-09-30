package com.example.kmm.ds

fun <E> kotlin.collections.List<E>.toSingleLinkedList(): List<E> {
    val list = SingleLinkedList<E>()
    for (e in this) {
        list.add(e)
    }
    return list
}
