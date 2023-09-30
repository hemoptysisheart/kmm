package com.example.kmm.ds

interface List<E> {
    /**
     * 리스트가 가진 데이터 갯수.
     */
    val size: Int

    /**
     * 맨 처음 데이터. 없으면 `null`.
     */
    val first: E?

    /**
     * 맨 마지막 데이터. 없으면 `null`.
     */
    val last: E?

    /**
     * 리스트 마지막에 데이터를 추가한다.
     *
     * @param data 추가할 데이터.
     * @return `data`가 추가된 인덱스. 0-based.
     */
    fun add(data: E): Int

    /**
     * 원하는 위치에 데이터를 추가한다.
     * 지정한 위치 이후의 데이터는 인덱스가 하나씩 뒤로 밀린다.
     *
     * @param index 데이터를 추가할 위치. 0-based.
     * @param data 추가할 데이터.
     * @throws IndexOutOfBoundsException `0 <= index < size`가 아닐 때.
     */
    @Throws(IndexOutOfBoundsException::class)
    fun add(index: Int, data: E)

    /**
     * 특정 위치의 데이터를 반환한다. 데이터는 리스트에서 사라지지 않는다.
     *
     * @param index 원하는 데이터의 위치. 0-based.
     * @throws IndexOutOfBoundsException `0 <= index < size`가 아닐 때.
     */
    @Throws(IndexOutOfBoundsException::class)
    operator fun get(index: Int): E

    /**
     * 리스트에 데이터가 있는지 확인한다.
     */
    fun contains(data: E): Boolean

    /**
     * 지정한 위치의 데이터를 삭제한다.
     *
     * @param index 삭제할 위치. 0-based.
     * @return 삭제된 데이터.
     */
    @Throws(IndexOutOfBoundsException::class)
    fun remove(index: Int): E

    /**
     * 모든 데이터를 삭제한다.
     */
    fun clear()
}