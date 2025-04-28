# Binary Search

```kotlin
fun search(nums: IntArray, target: Int): Int {
    var l = 0;
    var r = nums.size - 1;
    while (l <= r) {
        var mid = l + (r - l) / 2
        if (nums[mid] == target) {
            return mid
        } else if (target > nums[mid]) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    return -1
}
// TC : O(log N)
// SC : O(1)
```

## Tips

- How to identify binary search
    - find key terms sorted, search
    - Find min or max in given range such that...
- In interview ask,
    - Whether the array has duplicates ?
    - What to return if no search elem ?

1. [Bounds](Bounds.kt): Lower, Upper, Floor and ceil in sorted array
    - [35. Search Insert Position](https://leetcode.com/problems/search-insert-position/description/)
    - [278. First Bad Version](https://leetcode.com/problems/first-bad-version/description/)
    - [34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/) | [Kotlin Solution](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/solutions/6597558/kotlin-binary-search)
    - **Follow-up practice**
        - [2055. Plates Between Candles](https://leetcode.com/problems/plates-between-candles/description/)

2. Rotated Arrays
    - [33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/description/) | [Kotlin Solution](https://leetcode.com/problems/search-in-rotated-sorted-array/solutions/6597700/kotlin-binary-search-by-suhaas-livcd-f9xh)
    - [81. Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/) | [Kotlin Solution](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/solutions/6597931/kotlin-binary-search-by-suhaas-livcd-ijp8)
    - [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/) | [Kotlin Solution](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solutions/6597952/kotlin-binary-search-by-suhaas-livcd-onzl)
    - [154. Find Minimum in Rotated Sorted Array II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/) | [Kotlin Solution](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/solutions/6597977/kotlin-binary-search-by-suhaas-livcd-44ak)
    - Q : Find number of time array rotated ? Ans : Based on the min element index position

3. Analyzing the direction
    - [540. Single Element in a Sorted Array](https://leetcode.com/problems/single-element-in-a-sorted-array/description/) | [kotlin Solution](https://leetcode.com/problems/single-element-in-a-sorted-array/solutions/6598010/kotlin-binary-search-by-suhaas-livcd-63di)
    - [162. Find Peak Element](https://leetcode.com/problems/find-peak-element/description/) [kotlin Solution](https://leetcode.com/problems/find-peak-element/solutions/6598111/kotlin-binary-search-by-suhaas-livcd-oxf5)
    - [69. Sqrt(x)](https://leetcode.com/problems/sqrtx/description/) | [kotlin Solution](https://leetcode.com/problems/sqrtx/solutions/6598384/kotlin-binary-search-by-suhaas-livcd-yi8j)
    - [875. Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/description/) | [Kotlin Solution](https://leetcode.com/problems/koko-eating-bananas/solutions/6598971/kotlin-binary-search-by-suhaas-livcd-evce)
    - [1482. Minimum Number of Days to Make m Bouquets](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/) | [Kotlin Solution](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/solutions/6607850/kotlin-binary-search-by-suhaas-livcd-71zh)
    - [1283. Find the Smallest Divisor Given a Threshold](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/) | [Kotlin Solution](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/solutions/6607958/kotlin-binary-search-by-suhaas-livcd-8j8v)