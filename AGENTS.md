# AGENTS.md

This file provides guidance to Codex (Codex.ai/code) when working with code in this repository.

## Project Overview

LeetCode solutions and CS learning code in Java. This is an IntelliJ IDEA native project — no Maven or Gradle. Dependencies (TestNG 7.1.0, JUnit 4.13.1) are declared in `LeetCode-Java.iml`. The `src/` directory is the source root (no `src/main/java` layout).

## Build & Run

- **IDE**: Open `LeetCode-Java.iml` in IntelliJ IDEA. Build and run from the IDE.
- **No CLI build system**: There is no `pom.xml`, `build.gradle`, or Makefile. Use IntelliJ's build (Ctrl+F9) and run configurations.
- **Test**: Most solutions have a `main()` method with hardcoded test cases — run individual files directly from IntelliJ. A few files use JUnit 4 `@Test` annotations.

## Architecture

### Solution Directory Organization

Solutions are organized by time period/package, each as a separate Java package under `src/`:

| Package | Content |
|---------|---------|
| `LCSolution/` (225 files) | Primary LeetCode solutions, older pattern |
| `LC200/` | Problems 150–259 range |
| `LC2022/`, `LC2023/` | Year-based batches |
| `LC2025/`, `LC2026/` | Recent solutions (most active) |
| `LCJZSolution/` | 剑指 Offer (Sword Refers to Offer) problems |
| `algorim/` | Sorting algorithm implementations |
| `helloAlgo/` | Hello Algo book exercises (trees, graphs) |
| `sync/`, `JVMLearning/`, `gc/`, etc. | CS concept learning code (not LeetCode) |

### Two Solution Patterns

**Older pattern** (`LCSolution/`, `LCJZSolution/`): Inner `Solution` class wrapper
```java
package LCSolution;
public class LC001 {
    class Solution {
        public int[] twoSum(int[] nums, int target) { ... }
    }
}
```

**Newer/preferred pattern** (`LC2025/`, `LC2026/`): Methods directly on the class
```java
package LC2026;
public class LC053 {
    public int maxSubArray(int[] nums) { ... }
}
```

### Naming Convention

- Class names: `LC{number}` matching the LeetCode problem number, zero-padded to 3 digits (e.g., `LC001`, `LC053`). Some newer files use 4 digits for 4-digit problems (e.g., `LC0452`).
- Package names match directory names exactly (e.g., `package LC2026;`).
- 剑指 Offer solutions: `LCJz{number}` in `LCJZSolution/`.

### Shared Data Structures

No shared utility package — each directory is self-contained:
- `TreeNode` is defined separately in `LC200/`, `LC2025/`, and inline in `LC2026/` files that need it.
- `ListNode` is defined in `LC2025/` and `helloAlgo/utils/`.
- `LC2026/` has reusable utilities: `LCGraph.java`, `LCUnionFind.java`, `LCQuickSort.java`, `LCLRU.java`, etc.

## Code Style

- Comments are a mix of Chinese and English; Chinese is used for algorithm explanations and constraints.
- No linter or formatter configuration — code style is informal.
- Commit messages are in Chinese, typically `feat：练习{description}`.
