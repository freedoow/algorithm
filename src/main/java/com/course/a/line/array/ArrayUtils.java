package com.course.a.line.array;

/**
 * @author freedoow
 * @Description:
 */
public class ArrayUtils {

    /**
     * 将指定元素插入指定的数组位置
     *
     * @param src
     * @param index
     * @param element
     * @return
     */
    public static int[] insertElement(int[] src, int index, int element) {
        int length = src.length;
        int[] dest = new int[length + 1];

        //赋值 少于插入目标值的数组值
        for (int i = 0; i < index; i++) {
            dest[i] = src[i];
        }
        // 赋值目标值
        dest[index] = element;

        // 赋值目标值之后的元素
        for (int i = index; i < length; i++) {
            dest[i + 1] = src[i];
        }

        return dest;
    }

    public static int[] removeElement(int[] src, int index) {
        int dest[] = new int[src.length - 1];
        
        for (int i = 0; i < index; i++) {
            dest[i] = src[i];
        }

        for (int i = index; i < src.length -1; i++) {
            dest[i] = src[i + 1];
        }
        return dest;
    }


}
