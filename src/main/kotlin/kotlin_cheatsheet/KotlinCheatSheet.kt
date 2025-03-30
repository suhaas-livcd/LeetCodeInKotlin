package main.kotlin.kotlin_cheatsheet

import java.util.*
import kotlin.collections.ArrayDeque


fun main(args: Array<String>) {
    // Top level variables
    val applesExpired = 10
    var applesGrown = 20

    // ---- Character check if digit or letter or white space
    println(" Char : a letter : ${'a'.isLetter()}, digit : ${'a'.isDigit()}, whiteSpace : ${' '.isWhitespace()}")
    println(" Letter or digit : {'a'.isLetterOrDigit()}")
    println("Convert character to ascii : Letter : a ${'a'.toInt()}, Digit char to int : ${('8' - '0')}, else direct to int will return ascii ${'8'.toInt()}")

    // ----  String templates
    println("Top level apples are $applesExpired")
    // Augmented assignment operator
    applesGrown -= applesExpired // 10 expired apples
    println("After growing some were expire which resulted in $applesGrown")
    // String eval with curly braces
    println("But initially there were ${applesGrown + applesExpired}")

    // ----  Lists are ordered, allow duplicates
    var fruitsList = mutableListOf("apple", "bananna")
    println("Fruits list with count ${fruitsList.count()} : $fruitsList")

    var vegetablesList: MutableList<String> = mutableListOf()
    println("Before Vegetables present : ${vegetablesList.count()} are $vegetablesList")
    vegetablesList.add("potato")
    vegetablesList.add("carrot")
    println("After Vegetables present : ${vegetablesList.count()} are $vegetablesList")
    // Will throw No such element if the list is empty
    println("First vegetable added was : ${vegetablesList.first()} and last was ${vegetablesList.last()}")
    // Adding sublist
    vegetablesList.addAll(listOf("bitterguard", "cabbage"))
    println("After adding sublist  ${vegetablesList.count()}, $vegetablesList")

    // ----  Sets
    var colorSet = setOf("red", "green", "yellow", "red")
    println("Total colors : ${colorSet.count()}, $colorSet")
    var numSet: MutableSet<Int> = mutableSetOf()
    println("Add 1 : ${numSet.add(1)}")
    println("Add 1 again : ${numSet.add(1)}")
    println("Add 2 :${numSet.add(2)}")
    println("Elements after adding : ${numSet.count()}, ${numSet}")

    // ----  Map
    var numMap: MutableMap<Int, String> = mutableMapOf(3 to "Three")
    println("Map is ${numMap.count()}, $numMap")
    numMap.put(1, "one")
    numMap.put(2, "Two")
    println("Map is ${numMap.count()}, $numMap")
    println("Return put first time : ${numMap.put(4, "Four")}")
    println("Return put again : ${numMap.put(4, "four")}")
    println("Return put update : ${numMap.put(4, "FOUR")}")
    println("Return remove first :  ${numMap.remove(4)}")
    println("Return remove again :  ${numMap.remove(4)}")
    println("Check key exist : ${numMap.containsKey(1)}")
    println("Keys : ${numMap.keys}")
    println("Values : ${numMap.values}")
    // The type should be in specific with the mentioned key,value pair data type
    println("In Map : ${1 in numMap.keys} and ${"1" in numMap.values}")

    // ----  Pair
    var pairIs = Pair(1, "One")
    println("Pair : $pairIs,  first : ${pairIs.first}")
    // Using infix notation
    pairIs = 2 to "Two"
    println("Update pair $pairIs, (first, second) = ${pairIs.first},${pairIs.second}")


    // ---- CONTROL FLOW
    for (i in 1..<4) {
        print("$i ")
    }

    var nums = intArrayOf(0, 1, 2)
    nums.forEachIndexed { idx, elem ->
        println("$idx, $elem")
    }

    print("\n--\n")

    // Reverse else use ..
    ('z' downTo 'L' step 2).forEach {
        print("$it ")
    }
    print("\n--\n")

    // ---- ARRAYs
    var arr: Array<Int?> = arrayOfNulls(3)
    arr[0] = 1
    arr.forEach {
        println("$it")
    }
    println("${arr.joinToString()}")
    // Empty Array
    var _arr = Array<Int>(26) { 0 }
    print("Array type : $_arr")
    print(_arr.contentToString())
    print('a'.code)
    print(_arr['a' - 'a'])
    // Creating specific array
    var _intArray = intArrayOf(1, 2, 3)
    println("Array Int Arrat : ${_intArray.contentToString()}")
    // Creates a two-dimensional array
    val twoDArray = Array(2) { Array<Int>(2) { 0 } }
    println(twoDArray.contentDeepToString())
    // [[0, 0], [0, 0]]

    // Creates a three-dimensional array
    val threeDArray = Array(3) { Array(3) { Array<Int>(3) { 0 } } }
    println(threeDArray.contentDeepToString())
    // [[[0, 0, 0], [0, 0, 0], [0, 0, 0]], [[0, 0, 0], [0, 0, 0], [0, 0, 0]], [[0, 0, 0], [0, 0, 0], [0, 0, 0]]]

    // ---- Frequency map
    var tasks = charArrayOf('A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'D')
    // If the array is native not boxed like Integer then needed to be converted else not requried.
    var freqMap = tasks.toTypedArray().groupingBy { it }.eachCount()
    println("\nFreqMap : $freqMap")
    // Array sorting


    // ---- Priority Queues
    // Peek also there
    var minHeap = PriorityQueue<Int>()
    minHeap.offer(20)
    minHeap.offer(10)
    minHeap.offer(30)
    print("\n MinHeap elems : ")
    while (minHeap.isNotEmpty()) {
        print("${minHeap.poll()}, ")
    }
    println()
    var maxHeap = PriorityQueue<Pair<Int, Int>>(compareBy { -it.second })
    // Max Heap var pq = PriorityQueue<Int>(compareBy{-it})
    maxHeap.offer(Pair(1, 10))
    maxHeap.offer(Pair(2, 5))
    maxHeap.offer(Pair(3, 30))
    print("\n MaxHeap elems : ")
    while (maxHeap.isNotEmpty()) {
        print("${maxHeap.poll()},")
    }
    // Initialize the PriorityQueue with an inline comparator using compareBy
    var minTripleHeap = PriorityQueue<Triple<Int, Int, Int>>(compareBy({ it.first }, { it.second }, { it.third }))

    // ----- Stack, Queue, Dequeu
    // Note : can use the inbuilt stack and LinkedList, but LL because of performance storing node pointer not good.
    // Stack has flaws while iteration (is-A, Has-A vector java)

    // -- Stack - FILO add First remove First
    var deck = ArrayDeque<Int>()
    deck.addFirst(10)
    deck.addFirst(20)
    deck.addFirst(30)
    // Peek
    println("\nDeck size : ${deck.size} and top is ${deck.first()} and elems : $deck")
    print("\n Removing from stack : ")
    while (deck.isNotEmpty()) {
        print("${deck.removeFirst()} -> ")
    }
    print("END\n")

    // -- Queue - FIFO add last remove First
    deck = ArrayDeque<Int>()
    deck.addLast(10)
    deck.addLast(20)
    deck.addLast(30)
    // Peek
    println("\nDeck size is ${deck.size} and top is ${deck.first()} and elems : $deck")
    while (deck.isNotEmpty()) {
        print("${deck.removeFirst()} -> ")
    }
    print("END\n")


    var intArr = intArrayOf(5, 3, 1, 4, 5)
    println(intArr.sorted())
    var interval1 = intArrayOf(15, 20);
    var interval2 = intArrayOf(5, 10);
    var interval3 = intArrayOf(0, 30)
    var int2dArr = arrayOf(interval1, interval2, interval3)
    print("\nBefore sorting : "); int2dArr.forEach { it.forEach { print("$it,") };print("  ") }
    print("\nAfter sorting : "); int2dArr.sortedBy { it[0] }.forEach { it.forEach { print("$it,") };print("  ") }
    println()


    // Swapping function
    // s[pos] = s[s.size - pos - 1].also{ s[s.size - pos - 1] = s[pos]}
    var a = 1
    var b = 2
    a = b.also { b = a }
    println(a) // print 2
    println(b) // print 1


}