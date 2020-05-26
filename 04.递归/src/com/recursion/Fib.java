package com.recursion;

public class Fib {
    public static void main(String[] args) {
        Fib fib = new Fib();
        int n = 30;
        Times.test("fib0", () -> {
            System.out.println(fib.fib0(n));
        });
        Times.test("fib1", () -> {
            System.out.println(fib.fib1(n));
        });
        Times.test("fib2", () -> {
            System.out.println(fib.fib2(n));
        });
        Times.test("fib3", () -> {
            System.out.println(fib.fib3(n));
        });
        Times.test("fib4", () -> {
            System.out.println(fib.fib4(n));
        });

    }

    int fib0(int n) {
        if (n <= 2)
            return 1;
        return fib0(n - 1) + fib0(n - 2);
    }

    // 使用记忆数组对计算过的值直接获取
    int fib1(int n) {
        if (n <= 2)
            return 1;
        int[] visited = new int[n + 1];
        // 切记需要对记忆数组,对应的递归集进行初始化
        visited[1] = visited[2] = 1;
        return fib1(n, visited);
    }

    int fib1(int n, int[] visited) {
        if (visited[n] == 0) {
            visited[n] = fib1(n - 1, visited) + fib1(n - 2, visited);
        }
        return visited[n];
    }

    // 递归转为非递归(但并不是所有的递归都可以转为非递归)
    int fib2(int n) {
        if (n <= 2)
            return 1;
        int[] visited = new int[n + 1];
        visited[1] = visited[2] = 1;
        for (int i = 3; i <= n; i++)
            visited[i] = visited[i - 1] + visited[2];
        return visited[n];
    }

    // fib2 array的大部分空间只是临时使用,真正对我们有用的其实是最后一个元素,针对此进行优化
    int fib3(int n) {
        if (n <= 2)
            return 1;
        int[] visited = new int[2];
        visited[0] = visited[1] = 1;
        for (int i = 3; i <= n; i++)
            visited[i % 2] = visited[(i - 1) % 2] + visited[(i - 2) % 2];
        return visited[n % 2];
    }

    // fib3 中针对数组进行了优化,当然还有下面的写法
    int fib4(int n) {
        if (n <= 2)
            return 1;
        int first = 1, second = 1, sum;
        for (int i = 3; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    // 使用动态规划求解
    int fib5(int n) {
        if (n <= 2)
            return 1;
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) 
            dp[i] = dp[i - 1] + dp[i - 2];
        
        return dp[n];
    }

}