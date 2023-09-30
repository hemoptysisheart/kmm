package com.example.kmm.test

fun <V1> given(name: String, vararg datasets: V1, testcase: (V1) -> Unit) {
    for (dataset in datasets) {
        println("[GIVEN] $name=$dataset")
        testcase(dataset)
    }
}

fun <V1, V2> given(names: Names2, vararg datasets: Dataset2<V1, V2>, testcase: (V1, V2) -> Unit) {
    for (dataset in datasets) {
        println("[GIVEN] ${dataset.toString(names)}")
        testcase(dataset.v1, dataset.v2)
    }
}

fun <V1, V2, V3> given(
    names: Names3,
    vararg datasets: Dataset3<V1, V2, V3>,
    testcase: (V1, V2, V3) -> Unit
) {
    for (dataset in datasets) {
        println("[GIVEN] ${dataset.toString(names)}")
        testcase(dataset.v1, dataset.v2, dataset.v3)
    }
}

fun <V1, V2, V3, V4> given(
    names: Names4,
    vararg datasets: Dataset4<V1, V2, V3, V4>,
    case: (V1, V2, V3, V4) -> Unit
) {
    for (dataset in datasets) {
        println("[GIVEN] ${dataset.toString(names)}")
        case(dataset.v1, dataset.v2, dataset.v3, dataset.v4)
    }
}

fun names(name1: String, name2: String) =
    Names2(name1, name2)

fun names(name1: String, name2: String, name3: String) =
    Names3(name1, name2, name3)

fun names(name1: String, name2: String, name3: String, name4: String) =
    Names4(name1, name2, name3, name4)

fun <V1, V2> dataset(v1: V1, v2: V2) = Dataset2(v1, v2)
fun <V1, V2, V3> dataset(v1: V1, v2: V2, v3: V3) = Dataset3(v1, v2, v3)
fun <V1, V2, V3, V4> dataset(v1: V1, v2: V2, v3: V3, v4: V4) = Dataset4(v1, v2, v3, v4)

interface Names

data class Names2(
    val name1: String,
    val name2: String
) : Names

data class Names3(
    val name1: String,
    val name2: String,
    val name3: String
) : Names

data class Names4(
    val name1: String,
    val name2: String,
    val name3: String,
    val name4: String
) : Names

interface Dataset
data class Dataset2<V1, V2>(
    val v1: V1,
    val v2: V2
) : Dataset {
    fun toString(names: Names2) = "${names.name1}=$v1, ${names.name2}=$v2"
}

data class Dataset3<V1, V2, V3>(
    val v1: V1,
    val v2: V2,
    val v3: V3
) : Dataset {
    fun toString(names: Names3) = "${names.name1}=$v1, ${names.name2}=$v2, ${names.name3}=$v3"
}

data class Dataset4<V1, V2, V3, V4>(
    val v1: V1,
    val v2: V2,
    val v3: V3,
    val v4: V4
) : Dataset {
    fun toString(names: Names4) =
        "${names.name1}=$v1, ${names.name2}=$v2, ${names.name3}=$v3, ${names.name4}=$v4"
}
