package org.example.trees

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 *
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun buildTree(list: List<Int>): TreeNode? {

    // If list is empty then return null
    if (list.isEmpty()) {
        return null
    }

    val root = TreeNode(list[0])
    val deque = ArrayDeque<TreeNode>()
    deque.add(root)

    var i = 1
    while (i < list.size) {
        while (deque.isNotEmpty()) {
            var current = deque.removeFirst()

            // Add left child
            if (i < list.size) {
                current.left = TreeNode(list[i++])
                deque.addLast(current.left!!)
            }
            // Add right child
            if (i < list.size) {
                current.right = TreeNode(list[i++])
                deque.addLast(current.right!!)
            }
        }
    }

    return root
}


fun main() {
    val root = buildTree(listOf(4, 2, 7, 1, 3, 6, 9))

    // Traverse BFS
    traverseBFS(root)
}

fun traverseBFS(root: TreeNode?) {
    if (root == null) return
    val deque = ArrayDeque<TreeNode>()
    deque.add(root)
    while (deque.isNotEmpty()) {
        for (i in 0 until deque.size) {
            val current = deque.removeFirst()
            print("${current.`val`} ,")
            current.left?.let { deque.add(it) }
            current.right?.let { deque.add(it) }
        }
        println()
    }

}