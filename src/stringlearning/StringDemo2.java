package stringlearning;

import org.junit.Test;

public class StringDemo2 {

    @Test
    public void test1(){
        String s1 = "a"+"b"+"c";
        String s2 = "abc";

        System.out.println(s1 == s2);  //true
        System.out.println(s1.equals(s2));  // true
    }

    @Test
    public void test2(){
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE"+"hadoop";
        String s5 = s1 + "hadoop";  // 只要拼接有变量，那就是在堆中生成，相当于new String()
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);  // true
        System.out.println(s3 == s5);  // false
        System.out.println(s3 == s6);  // false
        System.out.println(s3 == s7);  // false
        System.out.println(s5 == s6);  // false
        System.out.println(s5 == s7);  // false
        System.out.println(s7 == s6);  // false

        String s8 = s6.intern();
        System.out.println(s3 == s8);  // true
    }


    @Test
    public void test3(){
        String s1 = "a";
        String s2 = "b";
        String s3 = "a" + "b";
        /*
        执行细节
        StringBuilder s = new StringBuilder();
        s.append(s1);
        s.append(s2);
        String s4 = s.toString();
         */
        String s4 = s1 + s2;

        System.out.println(s3 == s4); // false
    }

    @Test
    public void test4(){
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "a" + "b";
        String s4 = s1 + s2;

        System.out.println(s3 == s4); // true
    }
}
