package LCKotlin

class LC538 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    companion object {
        var lastValue = 0
    }

    fun convertBST(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        lastValue = 0
        postOrder(root)
        return root
    }

    fun postOrder(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        postOrder(root.right)
        root.`val` += lastValue
        lastValue = root.`val`
        postOrder(root.left)
        return root
    }
}