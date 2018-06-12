package com.netMusic.utils;

import java.util.ArrayList;
import java.util.List;

public class BaseUtil {
    /**
     * 生成(min,max)区间的n个不重复数字
     * @param min
     * @param max
     * @param n
     * @return
     */
    public static List<Integer> getRandomNumber(int min, int max, int n){

        if(n>(max-min+1) || max<min){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while(count < n ){
            int num = (int) ((Math.random()*(max-min))+min);

            if(!list.contains(num)){
                list.add(num);
                count++;
            }else{
                count--;
            }

        }

        return list;
    }
}
