package helloAlgo.chapter7;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组表示下的二叉树类
 * @Author liutingfeng
 * @Date 2023/9/22 17:27
 */
public class ArrayBinaryTree {
    private List<Integer> tree;

    public ArrayBinaryTree(List<Integer> arr) {
        tree = new ArrayList<>(arr);
    }

    public int size() {
        return tree.size();
    }

    public Integer val(int i) {
        if (i < 0 || i > size()) {
            return null;
        }
        return tree.get(i);
    }

    // i  2 * i + 1  2 * i + 2
    public Integer left(int i) {
        return 2 * i + 1;
    }

    public Integer right(int i) {
        return 2 * i + 2;
    }

    public Integer parent(int i) {
        return (i - 1) / 2;
    }

    public List<Integer> levelOrder() {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            if (val(i) != null)
                res.add(val(i));
        }
        return res;
    }

    private void dfs(Integer i, String order, List<Integer> res) {
        if (val(i) == null)
            return;
        if ("pre".equals(order))
            res.add(val(i));
        dfs(left(i), order, res);
        if ("in".equals(order))
            res.add(val(i));
        dfs(right(i), order, res);
        if ("post".equals(order))
            res.add(val(i));
    }

    private List<Integer> preOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "pre", res);
        return res;
    }
}
