package helloAlgo.chapter7;

import helloAlgo.utils.PrintUtil;

import java.util.*;

/**
 * @Author liutingfeng
 * @Date 2023/9/22 19:46
 */
public class MaxHeap {
    private List<Integer> maxHeap;

    public MaxHeap(List<Integer> nums) {
        maxHeap = new ArrayList<>(nums);
        /** 非叶子节点开始  */
        for (int i = parent(size() - 1); i >= 0; i --) {
            shiftDown(i);
        }
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i +2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(int i, int j) {
        int t = maxHeap.get(i);
        maxHeap.set(i, maxHeap.get(j));
        maxHeap.set(j, t);
    }

    public int size() {
        return maxHeap.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int peek() {
        return maxHeap.get(0);
    }

    public void push(int val) {
        maxHeap.add(val);
        shiftUp(maxHeap.size() - 1);
    }

    // 从下往上
    private void shiftUp(int i) {
        while (true) {
            int p = parent(i);
            if (p < 0 || maxHeap.get(p) >= maxHeap.get(i))
                break;
            swap(i, p);
            i = p;
        }
    }

    public int pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        swap(0, size() - 1);
        int val = maxHeap.remove(size() - 1);
        shiftDown(0);
        return val;
    }

    private void shiftDown(int i) {
        while (true) {
            int l = left(i), r = right(i);
            int ma = i;
            if (l < size() && maxHeap.get(l) > maxHeap.get(ma)) {
                ma = l;
            }
            if (r < size() && maxHeap.get(r) > maxHeap.get(ma)) {
                ma = l;
            }
            if (ma == i)
                break;
            swap(i, ma);
            i = ma;
        }
    }

    public void print() {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.addAll(maxHeap);
        PrintUtil.printHeap(queue);
    }

    public static void main(String[] args) {
        /* 初始化大顶堆 */
        MaxHeap maxHeap = new MaxHeap(Arrays.asList(9, 8, 6, 6, 7, 5, 2, 1, 4, 3, 6, 2));
        System.out.println("\n输入列表并建堆后");
        maxHeap.print();

        /* 获取堆顶元素 */
        int peek = maxHeap.peek();
        System.out.format("\n堆顶元素为 %d\n", peek);

        /* 元素入堆 */
        int val = 7;
        maxHeap.push(val);
        System.out.format("\n元素 %d 入堆后\n", val);
        maxHeap.print();

        /* 堆顶元素出堆 */
        peek = maxHeap.pop();
        System.out.format("\n堆顶元素 %d 出堆后\n", peek);
        maxHeap.print();

        /* 获取堆大小 */
        int size = maxHeap.size();
        System.out.format("\n堆元素数量为 %d\n", size);

        /* 判断堆是否为空 */
        boolean isEmpty = maxHeap.isEmpty();
        System.out.format("\n堆是否为空 %b\n", isEmpty);
    }
}
