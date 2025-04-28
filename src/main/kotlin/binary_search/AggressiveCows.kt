package binary_search

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))  // Faster input
    val t = reader.readLine().toInt()  // Read the number of test cases
    val result = StringBuilder()  // Use StringBuilder for efficient outpu

    repeat(t) {
        val (n, c) = reader.readLine().split(" ").map { it.toInt() }  // Read N and C
        val stalls = IntArray(n) { reader.readLine().toInt() }
        // Read stall locations
//        println("N: $n, C: $c, Stalls: ${stalls.contentToString()}")  // Debugging print

        val maxMinDist = findLargestMinimumDistance(stalls, c)  // Your function to compute result
        result.append(maxMinDist).append("\n") // Append result to StringBuilder
    }
    println(result)
}

fun findLargestMinimumDistance(stalls: IntArray, c: Int): Int {
    stalls.sort()
//    println("stalls  : ${stalls.contentToString()}")

    var l = 1
    var r = stalls[stalls.size - 1] - stalls[0]
    var ans = -1
    while (l <= r) {
        val mid = l + (r - l) / 2
//        println("l : $l, mid : $mid, r : $r")
        if (isPossible(mid, stalls, c)) {
//            println("Possible Mid : $mid")
            ans = max(mid, ans)
            l = mid + 1
        } else {
            r = mid - 1
        }
    }

    return ans
}


fun isPossible(minDistance: Int, stalls: IntArray, c: Int): Boolean {
    var last = stalls[0]
    var placed = 1
    for (i in 0 until stalls.size) {
        if (stalls[i] - last >= minDistance) {
            last = stalls[i]
            placed += 1
        }
    }

    return placed >= c
}