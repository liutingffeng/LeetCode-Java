package LC200;

class Reader4 {
    int read4(char[] buf4) {
        return 0;
    }
}

/**
 * 给你一个文件，并且该文件只能通过给定的 read4 方法来读取，请实现一个方法使其能够读取 n 个字符。
 *
 * read4 方法：
 *
 * API read4 可以从文件中读取 4 个连续的字符，并且将它们写入缓存数组 buf 中。
 *
 * 返回值为实际读取的字符个数。
 *
 * 注意 read4() 自身拥有文件指针，很类似于 C 语言中的 FILE *fp 。
 *
 * read4 的定义：
 *
 * 参数类型: char[] buf4
 * 返回类型: int
 *
 * 注意: buf4[] 是目标缓存区不是源缓存区，read4 的返回结果将会复制到 buf4[] 当中。
 * 下列是一些使用 read4 的例子：
 *
 *
 *
 * File file("abcde"); // 文件名为 "abcde"， 初始文件指针 (fp) 指向 'a'
 * char[] buf4 = new char[4]; // 创建一个缓存区使其能容纳足够的字符
 * read4(buf4); // read4 返回 4。现在 buf4 = "abcd"，fp 指向 'e'
 * read4(buf4); // read4 返回 1。现在 buf4 = "e"，fp 指向文件末尾
 * read4(buf4); // read4 返回 0。现在 buf = ""，fp 指向文件末尾
 * read 方法：
 *
 * 通过使用 read4 方法，实现 read 方法。该方法可以从文件中读取 n 个字符并将其存储到缓存数组 buf 中。您 不能 直接操作文件。
 *
 * 返回值为实际读取的字符。
 *
 * read 的定义：
 *
 * 参数类型:   char[] buf, int n
 * 返回类型:   int
 *
 * 注意: buf[] 是目标缓存区不是源缓存区，你需要将结果写入 buf[] 中。
 */
public class LC157 extends Reader4 {

    public int read(char[] buf, int n) {
        if (n == 0)
            return n;

        char[] temp = new char[4];
        int res = 0;
        int cur = 0;
        while (n > 0) {
            res = read4(temp);
            res = Math.min(res, n);
            for (int i = cur; i < cur + res; i++) {
                buf[i] = temp[i - cur];
            }
            cur +=res;
            if (res < 4) {
                return cur;
            }
            n = n - res;
        }
        return cur;
    }
}
