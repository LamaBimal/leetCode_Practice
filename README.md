# 🧩 LeetCode Patterns & Practice Questions

> Master these 15 problem-solving patterns to crack 90% of LeetCode questions.  
> Recognize the pattern → apply the right template → solve efficiently.  
> Solutions are implemented in **Java**, organized by pattern.

---

## 📚 Table of Contents
1. [Prefix Sum](#1-prefix-sum)
2. [Two Pointers](#2-two-pointers)
3. [Sliding Window](#3-sliding-window)
4. [Fast & Slow Pointers](#4-fast--slow-pointers)
5. [Linked List In-Place Reversal](#5-linked-list-in-place-reversal)
6. [Monotonic Stack](#6-monotonic-stack)
7. [Top K Elements](#7-top-k-elements)
8. [Overlapping Intervals](#8-overlapping-intervals)
9. [Modified Binary Search](#9-modified-binary-search)
10. [Binary Tree Traversal](#10-binary-tree-traversal)
11. [Depth-First Search (DFS)](#11-depth-first-search-dfs)
12. [Breadth-First Search (BFS)](#12-breadth-first-search-bfs)
13. [Matrix Traversal](#13-matrix-traversal)
14. [Backtracking](#14-backtracking)
15. [Dynamic Programming (DP)](#15-dynamic-programming-dp)
16. [✅ Final Tips](#✅-final-tips)

---

## 1. Prefix Sum
**When to use:**  
- Range sum / difference array problems  
- Frequent subarray sum queries  

**Template:**
```java
int[] prefix = new int[n+1];
for (int i = 0; i < n; i++) prefix[i+1] = prefix[i] + nums[i];
// Sum from l to r: prefix[r+1] - prefix[l]
```

---

## 2. Two Pointers
**When to use:**  
- Sorted arrays / strings  
- Pair / triplet sum problems  

**Template:**
```java
int left = 0, right = nums.length-1;
while (left < right) {
    int sum = nums[left] + nums[right];
    if (sum == target) break;
    else if (sum < target) left++;
    else right--;
}

```

## 3. Sliding Window
**When to Use:**
- Contiguous subarrays/substrings
- Maximum/ minimum sum/ length

**Template:**
```java
int left = 0, windowSum = 0;
for (int right = 0; right < nums.length; right++) {
    windowSum += nums[right];
    while (windowSum > k) {
        windowSum -= nums[left++];
    }
    // update answer
}

```
## 4. Fast  Slow Pointers
**When to Use:**
- Cycle detection in linked lists
- Middle element detection

**Template:**
```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow == fast) break;
}
```

## 5. Linked list in place reversal
**When to Use:**
-

**Template**
```java
ListNode prev = null, curr = head;
while (curr != null) {
    ListNode next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
}
return prev;

```

## 6. Monotonic Stack
**When to use:**
- Next greater/smaller element
- Histogram / temperature problems

**Template**
```java
Stack<Integer> stack = new Stack<>();
int[] res = new int[nums.length];
for (int i = 0; i < nums.length; i++) {
    while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
        res[stack.pop()] = nums[i];
    stack.push(i);
}

```

## 7. Top K Elements
**When to use:**

**Template**
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
for (int num : nums) {
    pq.offer(num);
    if (pq.size() > k) pq.poll();
}
return pq.peek();

```

## 8. Overalapping intervals
**When to use**

**Template**
```java
Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
List<int[]> merged = new ArrayList<>();
merged.add(intervals[0]);
for (int i = 1; i < intervals.length; i++) {
    int[] last = merged.get(merged.size()-1);
    if (intervals[i][0] <= last[1])
        last[1] = Math.max(last[1], intervals[i][1]);
    else merged.add(intervals[i]);
}

```

## 9. Modified Binary Search
**When to use**

**Template**
```java
int left = 0, right = nums.length-1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (condition(mid)) left = mid + 1;
    else right = mid - 1;
}

```

## 10. Binary Tree Traversal
**when to use**


**Template**
```java
void inorder(TreeNode root){
    if(root == null) return;
    inorder(root.left);
    process(root);
    inorder(root.right);
}

```
## 11. Depth First Search (DFS)

**when to use**


**Template**
```java
void dfs(int node, Set<Integer> visited, Map<Integer, List<Integer>> graph){
    if(visited.contains(node)) return;
    visited.add(node);
    for(int nei : graph.get(node)) dfs(nei, visited, graph);
}

```

## 12. Breadth First Search (BFS)
**when to use**


**Template**
```java
Queue<Integer> queue = new LinkedList<>();
Set<Integer> visited = new HashSet<>();
queue.offer(start);
visited.add(start);
while(!queue.isEmpty()){
    int node = queue.poll();
    for(int nei : graph.get(node)){
        if(!visited.contains(nei)){
            visited.add(nei);
            queue.offer(nei);
        }
    }
}

```

## 13. Matrix Traversal
**when to use**

**Template**
```java
int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
void dfs(int r, int c){
    if(r<0 || c<0 || r>=rows || c>=cols || grid[r][c]=='0') return;
    grid[r][c] = '0';
    for(int[] d : directions) dfs(r+d[0], c+d[1]);
}

```

## 14. BackTracking
**When to use**


**Template**
```java
void backtrack(List<Integer> path, int start, int[] nums, List<List<Integer>> res){
    res.add(new ArrayList<>(path));
    for(int i=start;i<nums.length;i++){
        path.add(nums[i]);
        backtrack(path,i+1,nums,res);
        path.remove(path.size()-1);
    }
}

```
## 15. Dynamic Programming (DP)
**When to use**


**Template**
```java
int[] dp = new int[n+1];
dp[0] = 0; dp[1] = 1;
for(int i=2; i<=n; i++) dp[i] = dp[i-1] + dp[i-2];

```

✅ Final Tips

Identify the pattern before coding.
Apply template first, then customize.
Track time & space complexity.
Combine patterns for hybrid problems.


| Question | Problem                                                       | Pattern                                        | Notes                                                                              |
| -------- | ------------------------------------------------------------- | ---------------------------------------------- | ---------------------------------------------------------------------------------- |
| 1        | 132 Pattern (`[1,2,3,4]` → false, `[3,1,4,2]` → true)         | **Monotonic Stack**                            | We use a stack to maintain potential "2" elements in the 132 pattern.              |
| 2        | Longest Substring Without Repeating Characters (`"abcabcbb"`) | **Sliding Window**                             | Use a dynamic window to track the current substring without duplicates.            |
| 3        | Add Two Numbers (Linked List)                                 | **Linked List In-Place Reversal / Simulation** | Traverse the lists node by node and sum digits. Pattern: Linked List manipulation. |
| 4        | Median of Two Sorted Arrays                                   | **Modified Binary Search**                     | Classic O(log(m+n)) solution uses a binary search approach on partitions.          |
| 5        | Longest Palindromic Substring                                 | **Dynamic Programming / Sliding Window**       | Can be solved using DP table or expanding around center (sliding window variant).  |


### Question 1.

Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
Return true if there is a 132 pattern in nums, otherwise, return false. 

```
Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

```
### Question 2.
Given a string s, find the longest substring without repeating characters.
```
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```
### Question3
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
```
Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
```
### Question 4. Median of two sorted arrays
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n))

```
Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

```
### Question 5: Longest Palindrome Substring
Given a string s, return the longest
palindromic substring in s.
```
Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.
```
