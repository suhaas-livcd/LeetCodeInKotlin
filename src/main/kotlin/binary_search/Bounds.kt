package binary_search

import kotlin.test.assertEquals

/**
 * Lower Bound : Smallest idx such that arr[idx] >= x
 * TC : O(Log N)
 */
fun getLowerBound(nums: IntArray, target: Int): Int {
    var l = 0;
    var r = nums.size - 1;
    var result = nums.size

    while (l <= r) {
        val mid = l + (r - l) / 2
        if (nums[mid] >= target) {
            result = mid
            r = mid - 1
        } else {
            l = mid + 1
        }
    }

    return result
}

/**
 * Lower Bound : Smallest idx such that arr[idx] > x
 * TC : O(Log N)
 */
fun getUpperBound(nums: IntArray, target: Int): Int {
    var l = 0;
    var r = nums.size - 1
    var result = nums.size
    while (l <= r) {
        val mid = l + (r - l) / 2
        if (nums[mid] > target) {
            result = mid
            r = mid - 1
        } else {
            l = mid + 1
        }
    }

    return result
}

/**
 * Floor : largest number in array <= x
 * Ceil : Smallest number in array >= x
 * @return Pair of floor and ceil
 */
fun getFloorAndCeil(nums: IntArray, target: Int): Pair<Int, Int> {
    var floor = -1;
    var ceil = -1;
    var l = 0;
    var r = nums.size - 1;
    while (l <= r) {
        val mid = l + (r - l) / 2
        if (nums[mid] == target) {
            return Pair(nums[mid], nums[mid])
        } else if (nums[mid] > target) {
            ceil = nums[mid]
            r = mid - 1
        } else {
            floor = nums[mid]
            l = mid + 1
        }
    }


    return Pair(floor, ceil)
}

fun main() {
    var arr = intArrayOf(1, 2, 3, 3, 5, 8, 8, 10, 10, 11) // Size : 10
    // Lower Bound
    assertEquals(7, getLowerBound(arr, 10))
    assertEquals(10, getLowerBound(arr, 12))
    assertEquals(0, getLowerBound(arr, 1))
    assertEquals(9, getLowerBound(arr, 11))
    assertEquals(2, getLowerBound(arr, 3))
    assertEquals(7, getLowerBound(arr, 9))


    // Upper Bound
    arr = intArrayOf(2, 3, 6, 7, 8, 8, 11, 11, 11, 12) // Size : 10
    assertEquals(3, getUpperBound(arr, 6))
    assertEquals(9, getUpperBound(arr, 11))
    assertEquals(10, getUpperBound(arr, 12))
    assertEquals(10, getUpperBound(arr, 13))
    assertEquals(0, getUpperBound(arr, 0))

    // Floor and Ceil
    arr = intArrayOf(10, 20, 30, 40, 50) // Size : 5
    assertEquals(Pair(20, 30), getFloorAndCeil(arr, 25))
    arr = intArrayOf(10, 20, 25, 30, 40) // Size : 5
    assertEquals(Pair(25, 25), getFloorAndCeil(arr, 25))
}