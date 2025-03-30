package binary_search

import kotlin.test.assertEquals

fun main() {
    val arr = intArrayOf(1, 2, 3, 3, 5, 8, 8, 10, 10, 11)
    var lowerBound = getLowerBound(arr)

    val a = 5
    val b = 5
    val c = 10

    // Basic equality assertion

    println("Hey")
    assertEquals(11, getLowerBound(intArrayOf(1, 2, 3)))
}

fun getLowerBound(arr: IntArray): Int {
    return 10
}
