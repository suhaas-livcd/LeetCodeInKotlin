package binary_search

/**
 * Given an array ‘arr’ of integer numbers, ‘arr[i]’ represents the number of pages in the ‘i-th’ book.
 *
 * There are ‘m’ number of students, and the task is to allocate all the books to the students.
 *
 * Allocate books in such a way that:
 *
 * 1. Each student gets at least one book.
 * 2. Each book should be allocated to only one student.
 * 3. Book allocation should be in a contiguous manner.
 *
 * You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum.
 *
 * If the allocation of books is not possible, return -1.
 *
 * Example:
 * Input: ‘n’ = 4 ‘m’ = 2
 * ‘arr’ = [12, 34, 67, 90]
 *
 * Output: 113
 *
 * Explanation: All possible ways to allocate the ‘4’ books to '2' students are:
 * 12 | 34, 67, 90 - the sum of all the pages of books allocated to student 1 is ‘12’, and student two is ‘34+ 67+ 90 = 191’, so the maximum is ‘max(12, 191)= 191’.
 * 12, 34 | 67, 90 - the sum of all the pages of books allocated to student 1 is ‘12+ 34 = 46’, and student two is ‘67+ 90 = 157’, so the maximum is ‘max(46, 157)= 157’.
 * 12, 34, 67 | 90 - the sum of all the pages of books allocated to student 1 is ‘12+ 34 +67 = 113’, and student two is ‘90’, so the maximum is ‘max(113, 90)= 113’.
 * We are getting the minimum in the last case.
 * Hence, answer is ‘113’.
 * Expected time complexity: The expected time complexity is O(n * log(s)), where ‘n’ is the number of integers in the array ‘arr’ and ‘s’ is the sum of all the elements of ‘arr’.
 * Constraints:
 * 2 <= 'n' <= 10 ^ 3
 * 1 <= 'm' <= 10 ^ 3
 * 1 <= 'arr[i]' <= 10 ^ 9
 */

/**
 * Sample Input 1:
 * 4 2
 * 12 34 67 90
 * Sample Output 1:
 * 113
 *
 *Sample Input 2:
 * 5 4
 * 25 46 28 49 24
 * Sample Output 2:
 * 71
 *
 */

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }
    val result = StringBuilder()

    println("n = $n, m = $m")
    println("arr = $arr")

    val maxMinDist = findPages(arr, n, m)
    result.append(maxMinDist).append("\n")
    println(result)
}

fun findPages(arr: List<Int>, n: Int, m: Int): Int {
    // Base conditions : If no of allocations exceed the books
    if (m > n) {
        return -1
    }

    val minPages = arr.max() // Atleast, that would be minimum sum, if each student gets a book
    val maxPages = arr.sum() // 1 student only and he gets all the books

    var l = minPages;
    var r = maxPages;
    var result = arr.sum()
    while (l <= r) {
        val mid = l + (r - l) / 2
        print("l : $l,  mid : $mid , r : $r")
        if (allottedStudents(mid, arr, m) > m) {
            println(" Possible ")
            // Minimize
            l = mid + 1
        } else {
            println(" Not possible ")
            result = minOf(result, mid)
            r = mid - 1
        }
    }

    return result
}

fun allottedStudents(mid: Int, arr: List<Int>, m: Int): Int {
    var allocate = 0
    var individualAllocation = 0
    for (i in arr.indices) {
        if (individualAllocation + arr[i] <= mid) {
            individualAllocation += arr[i]
        } else {
            allocate += 1
            individualAllocation = arr[i]
        }
    }

    if (individualAllocation <= mid) {
        allocate += 1
    }

    print(", allocate : $allocate, $m")

    return allocate
}
