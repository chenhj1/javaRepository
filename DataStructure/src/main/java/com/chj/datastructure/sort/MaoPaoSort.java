package com.chj.datastructure.sort;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

/**
 * 冒泡排序
 */
public class MaoPaoSort {

    @Test
    public void sort() {
        int[] a = new int[]{6, 4, 1, 9, 3, 2};
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            System.out.println("第" + i + "轮, " + JSONArray.fromObject(a).toString());
        }

        System.out.println("\n结果：" + JSONArray.fromObject(a).toString());

    }
}
