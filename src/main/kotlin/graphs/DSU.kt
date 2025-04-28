package org.example.graphs

import kotlin.test.assertEquals

class DSU(size: Int) {
    val parent = IntArray(size + 1) { it } // Initializing the parents pointing to itself
    val size = IntArray(size + 1) { 1 } // Initially all components contain themselves

    fun union(x: Int, y: Int) {
        val pX = find(x)
        val pY = find(y)

        if (pX == pY) {
            return
        } else if (size[pX] >= size[pY]) {
            parent[pY] = pX
            size[pX] += size[pY]
        } else {
            parent[pX] = pY
            size[pY] += size[pX]
        }
    }

    fun find(x: Int): Int {
        println("x : $x")
        if (parent[x] != x) {
            parent[x] = find(parent[x]) // Path compression
        }

        return parent[x]
    }
}

fun main() {
    val dsu = DSU(7)
    dsu.union(1, 2)
    dsu.union(2, 3)

    assertEquals(dsu.find(3), 1)
    println("----${dsu.parent.contentToString()}")
    println(" ${dsu.find(3)}")
    dsu.union(4, 5)
    println(" ${dsu.find(5)}")
    dsu.union(6, 7)
    dsu.union(5, 6)
    println(" ${dsu.find(6)}")
    dsu.union(3, 7)
    println("${dsu.parent.contentToString()}")
    println("${dsu.size.contentToString()}")
//    println("Size of 7 : ${dsu.size[dsu.find(1)]}")

    println("${dsu.parent.contentToString()}")
    println("${dsu.size.contentToString()}")

}