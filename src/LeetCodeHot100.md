# LeetCode Hot 100

> 按题号从小到大排列，包含考察知识点、解题思路、Java 核心代码。

---

### 1. 两数之和 (简单) — 哈希

**考察知识点**：哈希表

**解题思路**：遍历数组，对每个元素 `nums[i]`，在哈希表中查找 `target - nums[i]` 是否存在。若存在直接返回，否则将当前元素及其下标存入哈希表。一次遍历完成。

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        map.put(nums[i], i);
    }
    return new int[]{};
}
```

---

### 2. 两数相加 (中等) — 链表

**考察知识点**：链表、模拟进位

**解题思路**：同时遍历两个链表，逐位相加并维护进位 `carry`。用哑节点简化头节点处理。两链表都遍历完且进位为 0 时结束。

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0), cur = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
        int sum = carry;
        if (l1 != null) { sum += l1.val; l1 = l1.next; }
        if (l2 != null) { sum += l2.val; l2 = l2.next; }
        carry = sum / 10;
        cur.next = new ListNode(sum % 10);
        cur = cur.next;
    }
    return dummy.next;
}
```

---

### 3. 无重复字符的最长子串 (中等) — 滑动窗口

**考察知识点**：滑动窗口、哈希表

**解题思路**：用哈希表记录窗口内字符最后出现的位置。右指针扩展窗口，若当前字符已在窗口内，左指针跳到该字符上次出现位置的下一位，更新最大长度。

```java
public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int ans = 0, l = 0;
    for (int r = 0; r < s.length(); r++) {
        char c = s.charAt(r);
        if (map.containsKey(c) && map.get(c) >= l) {
            l = map.get(c) + 1;
        }
        map.put(c, r);
        ans = Math.max(ans, r - l + 1);
    }
    return ans;
}
```

---

### 4. 寻找两个正序数组的中位数 (困难) — 二分查找

**考察知识点**：二分查找

**解题思路**：在较短数组上二分，找一个分割点 i，使得两数组左半部分总长为 `(m+n+1)/2`。确保 `nums1[i-1] <= nums2[j]` 且 `nums2[j-1] <= nums1[i]`，由此确定中位数。

```java
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
    int m = nums1.length, n = nums2.length, lo = 0, hi = m;
    while (lo <= hi) {
        int i = (lo + hi) / 2, j = (m + n + 1) / 2 - i;
        int l1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int r1 = i == m ? Integer.MAX_VALUE : nums1[i];
        int l2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int r2 = j == n ? Integer.MAX_VALUE : nums2[j];
        if (l1 <= r2 && l2 <= r1) {
            return (m + n) % 2 == 0 ? (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0 : Math.max(l1, l2);
        } else if (l1 > r2) hi = i - 1;
        else lo = i + 1;
    }
    return 0;
}
```

---

### 5. 最长回文子串 (中等) — 多维动态规划

**考察知识点**：中心扩展法

**解题思路**：枚举每个字符和每对相邻字符作为回文中心，向两侧扩展，记录最长回文的起始位置和长度。时间 O(n²)，空间 O(1)。

```java
public String longestPalindrome(String s) {
    int start = 0, maxLen = 1;
    for (int i = 0; i < s.length(); i++) {
        int len = Math.max(expand(s, i, i), expand(s, i, i + 1));
        if (len > maxLen) { maxLen = len; start = i - (len - 1) / 2; }
    }
    return s.substring(start, start + maxLen);
}
private int expand(String s, int l, int r) {
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { l--; r++; }
    return r - l - 1;
}
```

---

### 11. 盛最多水的容器 (中等) — 双指针

**考察知识点**：双指针、贪心

**解题思路**：左右双指针，每次移动较短的那侧。移动较长侧只会让宽度减小且高度不增，容量只减不增；移动较短侧才有可能找到更大容量。

```java
public int maxArea(int[] height) {
    int l = 0, r = height.length - 1, ans = 0;
    while (l < r) {
        ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
        if (height[l] < height[r]) l++;
        else r--;
    }
    return ans;
}
```

---

### 15. 三数之和 (中等) — 双指针

**考察知识点**：排序、双指针、去重

**解题思路**：先排序。固定第一个数 `nums[i]`，用左右双指针在 `i+1` 到末尾查找两数之和为 `-nums[i]` 的组合。注意跳过相邻重复元素。

```java
public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        int l = i + 1, r = nums.length - 1;
        while (l < r) {
            int sum = nums[i] + nums[l] + nums[r];
            if (sum == 0) {
                ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                while (l < r && nums[l] == nums[l + 1]) l++;
                while (l < r && nums[r] == nums[r - 1]) r--;
                l++; r--;
            } else if (sum < 0) l++;
            else r--;
        }
    }
    return ans;
}
```

---

### 17. 电话号码的字母组合 (中等) — 回溯

**考察知识点**：回溯

**解题思路**：建立数字到字母的映射。回溯时每次取当前下标对应的字母集，逐个字母添加到路径，递归处理下一个数字，回溯时删除最后一个字母。

```java
public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) return new ArrayList<>();
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();
    backtrack(digits, 0, new StringBuilder(), ans, map);
    return ans;
}
private void backtrack(String digits, int idx, StringBuilder path, List<String> ans, String[] map) {
    if (idx == digits.length()) { ans.add(path.toString()); return; }
    for (char c : map[digits.charAt(idx) - '0'].toCharArray()) {
        path.append(c);
        backtrack(digits, idx + 1, path, ans, map);
        path.deleteCharAt(path.length() - 1);
    }
}
```

---

### 19. 删除链表的倒数第 N 个结点 (中等) — 链表

**考察知识点**：链表、快慢指针

**解题思路**：快指针先走 n+1 步，然后快慢指针同步走，快指针到达末尾时慢指针指向待删节点的前驱节点，执行删除。哑节点处理头节点被删的情况。

```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head), fast = dummy, slow = dummy;
    for (int i = 0; i <= n; i++) fast = fast.next;
    while (fast != null) { fast = fast.next; slow = slow.next; }
    slow.next = slow.next.next;
    return dummy.next;
}
```

---

### 20. 有效的括号 (简单) — 栈

**考察知识点**：栈

**解题思路**：遍历字符串，遇到左括号入栈，遇到右括号时检查栈顶是否为对应左括号，不匹配或栈空则返回 false。最终栈为空则合法。

```java
public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '[' || c == '{') stack.push(c);
        else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if (c == ')' && top != '(') return false;
            if (c == ']' && top != '[') return false;
            if (c == '}' && top != '{') return false;
        }
    }
    return stack.isEmpty();
}
```

---

### 21. 合并两个有序链表 (简单) — 链表

**考察知识点**：链表、迭代

**解题思路**：哑节点 + 迭代。每次比较两链表当前节点大小，将较小的接到结果链表，直到其中一个遍历完，将另一个剩余部分直接拼接。

```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0), cur = dummy;
    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) { cur.next = l1; l1 = l1.next; }
        else { cur.next = l2; l2 = l2.next; }
        cur = cur.next;
    }
    cur.next = l1 != null ? l1 : l2;
    return dummy.next;
}
```

---

### 22. 括号生成 (中等) — 回溯

**考察知识点**：回溯

**解题思路**：维护已用左括号数 `open` 和右括号数 `close`。当 `open < n` 时可加左括号；当 `close < open` 时可加右括号。路径长度达到 `2n` 时加入结果。

```java
public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
    backtrack(ans, new StringBuilder(), 0, 0, n);
    return ans;
}
private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int n) {
    if (cur.length() == 2 * n) { ans.add(cur.toString()); return; }
    if (open < n) { cur.append('('); backtrack(ans, cur, open + 1, close, n); cur.deleteCharAt(cur.length() - 1); }
    if (close < open) { cur.append(')'); backtrack(ans, cur, open, close + 1, n); cur.deleteCharAt(cur.length() - 1); }
}
```

---

### 23. 合并 K 个升序链表 (困难) — 链表

**考察知识点**：链表、优先队列（最小堆）

**解题思路**：将 K 个链表的头节点放入最小堆，每次取出最小节点接到结果链表，并将该节点的下一个节点加入堆，直到堆为空。

```java
public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (ListNode node : lists) if (node != null) pq.offer(node);
    ListNode dummy = new ListNode(0), cur = dummy;
    while (!pq.isEmpty()) {
        cur.next = pq.poll();
        cur = cur.next;
        if (cur.next != null) pq.offer(cur.next);
    }
    return dummy.next;
}
```

---

### 24. 两两交换链表中的节点 (中等) — 链表

**考察知识点**：链表、模拟

**解题思路**：哑节点 + 迭代。每次取相邻两节点 `first` 和 `second`，调整指针完成交换，指针前进两步。

```java
public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0, head), prev = dummy;
    while (prev.next != null && prev.next.next != null) {
        ListNode first = prev.next, second = prev.next.next;
        prev.next = second;
        first.next = second.next;
        second.next = first;
        prev = first;
    }
    return dummy.next;
}
```

---

### 25. K 个一组翻转链表 (困难) — 链表

**考察知识点**：链表、分组翻转

**解题思路**：每次先检查剩余节点是否有 k 个，不足则停止。将 k 个节点翻转后接回原链表，继续处理下一组。

```java
public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0, head), prev = dummy;
    while (true) {
        ListNode tail = prev;
        for (int i = 0; i < k; i++) { tail = tail.next; if (tail == null) return dummy.next; }
        ListNode start = prev.next, next = tail.next;
        tail.next = null;
        prev.next = reverse(start);
        start.next = next;
        prev = start;
    }
}
private ListNode reverse(ListNode head) {
    ListNode prev = null, cur = head;
    while (cur != null) { ListNode next = cur.next; cur.next = prev; prev = cur; cur = next; }
    return prev;
}
```

---

### 31. 下一个排列 (中等) — 技巧

**考察知识点**：数组规律

**解题思路**：从右往左找第一个下降点 i（`nums[i] < nums[i+1]`）；再从右往左找第一个大于 `nums[i]` 的数 j，交换；最后将 i+1 到末尾翻转为升序。若无下降点则整体翻转。

```java
public void nextPermutation(int[] nums) {
    int i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) i--;
    if (i >= 0) {
        int j = nums.length - 1;
        while (nums[j] <= nums[i]) j--;
        int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
    }
    int l = i + 1, r = nums.length - 1;
    while (l < r) { int t = nums[l]; nums[l++] = nums[r]; nums[r--] = t; }
}
```

---

### 32. 最长有效括号 (困难) — 动态规划

**考察知识点**：动态规划、栈

**解题思路**：栈法：栈中存下标，初始压入 -1 作为哨兵。遇 `(` 入栈；遇 `)` 弹出栈顶，若栈空则压入当前下标作新哨兵，否则用当前下标减栈顶更新最大长度。

```java
public int longestValidParentheses(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(-1);
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') stack.push(i);
        else {
            stack.pop();
            if (stack.isEmpty()) stack.push(i);
            else ans = Math.max(ans, i - stack.peek());
        }
    }
    return ans;
}
```

---

### 33. 搜索旋转排序数组 (中等) — 二分查找

**考察知识点**：二分查找

**解题思路**：二分时先判断哪半段有序：若左半有序且 target 在左半范围内则搜左，否则搜右；若右半有序且 target 在右半范围内则搜右，否则搜左。

```java
public int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) return mid;
        if (nums[l] <= nums[mid]) {
            if (nums[l] <= target && target < nums[mid]) r = mid - 1;
            else l = mid + 1;
        } else {
            if (nums[mid] < target && target <= nums[r]) l = mid + 1;
            else r = mid - 1;
        }
    }
    return -1;
}
```

---

### 34. 在排序数组中查找元素的第一个和最后一个位置 (中等) — 二分查找

**考察知识点**：二分查找（左右边界）

**解题思路**：两次二分分别查找左边界和右边界。查找左边界时，`nums[mid] == target` 不立即返回，令 `r = mid - 1` 继续收缩；查找右边界类似，令 `l = mid + 1`。

```java
public int[] searchRange(int[] nums, int target) {
    return new int[]{findFirst(nums, target), findLast(nums, target)};
}
private int findFirst(int[] nums, int target) {
    int l = 0, r = nums.length - 1, ans = -1;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) { ans = mid; r = mid - 1; }
        else if (nums[mid] < target) l = mid + 1;
        else r = mid - 1;
    }
    return ans;
}
private int findLast(int[] nums, int target) {
    int l = 0, r = nums.length - 1, ans = -1;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) { ans = mid; l = mid + 1; }
        else if (nums[mid] < target) l = mid + 1;
        else r = mid - 1;
    }
    return ans;
}
```

---

### 35. 搜索插入位置 (简单) — 二分查找

**考察知识点**：二分查找

**解题思路**：标准二分查找左边界。找第一个 `>= target` 的位置，`nums[mid] < target` 时 `l = mid + 1`，否则 `r = mid - 1`，最终返回 `l`。

```java
public int searchInsert(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] < target) l = mid + 1;
        else r = mid - 1;
    }
    return l;
}
```

---

### 39. 组合总和 (中等) — 回溯

**考察知识点**：回溯、剪枝

**解题思路**：排序后回溯。从当前下标开始枚举（允许重复选），选择当前数后递归，总和超过 target 时剪枝。

```java
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(candidates, target, 0, new ArrayList<>(), ans);
    return ans;
}
private void backtrack(int[] candidates, int remain, int start, List<Integer> path, List<List<Integer>> ans) {
    if (remain == 0) { ans.add(new ArrayList<>(path)); return; }
    for (int i = start; i < candidates.length; i++) {
        if (candidates[i] > remain) break;
        path.add(candidates[i]);
        backtrack(candidates, remain - candidates[i], i, path, ans);
        path.remove(path.size() - 1);
    }
}
```

---

### 41. 缺失的第一个正数 (困难) — 普通数组

**考察知识点**：原地哈希

**解题思路**：将每个在 `[1, n]` 范围内的数 `x` 放到下标 `x-1` 的位置（置换法）。再次遍历找第一个 `nums[i] != i+1` 的位置，答案为 `i+1`；若全部正确则答案为 `n+1`。

```java
public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
        while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
            int t = nums[nums[i] - 1]; nums[nums[i] - 1] = nums[i]; nums[i] = t;
        }
    }
    for (int i = 0; i < n; i++) if (nums[i] != i + 1) return i + 1;
    return n + 1;
}
```

---

### 42. 接雨水 (困难) — 双指针

**考察知识点**：双指针、前缀最大值

**解题思路**：左右双指针，维护 `leftMax` 和 `rightMax`。若 `leftMax < rightMax`，左指针处能接的水为 `leftMax - height[l]`，左指针右移；否则右指针处能接的水为 `rightMax - height[r]`，右指针左移。

```java
public int trap(int[] height) {
    int l = 0, r = height.length - 1, leftMax = 0, rightMax = 0, ans = 0;
    while (l < r) {
        leftMax = Math.max(leftMax, height[l]);
        rightMax = Math.max(rightMax, height[r]);
        if (leftMax < rightMax) ans += leftMax - height[l++];
        else ans += rightMax - height[r--];
    }
    return ans;
}
```

---

### 45. 跳跃游戏 II (中等) — 贪心算法

**考察知识点**：贪心

**解题思路**：维护当前跳跃能到达的最远位置 `curEnd` 和遍历中能到达的最远位置 `farthest`。遍历到 `curEnd` 时必须跳一步，更新 `curEnd = farthest`，步数加一。

```java
public int jump(int[] nums) {
    int jumps = 0, curEnd = 0, farthest = 0;
    for (int i = 0; i < nums.length - 1; i++) {
        farthest = Math.max(farthest, i + nums[i]);
        if (i == curEnd) { jumps++; curEnd = farthest; }
    }
    return jumps;
}
```

---

### 46. 全排列 (中等) — 回溯

**考察知识点**：回溯

**解题思路**：用 `used` 布尔数组标记已选元素。回溯时枚举所有未使用的数，选择后标记，递归，回溯时取消标记。路径长度等于数组长度时加入结果。

```java
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(nums, new boolean[nums.length], new ArrayList<>(), ans);
    return ans;
}
private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> ans) {
    if (path.size() == nums.length) { ans.add(new ArrayList<>(path)); return; }
    for (int i = 0; i < nums.length; i++) {
        if (used[i]) continue;
        used[i] = true; path.add(nums[i]);
        backtrack(nums, used, path, ans);
        path.remove(path.size() - 1); used[i] = false;
    }
}
```

---

### 48. 旋转图像 (中等) — 矩阵

**考察知识点**：矩阵变换

**解题思路**：顺时针旋转 90° = 先沿主对角线转置，再水平翻转（每行左右对称翻转）。

```java
public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++)
        for (int j = i + 1; j < n; j++) {
            int t = matrix[i][j]; matrix[i][j] = matrix[j][i]; matrix[j][i] = t;
        }
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n / 2; j++) {
            int t = matrix[i][j]; matrix[i][j] = matrix[i][n-1-j]; matrix[i][n-1-j] = t;
        }
}
```

---

### 49. 字母异位词分组 (中等) — 哈希

**考察知识点**：哈希表、字符串排序

**解题思路**：将每个字符串排序后作为哈希表的 key，同一组异位词排序结果相同，归为一组。

```java
public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
    }
    return new ArrayList<>(map.values());
}
```

---

### 51. N 皇后 (困难) — 回溯

**考察知识点**：回溯

**解题思路**：逐行放置皇后，用三个集合分别记录已占用的列、左对角线（row-col）、右对角线（row+col）。每行枚举合法列，放置后递归下一行，回溯时撤销。

```java
public List<List<String>> solveNQueens(int n) {
    List<List<String>> ans = new ArrayList<>();
    char[][] board = new char[n][n];
    for (char[] row : board) Arrays.fill(row, '.');
    backtrack(board, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), ans);
    return ans;
}
private void backtrack(char[][] board, int row, Set<Integer> cols, Set<Integer> d1, Set<Integer> d2, List<List<String>> ans) {
    if (row == board.length) {
        List<String> list = new ArrayList<>();
        for (char[] r : board) list.add(new String(r));
        ans.add(list); return;
    }
    for (int col = 0; col < board.length; col++) {
        if (cols.contains(col) || d1.contains(row - col) || d2.contains(row + col)) continue;
        board[row][col] = 'Q'; cols.add(col); d1.add(row - col); d2.add(row + col);
        backtrack(board, row + 1, cols, d1, d2, ans);
        board[row][col] = '.'; cols.remove(col); d1.remove(row - col); d2.remove(row + col);
    }
}
```

---

### 53. 最大子数组和 (中等) — 普通数组

**考察知识点**：动态规划（Kadane 算法）

**解题思路**：`dp` 表示以当前元素结尾的最大子数组和。状态转移：`dp = max(nums[i], dp + nums[i])`，即要么新起一段，要么接续前段。

```java
public int maxSubArray(int[] nums) {
    int ans = nums[0], dp = nums[0];
    for (int i = 1; i < nums.length; i++) {
        dp = Math.max(nums[i], dp + nums[i]);
        ans = Math.max(ans, dp);
    }
    return ans;
}
```

---

### 54. 螺旋矩阵 (中等) — 矩阵

**考察知识点**：矩阵模拟

**解题思路**：维护上下左右四个边界，按"右→下→左→上"顺序遍历，每遍历完一个方向就收缩对应边界。

```java
public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
    while (top <= bottom && left <= right) {
        for (int i = left; i <= right; i++) ans.add(matrix[top][i]); top++;
        for (int i = top; i <= bottom; i++) ans.add(matrix[i][right]); right--;
        if (top <= bottom) for (int i = right; i >= left; i--) ans.add(matrix[bottom][i]); bottom--;
        if (left <= right) for (int i = bottom; i >= top; i--) ans.add(matrix[i][left]); left++;
    }
    return ans;
}
```

---

### 55. 跳跃游戏 (中等) — 贪心算法

**考察知识点**：贪心

**解题思路**：维护能到达的最远位置 `maxReach`。遍历时若 `i > maxReach` 则无法继续，返回 false。每步更新 `maxReach`，最终若 `maxReach >= n-1` 则返回 true。

```java
public boolean canJump(int[] nums) {
    int maxReach = 0;
    for (int i = 0; i < nums.length; i++) {
        if (i > maxReach) return false;
        maxReach = Math.max(maxReach, i + nums[i]);
    }
    return true;
}
```

---

### 56. 合并区间 (中等) — 普通数组

**考察知识点**：排序、数组

**解题思路**：按区间左端点排序，遍历区间。若当前区间左端点 <= 结果集最后区间的右端点，则合并（取右端点最大值）；否则直接加入结果集。

```java
public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> ans = new ArrayList<>();
    for (int[] iv : intervals) {
        if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < iv[0]) ans.add(iv);
        else ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], iv[1]);
    }
    return ans.toArray(new int[0][]);
}
```

---

### 62. 不同路径 (中等) — 多维动态规划

**考察知识点**：动态规划

**解题思路**：`dp[i][j]` 表示到达 (i,j) 的路径数，等于上方和左方路径数之和。第一行和第一列均为 1。

```java
public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) dp[i][0] = 1;
    for (int j = 0; j < n; j++) dp[0][j] = 1;
    for (int i = 1; i < m; i++)
        for (int j = 1; j < n; j++)
            dp[i][j] = dp[i-1][j] + dp[i][j-1];
    return dp[m-1][n-1];
}
```

---

### 64. 最小路径和 (中等) — 多维动态规划

**考察知识点**：动态规划

**解题思路**：`dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]`，可原地修改 grid 节省空间。

```java
public int minPathSum(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++) {
            if (i == 0 && j == 0) continue;
            else if (i == 0) grid[i][j] += grid[i][j-1];
            else if (j == 0) grid[i][j] += grid[i-1][j];
            else grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
        }
    return grid[m-1][n-1];
}
```

---

### 70. 爬楼梯 (简单) — 动态规划

**考察知识点**：动态规划（斐波那契）

**解题思路**：`dp[i] = dp[i-1] + dp[i-2]`，到第 i 级楼梯可从 i-1 或 i-2 迈一步到达。滚动变量优化空间。

```java
public int climbStairs(int n) {
    if (n <= 2) return n;
    int a = 1, b = 2;
    for (int i = 3; i <= n; i++) { int c = a + b; a = b; b = c; }
    return b;
}
```

---

### 72. 编辑距离 (中等) — 多维动态规划

**考察知识点**：动态规划

**解题思路**：`dp[i][j]` 表示 `word1[0..i-1]` 到 `word2[0..j-1]` 的最少操作数。字符相同则 `dp[i][j] = dp[i-1][j-1]`；否则 `dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])`（删、插、替换）。

```java
public int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) dp[i][0] = i;
    for (int j = 0; j <= n; j++) dp[0][j] = j;
    for (int i = 1; i <= m; i++)
        for (int j = 1; j <= n; j++) {
            if (word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
            else dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
        }
    return dp[m][n];
}
```

---

### 73. 矩阵置零 (中等) — 矩阵

**考察知识点**：矩阵、原地标记

**解题思路**：用第一行和第一列作为标记数组。先记录第一行/列本身是否含零，再遍历其余元素，将零元素的行列标记到第一行/列，最后根据标记置零，再处理第一行/列。

```java
public void setZeroes(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    boolean row0 = false, col0 = false;
    for (int j = 0; j < n; j++) if (matrix[0][j] == 0) row0 = true;
    for (int i = 0; i < m; i++) if (matrix[i][0] == 0) col0 = true;
    for (int i = 1; i < m; i++)
        for (int j = 1; j < n; j++)
            if (matrix[i][j] == 0) { matrix[i][0] = 0; matrix[0][j] = 0; }
    for (int i = 1; i < m; i++)
        for (int j = 1; j < n; j++)
            if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
    if (row0) Arrays.fill(matrix[0], 0);
    if (col0) for (int i = 0; i < m; i++) matrix[i][0] = 0;
}
```

---

### 74. 搜索二维矩阵 (中等) — 二分查找

**考察知识点**：二分查找

**解题思路**：将二维矩阵视为一维有序数组，下标 `mid` 对应 `matrix[mid/n][mid%n]`，做一次标准二分即可。

```java
public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length, l = 0, r = m * n - 1;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        int val = matrix[mid / n][mid % n];
        if (val == target) return true;
        else if (val < target) l = mid + 1;
        else r = mid - 1;
    }
    return false;
}
```

---

### 75. 颜色分类 (中等) — 技巧

**考察知识点**：双指针（三路划分，荷兰国旗问题）

**解题思路**：维护三个指针：`low` 为 0 的右边界，`high` 为 2 的左边界，`mid` 为当前遍历指针。`nums[mid]==0` 与 `low` 交换，mid 和 low 右移；`nums[mid]==2` 与 `high` 交换，high 左移（mid 不动）；`nums[mid]==1` 则 mid 右移。

```java
public void sortColors(int[] nums) {
    int low = 0, mid = 0, high = nums.length - 1;
    while (mid <= high) {
        if (nums[mid] == 0) { int t = nums[low]; nums[low++] = nums[mid]; nums[mid++] = t; }
        else if (nums[mid] == 2) { int t = nums[high]; nums[high--] = nums[mid]; nums[mid] = t; }
        else mid++;
    }
}
```

---

### 76. 最小覆盖子串 (困难) — 子串

**考察知识点**：滑动窗口、哈希表

**解题思路**：用哈希表记录 t 中字符需求量，`need` 记录还需满足的字符种数。右指针扩展满足需求，`need==0` 时左指针收缩寻找最小窗口。

```java
public String minWindow(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
    int need = map.size(), l = 0, start = 0, minLen = Integer.MAX_VALUE;
    for (int r = 0; r < s.length(); r++) {
        char c = s.charAt(r);
        if (map.containsKey(c)) { map.put(c, map.get(c) - 1); if (map.get(c) == 0) need--; }
        while (need == 0) {
            if (r - l + 1 < minLen) { minLen = r - l + 1; start = l; }
            char lc = s.charAt(l++);
            if (map.containsKey(lc)) { if (map.get(lc) == 0) need++; map.put(lc, map.get(lc) + 1); }
        }
    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
}
```

---

### 78. 子集 (中等) — 回溯

**考察知识点**：回溯

**解题思路**：回溯时每进入一个状态就将当前路径加入结果（包含空集）。从当前 start 开始枚举，避免重复子集。

```java
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(nums, 0, new ArrayList<>(), ans);
    return ans;
}
private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> ans) {
    ans.add(new ArrayList<>(path));
    for (int i = start; i < nums.length; i++) {
        path.add(nums[i]);
        backtrack(nums, i + 1, path, ans);
        path.remove(path.size() - 1);
    }
}
```

---

### 79. 单词搜索 (中等) — 回溯

**考察知识点**：回溯、DFS

**解题思路**：枚举每个起始格，DFS 按四方向匹配 word 中的字符。访问过的格子临时标记为 `#` 防止重复使用，回溯时恢复原字符。

```java
public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++)
        for (int j = 0; j < board[0].length; j++)
            if (dfs(board, word, i, j, 0)) return true;
    return false;
}
private boolean dfs(char[][] board, String word, int i, int j, int k) {
    if (k == word.length()) return true;
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) return false;
    char tmp = board[i][j]; board[i][j] = '#';
    boolean res = dfs(board, word, i+1, j, k+1) || dfs(board, word, i-1, j, k+1)
               || dfs(board, word, i, j+1, k+1) || dfs(board, word, i, j-1, k+1);
    board[i][j] = tmp;
    return res;
}
```

---

### 84. 柱状图中最大的矩形 (困难) — 栈

**考察知识点**：单调栈

**解题思路**：维护单调递增栈。当前柱子高度小于栈顶时，弹出栈顶，以弹出高度为矩形高，宽度为当前下标到新栈顶下标之间的距离，计算面积。前后各加高度为 0 的哨兵简化边界处理。

```java
public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int[] h = new int[n + 2];
    System.arraycopy(heights, 0, h, 1, n);
    Deque<Integer> stack = new ArrayDeque<>();
    int ans = 0;
    for (int i = 0; i < h.length; i++) {
        while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
            int height = h[stack.pop()];
            int width = i - (stack.isEmpty() ? 0 : stack.peek()) - 1;
            ans = Math.max(ans, height * width);
        }
        stack.push(i);
    }
    return ans;
}
```

---

### 94. 二叉树的中序遍历 (简单) — 二叉树

**考察知识点**：二叉树、DFS

**解题思路**：迭代法：显式栈模拟递归。当前节点非空则入栈并走到左子节点；为空则弹出栈顶，记录值，转向右子节点。

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
        while (cur != null) { stack.push(cur); cur = cur.left; }
        cur = stack.pop();
        ans.add(cur.val);
        cur = cur.right;
    }
    return ans;
}
```

---

### 98. 验证二叉搜索树 (中等) — 二叉树

**考察知识点**：二叉树、BST 性质

**解题思路**：递归时传入当前节点的合法值范围 `[min, max]`。左子节点上界为父节点值，右子节点下界为父节点值，递归验证。

```java
public boolean isValidBST(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
}
private boolean validate(TreeNode node, long min, long max) {
    if (node == null) return true;
    if (node.val <= min || node.val >= max) return false;
    return validate(node.left, min, node.val) && validate(node.right, node.val, max);
}
```

---

### 101. 对称二叉树 (简单) — 二叉树

**考察知识点**：二叉树、递归

**解题思路**：递归判断左右子树是否镜像对称：两节点都为空则对称；一个为空则不对称；两者值不等则不对称；否则递归比较"左的左与右的右"和"左的右与右的左"。

```java
public boolean isSymmetric(TreeNode root) {
    return check(root.left, root.right);
}
private boolean check(TreeNode l, TreeNode r) {
    if (l == null && r == null) return true;
    if (l == null || r == null || l.val != r.val) return false;
    return check(l.left, r.right) && check(l.right, r.left);
}
```

---

### 102. 二叉树的层序遍历 (中等) — 二叉树

**考察知识点**：二叉树、BFS

**解题思路**：BFS 使用队列，每次处理一整层。记录当前层节点数 `size`，循环 size 次出队并将子节点入队，将当前层结果加入答案。

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
        int size = q.size();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = q.poll();
            level.add(node.val);
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
        ans.add(level);
    }
    return ans;
}
```

---

### 104. 二叉树的最大深度 (简单) — 二叉树

**考察知识点**：二叉树、DFS

**解题思路**：递归：`maxDepth(root) = 1 + max(maxDepth(root.left), maxDepth(root.right))`，空节点返回 0。

```java
public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}
```

---

### 105. 从前序与中序遍历序列构造二叉树 (中等) — 二叉树

**考察知识点**：二叉树、分治

**解题思路**：前序首元素为根节点，在中序中找到根节点位置，左侧为左子树、右侧为右子树，递归构造。用哈希表加速中序查找。

```java
public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
    return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
}
private TreeNode build(int[] pre, int pl, int pr, int il, int ir, Map<Integer, Integer> map) {
    if (pl > pr) return null;
    TreeNode root = new TreeNode(pre[pl]);
    int mid = map.get(pre[pl]), leftSize = mid - il;
    root.left = build(pre, pl + 1, pl + leftSize, il, mid - 1, map);
    root.right = build(pre, pl + leftSize + 1, pr, mid + 1, ir, map);
    return root;
}
```

---

### 108. 将有序数组转换为二叉搜索树 (简单) — 二叉树

**考察知识点**：二叉树、分治

**解题思路**：取数组中间元素为根，递归以左半部分构造左子树、右半部分构造右子树，保证树高度平衡。

```java
public TreeNode sortedArrayToBST(int[] nums) {
    return build(nums, 0, nums.length - 1);
}
private TreeNode build(int[] nums, int l, int r) {
    if (l > r) return null;
    int mid = l + (r - l) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = build(nums, l, mid - 1);
    root.right = build(nums, mid + 1, r);
    return root;
}
```

---

### 114. 二叉树展开为链表 (中等) — 二叉树

**考察知识点**：二叉树、前序遍历

**解题思路**：寻找当前节点左子树的最右节点，将右子树接到该节点右边，再将左子树移到右边，左指针置空。重复直到没有左子树。

```java
public void flatten(TreeNode root) {
    TreeNode cur = root;
    while (cur != null) {
        if (cur.left != null) {
            TreeNode pre = cur.left;
            while (pre.right != null) pre = pre.right;
            pre.right = cur.right;
            cur.right = cur.left;
            cur.left = null;
        }
        cur = cur.right;
    }
}
```

---

### 118. 杨辉三角 (简单) — 动态规划

**考察知识点**：动态规划

**解题思路**：每行首尾为 1，中间元素等于上一行相邻两元素之和，逐行生成。

```java
public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
        List<Integer> row = new ArrayList<>();
        for (int j = 0; j <= i; j++) {
            if (j == 0 || j == i) row.add(1);
            else row.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
        }
        ans.add(row);
    }
    return ans;
}
```

---

### 121. 买卖股票的最佳时机 (简单) — 贪心算法

**考察知识点**：贪心

**解题思路**：遍历价格，维护历史最低价 `minPrice`。每天计算若今天卖出的利润，更新最大利润。

```java
public int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE, ans = 0;
    for (int p : prices) {
        minPrice = Math.min(minPrice, p);
        ans = Math.max(ans, p - minPrice);
    }
    return ans;
}
```

---

### 124. 二叉树中的最大路径和 (困难) — 二叉树

**考察知识点**：二叉树、后序遍历、DFS

**解题思路**：对每个节点，递归计算左右子树能贡献的最大路径（负值取 0）。以当前节点为路径最高点时，路径和 = `node.val + left + right`，用全局变量记录最大值。函数返回该节点能向上贡献的最大值：`node.val + max(left, right, 0)`。

```java
int maxSum = Integer.MIN_VALUE;
public int maxPathSum(TreeNode root) {
    dfs(root); return maxSum;
}
private int dfs(TreeNode node) {
    if (node == null) return 0;
    int left = Math.max(dfs(node.left), 0);
    int right = Math.max(dfs(node.right), 0);
    maxSum = Math.max(maxSum, node.val + left + right);
    return node.val + Math.max(left, right);
}
```

---

### 128. 最长连续序列 (中等) — 哈希

**考察知识点**：哈希表

**解题思路**：将所有数放入 HashSet。遍历集合，只对序列起点（`n-1` 不在集合中）向右扩展统计长度，更新最大值。

```java
public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) set.add(n);
    int ans = 0;
    for (int n : set) {
        if (!set.contains(n - 1)) {
            int cur = n, len = 1;
            while (set.contains(cur + 1)) { cur++; len++; }
            ans = Math.max(ans, len);
        }
    }
    return ans;
}
```

---

### 131. 分割回文串 (中等) — 回溯

**考察知识点**：回溯、动态规划预处理

**解题思路**：预处理 `dp[i][j]` 表示 `s[i..j]` 是否为回文串。回溯时从当前位置枚举所有回文子串，加入路径后递归处理剩余部分。

```java
public List<List<String>> partition(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    for (int i = n - 1; i >= 0; i--)
        for (int j = i; j < n; j++)
            dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1]);
    List<List<String>> ans = new ArrayList<>();
    backtrack(s, 0, dp, new ArrayList<>(), ans);
    return ans;
}
private void backtrack(String s, int start, boolean[][] dp, List<String> path, List<List<String>> ans) {
    if (start == s.length()) { ans.add(new ArrayList<>(path)); return; }
    for (int end = start; end < s.length(); end++) {
        if (dp[start][end]) {
            path.add(s.substring(start, end + 1));
            backtrack(s, end + 1, dp, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
```

---

### 136. 只出现一次的数字 (简单) — 技巧

**考察知识点**：位运算（异或）

**解题思路**：`a ^ a = 0`，`a ^ 0 = a`。所有数异或后，成对出现的数互相消除，剩下的就是只出现一次的数。

```java
public int singleNumber(int[] nums) {
    int ans = 0;
    for (int n : nums) ans ^= n;
    return ans;
}
```

---

### 138. 随机链表的复制 (中等) — 链表

**考察知识点**：链表、哈希表

**解题思路**：两次遍历。第一次创建所有新节点，存入哈希表（原节点 → 新节点）。第二次根据哈希表设置新节点的 `next` 和 `random` 指针。

```java
public Node copyRandomList(Node head) {
    Map<Node, Node> map = new HashMap<>();
    Node cur = head;
    while (cur != null) { map.put(cur, new Node(cur.val)); cur = cur.next; }
    cur = head;
    while (cur != null) {
        map.get(cur).next = map.get(cur.next);
        map.get(cur).random = map.get(cur.random);
        cur = cur.next;
    }
    return map.get(head);
}
```

---

### 139. 单词拆分 (中等) — 动态规划

**考察知识点**：动态规划

**解题思路**：`dp[i]` 表示 `s[0..i-1]` 能否被拆分。对每个位置 i，枚举分割点 j，若 `dp[j]` 为 true 且 `s[j..i-1]` 在字典中，则 `dp[i] = true`。

```java
public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);
    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (int i = 1; i <= n; i++)
        for (int j = 0; j < i; j++)
            if (dp[j] && set.contains(s.substring(j, i))) { dp[i] = true; break; }
    return dp[n];
}
```

---

### 141. 环形链表 (简单) — 链表

**考察知识点**：链表、快慢指针

**解题思路**：快指针每次走两步，慢指针每次走一步。若存在环，快慢指针必然相遇；快指针到达 null 则无环。

```java
public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next; fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}
```

---

### 142. 环形链表 II (中等) — 链表

**考察知识点**：链表、快慢指针、数学推导

**解题思路**：快慢指针相遇后，将慢指针移回头节点，快慢指针同速前进，再次相遇处即为环的入口（数学证明：设链表头到入口距离 a，则 a 等于相遇点到入口的距离）。

```java
public ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next; fast = fast.next.next;
        if (slow == fast) {
            slow = head;
            while (slow != fast) { slow = slow.next; fast = fast.next; }
            return slow;
        }
    }
    return null;
}
```

---

### 146. LRU 缓存 (中等) — 链表

**考察知识点**：哈希表 + 双向链表、设计

**解题思路**：哈希表实现 O(1) 查找，双向链表维护访问顺序（头部为最近使用）。get 时将节点移到头部；put 时若 key 存在则更新并移到头部，否则新增节点到头部，若超容量删除尾部节点。

```java
class LRUCache {
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(), tail = new Node();
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity; head.next = tail; tail.prev = head;
    }
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key); moveToHead(node); return node.val;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) { Node node = map.get(key); node.val = value; moveToHead(node); }
        else {
            Node node = new Node(key, value); map.put(key, node); addToHead(node);
            if (map.size() > capacity) { Node removed = removeTail(); map.remove(removed.key); }
        }
    }
    private void addToHead(Node node) { node.prev = head; node.next = head.next; head.next.prev = node; head.next = node; }
    private void removeNode(Node node) { node.prev.next = node.next; node.next.prev = node.prev; }
    private void moveToHead(Node node) { removeNode(node); addToHead(node); }
    private Node removeTail() { Node node = tail.prev; removeNode(node); return node; }
    class Node { int key, val; Node prev, next; Node() {} Node(int k, int v) { key = k; val = v; } }
}
```

---

### 148. 排序链表 (中等) — 链表

**考察知识点**：链表、归并排序

**解题思路**：快慢指针找链表中点，将链表分为两半递归排序，再合并两个有序链表。时间 O(n log n)。

```java
public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode slow = head, fast = head.next;
    while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
    ListNode mid = slow.next; slow.next = null;
    return merge(sortList(head), sortList(mid));
}
private ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0), cur = dummy;
    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) { cur.next = l1; l1 = l1.next; }
        else { cur.next = l2; l2 = l2.next; }
        cur = cur.next;
    }
    cur.next = l1 != null ? l1 : l2;
    return dummy.next;
}
```

---

### 152. 乘积最大子数组 (中等) — 动态规划

**考察知识点**：动态规划

**解题思路**：同时维护以当前元素结尾的最大乘积 `maxDp` 和最小乘积 `minDp`（负数×负数可变最大）。每步取三者（当前数、最大乘积×当前数、最小乘积×当前数）的最大/最小值。

```java
public int maxProduct(int[] nums) {
    int ans = nums[0], maxDp = nums[0], minDp = nums[0];
    for (int i = 1; i < nums.length; i++) {
        int tmp = maxDp;
        maxDp = Math.max(nums[i], Math.max(maxDp * nums[i], minDp * nums[i]));
        minDp = Math.min(nums[i], Math.min(tmp * nums[i], minDp * nums[i]));
        ans = Math.max(ans, maxDp);
    }
    return ans;
}
```

---

### 153. 寻找旋转排序数组中的最小值 (中等) — 二分查找

**考察知识点**：二分查找

**解题思路**：比较 `nums[mid]` 与 `nums[r]`。若 `nums[mid] > nums[r]`，最小值在右半部分，`l = mid + 1`；否则最小值在左半部分（含 mid），`r = mid`。

```java
public int findMin(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] > nums[r]) l = mid + 1;
        else r = mid;
    }
    return nums[l];
}
```

---

### 155. 最小栈 (中等) — 栈

**考察知识点**：栈、设计

**解题思路**：辅助栈同步记录每个状态下的最小值。push 时记录 `min(当前值, 辅助栈顶)`，pop 时同步弹出，`getMin()` 直接返回辅助栈顶。

```java
class MinStack {
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();
    public void push(int val) {
        stack.push(val);
        minStack.push(minStack.isEmpty() ? val : Math.min(val, minStack.peek()));
    }
    public void pop() { stack.pop(); minStack.pop(); }
    public int top() { return stack.peek(); }
    public int getMin() { return minStack.peek(); }
}
```

---

### 160. 相交链表 (简单) — 链表

**考察知识点**：链表、双指针

**解题思路**：两指针分别从两个链表头出发，遍历完本链表后转到另一链表头。若有交点，两指针走过相同总路程后必然相遇在交点；若无交点，最终同时到达 null。

```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA, b = headB;
    while (a != b) {
        a = a != null ? a.next : headB;
        b = b != null ? b.next : headA;
    }
    return a;
}
```

---

### 169. 多数元素 (简单) — 技巧

**考察知识点**：摩尔投票算法

**解题思路**：维护候选众数 `candidate` 和票数 `count`。遍历时若 `count==0` 则更新候选数；当前数等于候选数则 `count++`，否则 `count--`。最终候选数即为众数。

```java
public int majorityElement(int[] nums) {
    int candidate = 0, count = 0;
    for (int n : nums) {
        if (count == 0) candidate = n;
        count += n == candidate ? 1 : -1;
    }
    return candidate;
}
```

---

### 189. 轮转数组 (中等) — 普通数组

**考察知识点**：数组、三次翻转

**解题思路**：先整体翻转，再翻转前 k 个，最后翻转剩余部分。`k = k % n` 防止越界。

```java
public void rotate(int[] nums, int k) {
    int n = nums.length; k %= n;
    reverse(nums, 0, n - 1); reverse(nums, 0, k - 1); reverse(nums, k, n - 1);
}
private void reverse(int[] nums, int l, int r) {
    while (l < r) { int t = nums[l]; nums[l++] = nums[r]; nums[r--] = t; }
}
```

---

### 198. 打家劫舍 (中等) — 动态规划

**考察知识点**：动态规划

**解题思路**：`dp[i] = max(dp[i-1], dp[i-2] + nums[i-1])`，即要么不抢当前房，要么抢当前房（不能抢相邻）。滚动变量优化空间。

```java
public int rob(int[] nums) {
    int prev2 = 0, prev1 = 0;
    for (int n : nums) { int cur = Math.max(prev1, prev2 + n); prev2 = prev1; prev1 = cur; }
    return prev1;
}
```

---

### 199. 二叉树的右视图 (中等) — 二叉树

**考察知识点**：二叉树、BFS

**解题思路**：BFS 层序遍历，每层最后一个节点即为右视图节点。

```java
public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) return ans;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = q.poll();
            if (i == size - 1) ans.add(node.val);
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
    }
    return ans;
}
```

---

### 200. 岛屿数量 (中等) — 图论

**考察知识点**：DFS/BFS

**解题思路**：遍历网格，遇到 `'1'` 则 DFS 将连通陆地全部标记为 `'0'`，计数器加一。

```java
public int numIslands(char[][] grid) {
    int ans = 0;
    for (int i = 0; i < grid.length; i++)
        for (int j = 0; j < grid[0].length; j++)
            if (grid[i][j] == '1') { dfs(grid, i, j); ans++; }
    return ans;
}
private void dfs(char[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;
    grid[i][j] = '0';
    dfs(grid, i+1, j); dfs(grid, i-1, j); dfs(grid, i, j+1); dfs(grid, i, j-1);
}
```

---

### 206. 反转链表 (简单) — 链表

**考察知识点**：链表、迭代

**解题思路**：迭代法：维护前驱节点 `prev`，遍历时将当前节点的 `next` 指向 `prev`，然后 `prev` 和 `cur` 同步前进。

```java
public ListNode reverseList(ListNode head) {
    ListNode prev = null, cur = head;
    while (cur != null) {
        ListNode next = cur.next; cur.next = prev; prev = cur; cur = next;
    }
    return prev;
}
```

---

### 207. 课程表 (中等) — 图论

**考察知识点**：拓扑排序、BFS

**解题思路**：建有向图并计算每个节点入度。将入度为 0 的节点加入队列，BFS 每出队一个节点就将其邻居入度减一，入度变 0 则入队。若处理节点数等于课程总数则无环可完成。

```java
public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] inDegree = new int[numCourses];
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
    for (int[] p : prerequisites) { graph.get(p[1]).add(p[0]); inDegree[p[0]]++; }
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) if (inDegree[i] == 0) q.offer(i);
    int count = 0;
    while (!q.isEmpty()) {
        int cur = q.poll(); count++;
        for (int next : graph.get(cur)) if (--inDegree[next] == 0) q.offer(next);
    }
    return count == numCourses;
}
```

---

### 208. 实现 Trie (前缀树) (中等) — 图论

**考察知识点**：字典树（Trie）、设计

**解题思路**：每个节点含 26 个子节点数组和 `isEnd` 标记。插入时按字符逐级创建节点；搜索时按字符逐级遍历，到末尾检查 `isEnd`。

```java
class Trie {
    private Trie[] children = new Trie[26];
    private boolean isEnd = false;
    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) node.children[idx] = new Trie();
            node = node.children[idx];
        }
        node.isEnd = true;
    }
    public boolean search(String word) { Trie node = searchPrefix(word); return node != null && node.isEnd; }
    public boolean startsWith(String prefix) { return searchPrefix(prefix) != null; }
    private Trie searchPrefix(String s) {
        Trie node = this;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) return null;
            node = node.children[idx];
        }
        return node;
    }
}
```

---

### 215. 数组中的第 K 个最大元素 (中等) — 堆

**考察知识点**：堆（优先队列）

**解题思路**：维护大小为 k 的最小堆。遍历数组，若堆满且当前元素大于堆顶则替换堆顶，最终堆顶即为第 k 大元素。

```java
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int n : nums) { pq.offer(n); if (pq.size() > k) pq.poll(); }
    return pq.peek();
}
```

---

### 226. 翻转二叉树 (简单) — 二叉树

**考察知识点**：二叉树、递归

**解题思路**：递归地交换每个节点的左右子树。

```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode tmp = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(tmp);
    return root;
}
```

---

### 230. 二叉搜索树中第 K 小的元素 (中等) — 二叉树

**考察知识点**：二叉树、中序遍历（BST 性质）

**解题思路**：BST 中序遍历结果为升序序列，第 k 个即为第 k 小元素。迭代中序遍历，计数到 k 时返回。

```java
public int kthSmallest(TreeNode root, int k) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    int count = 0;
    while (cur != null || !stack.isEmpty()) {
        while (cur != null) { stack.push(cur); cur = cur.left; }
        cur = stack.pop();
        if (++count == k) return cur.val;
        cur = cur.right;
    }
    return -1;
}
```

---

### 234. 回文链表 (简单) — 链表

**考察知识点**：链表、快慢指针、翻转

**解题思路**：快慢指针找到中点，将后半段链表翻转，然后与前半段逐节点比较。

```java
public boolean isPalindrome(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
    ListNode rev = reverse(slow);
    ListNode p = head, q = rev;
    while (q != null) { if (p.val != q.val) return false; p = p.next; q = q.next; }
    return true;
}
private ListNode reverse(ListNode head) {
    ListNode prev = null, cur = head;
    while (cur != null) { ListNode next = cur.next; cur.next = prev; prev = cur; cur = next; }
    return prev;
}
```

---

### 236. 二叉树的最近公共祖先 (中等) — 二叉树

**考察知识点**：二叉树、后序遍历、DFS

**解题思路**：若当前节点为 null 或等于 p/q 则返回自身。递归左右子树，若左右都非空则当前节点即为 LCA；否则返回非空的那个。

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) return root;
    return left != null ? left : right;
}
```

---

### 238. 除自身以外数组的乘积 (中等) — 普通数组

**考察知识点**：前缀积、后缀积

**解题思路**：先求每个位置左侧所有元素的乘积存入结果数组，再从右向左用变量维护右侧乘积并乘入结果数组。

```java
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    ans[0] = 1;
    for (int i = 1; i < n; i++) ans[i] = ans[i - 1] * nums[i - 1];
    int right = 1;
    for (int i = n - 1; i >= 0; i--) { ans[i] *= right; right *= nums[i]; }
    return ans;
}
```

---

### 239. 滑动窗口最大值 (困难) — 子串

**考察知识点**：单调队列（双端队列）

**解题思路**：维护单调递减的双端队列（存下标）。新元素入队前从队尾移除所有比它小的元素；若队头元素超出窗口范围则从队头移除。队头始终是当前窗口最大值的下标。

```java
public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int[] ans = new int[n - k + 1];
    Deque<Integer> dq = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
        while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();
        dq.offerLast(i);
        if (dq.peekFirst() < i - k + 1) dq.pollFirst();
        if (i >= k - 1) ans[i - k + 1] = nums[dq.peekFirst()];
    }
    return ans;
}
```

---

### 240. 搜索二维矩阵 II (中等) — 矩阵

**考察知识点**：矩阵、双指针

**解题思路**：从矩阵右上角开始，当前值大于 target 则左移（排除当前列），小于 target 则下移（排除当前行），等于则返回 true。

```java
public boolean searchMatrix(int[][] matrix, int target) {
    int i = 0, j = matrix[0].length - 1;
    while (i < matrix.length && j >= 0) {
        if (matrix[i][j] == target) return true;
        else if (matrix[i][j] > target) j--;
        else i++;
    }
    return false;
}
```

---

### 279. 完全平方数 (中等) — 动态规划

**考察知识点**：动态规划（完全背包）

**解题思路**：`dp[i]` 表示组成 i 所需最少完全平方数个数。对每个 i，枚举所有完全平方数 j²（j² ≤ i），`dp[i] = min(dp[i], dp[i - j*j] + 1)`。

```java
public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= n; i++)
        for (int j = 1; j * j <= i; j++)
            dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
    return dp[n];
}
```

---

### 283. 移动零 (简单) — 双指针

**考察知识点**：双指针

**解题思路**：慢指针 `slow` 指向下一个非零元素应填入的位置，快指针遍历数组，遇到非零元素就与 `slow` 位置交换，`slow` 前进。

```java
public void moveZeroes(int[] nums) {
    int slow = 0;
    for (int fast = 0; fast < nums.length; fast++) {
        if (nums[fast] != 0) {
            int tmp = nums[slow]; nums[slow++] = nums[fast]; nums[fast] = tmp;
        }
    }
}
```

---

### 287. 寻找重复数 (中等) — 技巧

**考察知识点**：快慢指针（Floyd 判环）

**解题思路**：将数组看作链表（下标为节点，值为下一节点），重复数对应环的入口。快慢指针找到相遇点后，慢指针移回 0，快慢同速再次相遇处即为重复数。

```java
public int findDuplicate(int[] nums) {
    int slow = 0, fast = 0;
    do { slow = nums[slow]; fast = nums[nums[fast]]; } while (slow != fast);
    slow = 0;
    while (slow != fast) { slow = nums[slow]; fast = nums[fast]; }
    return slow;
}
```

---

### 295. 数据流的中位数 (困难) — 堆

**考察知识点**：堆、设计

**解题思路**：大根堆 `lo` 存较小一半，小根堆 `hi` 存较大一半，保持 `lo.size() == hi.size()` 或 `lo.size() == hi.size() + 1`。添加时先入 `lo`，将 `lo` 堆顶移入 `hi`，若 `hi` 更大则将 `hi` 堆顶移回 `lo`。

```java
class MedianFinder {
    PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> hi = new PriorityQueue<>();
    public void addNum(int num) {
        lo.offer(num); hi.offer(lo.poll());
        if (hi.size() > lo.size()) lo.offer(hi.poll());
    }
    public double findMedian() {
        return lo.size() > hi.size() ? lo.peek() : (lo.peek() + hi.peek()) / 2.0;
    }
}
```

---

### 300. 最长递增子序列 (中等) — 动态规划

**考察知识点**：动态规划 / 贪心 + 二分查找

**解题思路**：贪心+二分：维护数组 `tails`，`tails[i]` 为长度 i+1 的递增子序列末尾最小值。遍历每个数，二分查找其在 tails 中的插入位置并更新，`tails` 的长度即为答案。

```java
public int lengthOfLIS(int[] nums) {
    List<Integer> tails = new ArrayList<>();
    for (int n : nums) {
        int l = 0, r = tails.size();
        while (l < r) { int mid = l + (r - l) / 2; if (tails.get(mid) < n) l = mid + 1; else r = mid; }
        if (l == tails.size()) tails.add(n);
        else tails.set(l, n);
    }
    return tails.size();
}
```

---

### 322. 零钱兑换 (中等) — 动态规划

**考察知识点**：动态规划（完全背包）

**解题思路**：`dp[i]` 表示凑出金额 i 所需最少硬币数。对每个金额 i，枚举所有面额 c，`dp[i] = min(dp[i], dp[i-c] + 1)`。

```java
public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++)
        for (int c : coins)
            if (c <= i) dp[i] = Math.min(dp[i], dp[i - c] + 1);
    return dp[amount] > amount ? -1 : dp[amount];
}
```

---

### 347. 前 K 个高频元素 (中等) — 堆

**考察知识点**：堆、哈希表

**解题思路**：统计每个元素频次后，用大小为 k 的最小堆（按频次）维护前 k 个高频元素。遍历频次哈希表，超过 k 个时弹出堆顶（频次最小的），最终堆中即为答案。

```java
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
    for (int key : freq.keySet()) { pq.offer(key); if (pq.size() > k) pq.poll(); }
    int[] ans = new int[k];
    for (int i = k - 1; i >= 0; i--) ans[i] = pq.poll();
    return ans;
}
```

---

### 394. 字符串解码 (中等) — 栈

**考察知识点**：栈、字符串

**解题思路**：两个栈，一个存数字，一个存字符串。遇数字累加；遇 `[` 将当前字符串和数字压栈，重置；遇 `]` 弹出数字和字符串，将当前字符串重复后拼接到弹出的字符串；遇字母直接追加。

```java
public String decodeString(String s) {
    Deque<Integer> numStack = new ArrayDeque<>();
    Deque<StringBuilder> strStack = new ArrayDeque<>();
    StringBuilder cur = new StringBuilder();
    int num = 0;
    for (char c : s.toCharArray()) {
        if (Character.isDigit(c)) num = num * 10 + (c - '0');
        else if (c == '[') { numStack.push(num); strStack.push(cur); cur = new StringBuilder(); num = 0; }
        else if (c == ']') {
            int k = numStack.pop(); StringBuilder prev = strStack.pop();
            for (int i = 0; i < k; i++) prev.append(cur);
            cur = prev;
        } else cur.append(c);
    }
    return cur.toString();
}
```

---

### 416. 分割等和子集 (中等) — 动态规划

**考察知识点**：动态规划（0/1 背包）

**解题思路**：问题等价于从数组中选若干数使其和为 `sum/2`。`dp[j]` 表示能否凑出容量 j，逆序更新 `dp[j] = dp[j] || dp[j - nums[i]]`。

```java
public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int n : nums) sum += n;
    if (sum % 2 != 0) return false;
    int target = sum / 2;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;
    for (int n : nums)
        for (int j = target; j >= n; j--)
            dp[j] = dp[j] || dp[j - n];
    return dp[target];
}
```

---

### 437. 路径总和 III (中等) — 二叉树

**考察知识点**：二叉树、前缀和、DFS

**解题思路**：DFS + 前缀和哈希表。维护从根到当前节点的路径和 `curSum`，查找哈希表中 `curSum - targetSum` 出现的次数并累加到结果，然后将 `curSum` 存入哈希表，递归子节点，回溯时移除。

```java
public int pathSum(TreeNode root, int targetSum) {
    Map<Long, Integer> map = new HashMap<>();
    map.put(0L, 1);
    return dfs(root, 0, targetSum, map);
}
private int dfs(TreeNode node, long curSum, int target, Map<Long, Integer> map) {
    if (node == null) return 0;
    curSum += node.val;
    int ans = map.getOrDefault(curSum - target, 0);
    map.put(curSum, map.getOrDefault(curSum, 0) + 1);
    ans += dfs(node.left, curSum, target, map) + dfs(node.right, curSum, target, map);
    map.put(curSum, map.get(curSum) - 1);
    return ans;
}
```

---

### 438. 找到字符串中所有字母异位词 (中等) — 滑动窗口

**考察知识点**：滑动窗口、字符频次

**解题思路**：固定长度为 `p.length()` 的滑动窗口，维护窗口内字符频次数组。每次窗口滑动时更新频次，若与目标频次数组相等则记录起始位置。

```java
public List<Integer> findAnagrams(String s, String p) {
    List<Integer> ans = new ArrayList<>();
    if (s.length() < p.length()) return ans;
    int[] pc = new int[26], wc = new int[26];
    for (char c : p.toCharArray()) pc[c - 'a']++;
    int k = p.length();
    for (int i = 0; i < s.length(); i++) {
        wc[s.charAt(i) - 'a']++;
        if (i >= k) wc[s.charAt(i - k) - 'a']--;
        if (Arrays.equals(pc, wc)) ans.add(i - k + 1);
    }
    return ans;
}
```

---

### 543. 二叉树的直径 (简单) — 二叉树

**考察知识点**：二叉树、DFS

**解题思路**：树的直径经过某节点时等于该节点左子树深度 + 右子树深度。后序遍历每个节点，用全局变量记录 `left + right` 的最大值，函数返回 `1 + max(left, right)`。

```java
int maxDiameter = 0;
public int diameterOfBinaryTree(TreeNode root) {
    depth(root); return maxDiameter;
}
private int depth(TreeNode node) {
    if (node == null) return 0;
    int left = depth(node.left), right = depth(node.right);
    maxDiameter = Math.max(maxDiameter, left + right);
    return 1 + Math.max(left, right);
}
```

---

### 560. 和为 K 的子数组 (中等) — 子串

**考察知识点**：前缀和、哈希表

**解题思路**：维护当前前缀和 `sum`，查找哈希表中 `sum - k` 出现的次数（即有多少前缀使得区间和为 k），累加到答案，然后将 `sum` 存入哈希表。

```java
public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int sum = 0, ans = 0;
    for (int n : nums) {
        sum += n;
        ans += map.getOrDefault(sum - k, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return ans;
}
```

---

### 739. 每日温度 (中等) — 栈

**考察知识点**：单调栈

**解题思路**：维护单调递减栈（存下标）。遍历温度，若当前温度大于栈顶对应温度，则弹出栈顶，计算天数差存入结果，直到栈为空或栈顶温度更大，然后将当前下标入栈。

```java
public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] ans = new int[n];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
            int j = stack.pop(); ans[j] = i - j;
        }
        stack.push(i);
    }
    return ans;
}
```

---

### 763. 划分字母区间 (中等) — 贪心算法

**考察知识点**：贪心、哈希表

**解题思路**：先记录每个字符最后出现的位置。贪心遍历，维护当前分区右边界（已遇字符最远出现位置），遍历到右边界时分区结束，记录分区长度，更新起点。

```java
public List<Integer> partitionLabels(String s) {
    int[] last = new int[26];
    for (int i = 0; i < s.length(); i++) last[s.charAt(i) - 'a'] = i;
    List<Integer> ans = new ArrayList<>();
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        end = Math.max(end, last[s.charAt(i) - 'a']);
        if (i == end) { ans.add(end - start + 1); start = end + 1; }
    }
    return ans;
}
```

---

### 994. 腐烂的橘子 (中等) — 图论

**考察知识点**：多源 BFS

**解题思路**：将所有腐烂橘子同时加入队列作为初始源，BFS 按层扩散（每层代表一分钟），将新鲜橘子变为腐烂。最终若还有新鲜橘子则返回 -1，否则返回扩散层数。

```java
public int orangesRotting(int[][] grid) {
    int m = grid.length, n = grid[0].length, fresh = 0, minutes = 0;
    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 2) q.offer(new int[]{i, j});
            else if (grid[i][j] == 1) fresh++;
        }
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    while (!q.isEmpty() && fresh > 0) {
        minutes++;
        for (int size = q.size(); size > 0; size--) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int r = cur[0] + d[0], c = cur[1] + d[1];
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                    grid[r][c] = 2; fresh--; q.offer(new int[]{r, c});
                }
            }
        }
    }
    return fresh == 0 ? minutes : -1;
}
```

---

### 1143. 最长公共子序列 (中等) — 多维动态规划

**考察知识点**：动态规划

**解题思路**：`dp[i][j]` 表示 `text1[0..i-1]` 和 `text2[0..j-1]` 的最长公共子序列长度。末字符相同则 `dp[i][j] = dp[i-1][j-1] + 1`；否则 `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`。

```java
public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length(), n = text2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++)
        for (int j = 1; j <= n; j++) {
            if (text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
            else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
    return dp[m][n];
}
```

---

> 共 100 题，按题号从小到大排列。

---

## 附加题

### 矩形相交 — 几何计算

**题目描述**：

在 iOS/macOS 等系统中，屏幕由层层嵌套的视图组成。每个视图有一个 `frame` 属性，类型为 `Rect`：

```
// 原点在矩形左下角，边与坐标轴平行，使用笛卡尔坐标系
struct Rect {
    var x: Double      // 原点 x 坐标
    var y: Double      // 原点 y 坐标
    var width: Double
    var height: Double
}
```

需要实现两个函数：
1. `hasIntersection(frame1, frame2)` — 判断两个矩形是否相交
2. `calculateIntersectionAreaSize(frames)` — 计算多个矩形公共交集的面积

**考察知识点**：几何、矩形相交判断、区间重叠

**解题思路**：

**hasIntersection**：利用分离轴定理，两矩形不相交的充要条件是满足以下任意一条：
- frame1 在 frame2 右侧：`frame1.x >= frame2.x + frame2.width`
- frame1 在 frame2 左侧：`frame1.x + frame1.width <= frame2.x`
- frame1 在 frame2 上方：`frame1.y >= frame2.y + frame2.height`
- frame1 在 frame2 下方：`frame1.y + frame1.height <= frame2.y`

取反即为相交条件。

**calculateIntersectionAreaSize**：逐步求交，先求前两个矩形的交集矩形，再用交集矩形与下一个矩形求交，以此类推。两矩形交集的计算方式：
```
交集左边界 = max(x1, x2)
交集右边界 = min(x1+w1, x2+w2)
交集下边界 = max(y1, y2)
交集上边界 = min(y1+h1, y2+h2)
若右边界 <= 左边界 或 上边界 <= 下边界，则无交集
```

```java
public class RectIntersection {

    static class Rect {
        double x, y, width, height;
        Rect(double x, double y, double width, double height) {
            this.x = x; this.y = y; this.width = width; this.height = height;
        }
    }

    // 判断两个矩形是否相交，O(1)
    public static boolean hasIntersection(Rect frame1, Rect frame2) {
        if (frame1.x >= frame2.x + frame2.width)  return false; // frame1 在右
        if (frame1.x + frame1.width <= frame2.x)  return false; // frame1 在左
        if (frame1.y >= frame2.y + frame2.height) return false; // frame1 在上
        if (frame1.y + frame1.height <= frame2.y) return false; // frame1 在下
        return true;
    }

    // 求两矩形的交集矩形，无交集返回 null
    private static Rect intersect(Rect r1, Rect r2) {
        double x    = Math.max(r1.x, r2.x);
        double y    = Math.max(r1.y, r2.y);
        double maxX = Math.min(r1.x + r1.width,  r2.x + r2.width);
        double maxY = Math.min(r1.y + r1.height, r2.y + r2.height);
        if (maxX <= x || maxY <= y) return null;
        return new Rect(x, y, maxX - x, maxY - y);
    }

    // 计算多个矩形公共交集的面积，O(n)
    public static double calculateIntersectionAreaSize(Rect[] frames) {
        if (frames == null || frames.length == 0) return 0;
        Rect current = frames[0];
        for (int i = 1; i < frames.length; i++) {
            current = intersect(current, frames[i]);
            if (current == null) return 0;
        }
        return current.width * current.height;
    }
}
```

**复杂度**：`hasIntersection` O(1)；`calculateIntersectionAreaSize` 时间 O(n)、空间 O(1)。
