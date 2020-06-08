package com.sort.cmp;

import com.sort.Sort;

public class SelectionSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {

        // for (int end = array.length - 1; end > 0; end--) {
        // int max = 0;
        // for (int begin = 1; begin <= end; begin++) {
        // if (cmp(max, begin) <= 0) {
        // max = begin;
        // }
        // }
        // swap(max, end);
        // }

        for (int end = array.length - 1; end > 0; end--) {
            int max = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(max, begin) < 0) {
                    max = begin;
                }
            }
            swap(max, end);//减少交换次数
        }
    }

}
