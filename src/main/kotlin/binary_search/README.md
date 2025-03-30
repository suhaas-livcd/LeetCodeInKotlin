# Binary Search

```kotlin
fun search(nums: IntArray, target: Int): Int {
    var l = 0;
    var r = nums.size - 1;
    while (l < = r) {
        var mid = l + (r - l) / 2
        if (nums[mid] = = target) {
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