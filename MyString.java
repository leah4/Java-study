﻿import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//自定义一个String类

public final class MyString implements Comparable<MyString>{
    private final char[] value;  //保证对象的不可变性

    //public 的方法列出
    //需要复制数组，保证数组的引用不会被泄露
    //泄露会导致通过泄露的引用修改属性的值，从而破坏对象的不可变性
    public MyString(char value[]){
        this.value = Arrays.copyOf(value, value.length);
    }

    public MyString(char value[], int offset, int count) {
        this.value = Arrays.copyOfRange(value, offset, offset + count);
    }

    //这里引用泄露没有问题，因为新的对象也不会去修改value数组中的值
    //相较于copyOf，可以省去复制的时间，提升效率
    public MyString(MyString s) {
        this.value = s.value;
    }

    //模拟的对象常量池
    private static List<MyString> pool = new ArrayList<>();
    //模拟直接定义字符串
    //会直接入池
    public static MyString literal(MyString s) {
        for (MyString ms: pool) {
            if (ms.equals(s)) {
                return ms;
            }
        }
        MyString rs = new MyString(s);
        pool.add(rs);
        return rs;
    }

    //手动入池
    //如果常量池中已有该相等对象，返回引用
    //否则在常量池中创建对象，并返回引用
    public MyString intern(){
        for (MyString ms: pool) {
            if (ms.equals(this)) {
                return ms;
            }
        }
        MyString rs = new MyString(this);
        pool.add(rs);
        return rs;
    }

    public char charAt(int index) {
        return value[index];
    }

    //不能直接返回引用，防止引用泄露
    public char[] toCharArray() {
        return Arrays.copyOf(value, value.length);
    }

    public MyString toUpper(){
        /*
        1.构造一个新对象
        2.遍历新对象的value;
        3.把小写字母换成大写字母
        4.返回新的对象
         */
        MyString s = new MyString(value);
        for(int i = 0; i < s.value.length; i++) {
            if (s.value[i] >= 'a' && s.value[i] <= 'z') {
                s.value[i] = (char)(s.value[i] - 'a' + 'A');
            }
        }
        return s;
    }

    public boolean equalsIgnoreCase(MyString s){
        //效率不高
        //return toUpper().equals(s.toUpper());

        if (s == null) {
            return false;
        }
        if (value.length != s.value.length) {
            return false;
        }
        for (int i = 0; i < value.length; i++) {
            char a = value[i];
            char b = s.value[i];
            if (a == b) {
                continue;
            }
            if (a >= 'a' && a <= 'z') {
                a += ('A' + 'a');
                if (a == b) {
                    continue;
                }
            } else if (a >= 'A' && a <= 'Z') {
                a += ('a' - 'A');
                if (a == b) {
                    continue;
                }
            }
            return false;
        }
        return true;
    }


    public MyString toLower(){
        MyString s = new MyString(value);
        for (int i = 0; i < s.value.length; i++) {
            if (s.value[i] >= 'A' && s.value[i] <= 'Z') {
                s.value[i] = (char)(s.value[i] - 'A' + 'a');
            }
        }
        return s;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        for (char c: value) {
            hash = (hash ^ c);
        }
        return hash;

        //return value.hashCode();
    }

    public MyString substring(int begin, int end) {
        return new MyString(value, begin, end - begin);
    }


    @Override
    public int compareTo (MyString o) {
        if (o == null) {
            return 1;
        }
        int length = Math.min(value.length, o.value.length);
        for (int i = 0; i < length; i++) {
            char a = value[i];
            char b = o.value[i];
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
        }
        if (value.length > o.value.length) {
            return 1;
        } else if (value.length < o.value.length) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object s) {
        /*
        1.判断引用是否指向同一个对象
        2.s是不是null
        3.s是不是一个MyString 类
        4.比较属性的相等性
         */
        if (this == s) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (!(s instanceof MyString)) {
            return false;
        }
        return Arrays.equals(value, ((MyString) s).value);
    }
    
    @Override
    public String toString() {
        return new String(value);
    }


    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c'};
        MyString s = new MyString(a);
        MyString t = new MyString(s);
        System.out.println(s);
        System.out.println(t);
        System.out.println(s.equals(t));
        MyString r = t.toUpper();
        System.out.println(s);
        System.out.println(t);
        System.out.println(r);
        System.out.println(s.equals(t));
    }
}
