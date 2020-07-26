package LCSolution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LC224 {
    /*
    利用栈来去括号（一个数字栈，一个操作符号栈），同时利用状态机转换思想避免if else设计麻烦
    1，无括号时候，就是数字栈只要有两个了，就和操作符计算，结果push到数字栈，再按顺序入栈反复循环
    2，存在括号的时候，使用一个变量compute_flag来记录是否可以计算，遇到±，flag=1；遇到 （ 不可以计算，falg=0，此时，数字栈与操作符号栈继续push，直到遇到）才可以计算。
    3，这里注意一开始虽然未遇到（，但是由于只有一个数字和操作符号，flag也为0，就是初始化
    4,注意一个点语言特性，定义compute函数，传进来两个栈，这里要用&xxx，因为直接传进来栈要拷贝，太大
    5，字符串处理思路，这里采用工厂的思想，用状态机转移的形式。
    */
    class Solution {

        //"(1+(4+5+2)-3)+(6+8)"
//        public int calculate(String s) {
//            final int STATE_BEGIN = 0;
//            final int NUMBER_STATE = 1;
//            final int OPERATION_STATE = 2;//分别定义开始状态，数字状态，操作符状态
//            Deque<Long> numStack = new ArrayDeque<>();
//            Deque<Character> opStack = new ArrayDeque<>();//分别定义数字栈，操作符栈
//            long number = 0;//坑爹leetcode 由于存在超级大的数字，这里用long，int不够
//            int STATE = STATE_BEGIN;
//            int compuate_flag = 0;//初始化字符转数字初始值，初始状态，计算标志位
//            for (int i = 0; i < s.length(); i++){
//                if (s.charAt(i) == ' '){
//                    continue;
//                }
//                switch (STATE){
//                    case STATE_BEGIN: // 开始状态
//                        if (s.charAt(i) >= '0' && s.charAt(i)<='9'){
//                            STATE = NUMBER_STATE;//如果遇到数字，转到数字状态
//                        }
//                        else {
//                            STATE = OPERATION_STATE;//遇到其他东西，转到操作符状态
//                        }
//                        i--;//退格是因为转到了对应状态没处理呀，所以退回来要处理
//                        break;
//
//                    case NUMBER_STATE: //数字状态
//                        if (s.charAt(i) >= '0' && s.charAt(i)<='9'){
//                            number = number*10+s.charAt(i)-'0';
//                        }
//                        else {// 代表数字处理完了
//                            //数字入栈
//                            numStack.addLast(number);
//                            if (compuate_flag == 1){
//                                compute(numStack, opStack);//如果计算标识符为1，就可以计算
//                            }
//                            number = 0;
//                            i--;//凡是状态内部处理并且发生状态转移之后，都要退格，状态转移后要重新扫描处理
//                            STATE = OPERATION_STATE;
//                        }
//                        break;
//                    case OPERATION_STATE:
//                        if (s.charAt(i) == '+' || s.charAt(i) == '-'){
//                            opStack.addLast(s.charAt(i));
//                            compuate_flag = 1;//遇到操作符，压入操作符栈，计算标识符置1
//                        }
//                        else if (s.charAt(i) == '('){
//                            STATE = NUMBER_STATE;
//                            //不用退格
//                            compuate_flag = 0;//遇到左括号，先算左括号，转移到数字状态，计算标识符置0
//                        }
//                        else if (s.charAt(i)>='0' && s.charAt(i)<='9'){
//                            STATE = NUMBER_STATE;
//                            i--;
//                        }
//                        else if (s.charAt(i) == ')'){
//                            compute(numStack, opStack);
//                        }
//                        break;
//                }
//            }
//            if (number!=0){
//                numStack.addLast(number);
//                compute(numStack, opStack);
//                     //最后一步收尾的计算，勿忘！！！
//            }
//            if (number == 0 && numStack.isEmpty()){//如果数字值为0且数字栈为空 返回
//                return 0;
//            }
//            return numStack.peekLast().intValue();
//        }
//
//        private void compute(Deque<Long> numStack, Deque<Character> opStack) {
//            if (numStack.size()<2)
//                return;
//
//            long num2 = numStack.pollLast();
//            long num1 = numStack.pollLast();
//            char op = opStack.pollLast();
//            if (op == '+'){
//                numStack.addLast(num1+num2);
//            }
//            if (op == '-'){
//                numStack.addLast(num1-num2);
//            }
//        }

//        public int calculate(String s) {
//            char[] array = s.toCharArray();
//            Deque<Integer> nums = new ArrayDeque<>();
//            Deque<Character> op = new ArrayDeque<>();
//
//            int num = -1;
//            for (int i = 0; i < s.length(); i++) {
//                if (array[i] == ' ')
//                    continue;
//
//                if (isNumber(array[i])){
//                    if (num == -1)
//                        num = 0;
//                    num = num*10+array[i]-'0';
//                }
//                else {
//                    // 将数字入栈
//                    if (num!=-1) {
//                        nums.addLast(num);
//                        num = -1;
//                    }
//
//                    if (isOperate(array[i])){
//                        while (!op.isEmpty()){
//                            if (op.peekLast() == '('){
//                                break;
//                            }
//                            int num1 = nums.pollLast();
//                            int num2 = nums.pollLast();
//                            if (op.pollLast() == '+'){
//                                nums.addLast(num2+num1);
//                            }
//                            else {
//                                nums.addLast(num2-num1);
//                            }
//                        }
//
//                        op.addLast(array[i]);
//                    }
//                    else {
//                        if (array[i] == '(')
//                            op.addLast(array[i]);
//                        else {
//                            while (op.peekLast() != '('){
//                                int num1 = nums.pollLast();
//                                int num2 = nums.pollLast();
//                                if (op.pollLast() == '+'){
//                                    nums.addLast(num2+num1);
//                                }
//                                else {
//                                    nums.addLast(num2-num1);
//                                }
//                            }
//                            op.pollLast();
//                        }
//                    }
//                }
//            }
//
//            if (num!=-1) {
//                nums.addLast(num);
//            }
//            while (!op.isEmpty()){
//                int num1 = nums.pollLast();
//                int num2 = nums.pollLast();
//                if (op.pollLast() == '+'){
//                    nums.addLast(num2+num1);
//                }
//                else {
//                    nums.addLast(num2-num1);
//                }
//            }
//            return nums.pollLast();
//        }

        private boolean isNumber(char c){
            return c>='0' && c<='9';
        }

        private boolean isOperate(char c){
            return c == '+' || c == '-' || c == '*' || c == '/';
        }

        int i;
         //(1+(4+5*2)-3)+(6+8)
        public int calculate(String s){
            i = 0;
            return parse(s);
        }

        private int parse(String s){
            Deque<Integer> deque = new ArrayDeque<>();
            int num = 0;
            //
            char sign = '+';
            for (;i<s.length() && sign!=')';i++){
                char c = s.charAt(i);

                if (isNumber(c)){
                    num = num *10 +(c-'0');
                }

                if (c == '(') {
                    i++;
                    num = parse(s);
                    c = s.charAt(i);
                }


                if ((!isNumber(c) && c!=' ') || i == s.length()-1){
                    int pre;
                    switch (sign){
                        case '+':
                            deque.addLast(num);
                            break;
                        case '-':
                            deque.addLast(-num);
                            break;
                        case '*':
                            pre = deque.pollLast();
                            deque.addLast(pre*num);
                            break;
                        case '/':
                            pre = deque.pollLast();
                            deque.addLast(pre/num);
                            break;
                    }
                    sign = c;
                    num = 0;
                }
            }

            int res = 0;
            while (!deque.isEmpty()){
                res += deque.pollLast();
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Solution solution = new LC224().new Solution();
        System.out.println(solution.calculate("(1+(4+5*2)*3)+(6/8))"));
    }
}
