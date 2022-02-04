package com.course.line.algo.twopoint;

/**
 * @author freedoow
 * @Description:
 * @Date 2022-01-10
 */
public class ReverseString {


    public static String ReverseString(String s) {
        char[] chars = s.toCharArray();

        int left = 0;
        int right = chars.length - 1;
            while (left < right){
                char temp = chars[left];
                chars[left] =  chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        return new String(chars);

    }

    public static String ReverseString1(String s) {
        char[] chars = s.toCharArray();
        char[] temp = new char[chars.length];
        int i = chars.length - 1;
        for (int j = 0; j < chars.length; j++) {
            temp[i] = chars[j];
            i--;
        }
        return new String(temp);

    }

    public static void main(String[] args) {
        System.out.println(ReverseString.ReverseString("hello"));
    }
}
