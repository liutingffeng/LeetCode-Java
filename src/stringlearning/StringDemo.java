package stringlearning;

import org.junit.Test;

public class StringDemo {

    @Test
    public void test1(){
        String s1 = "abc";
        String s2 = "abc";

        System.out.println(s1 == s2);  //true
        s2 = "edf";
        System.out.println(s1);  // abc
        System.out.println(s2);  // edf
    }

    @Test
    public void test2(){
        String s1 = "abc";
        String s2 = "abc";
        s2 += "edf";

        System.out.println(s1);  // abc
        System.out.println(s2);  // abcedf
    }

    @Test
    public void test3(){
        String s1 = "abc";
        String s2 = s1.replace('a', 'm');

        System.out.println(s1);  // abc
        System.out.println(s2);  // mbc
    }
}
