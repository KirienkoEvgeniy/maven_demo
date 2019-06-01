package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandListMaven {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random rand = new Random();

        for (int i = 0; i <= 10000; i++)
        {
            int n = rand.nextInt(10000);
            list.add(n);
        }

        List<Integer> tmpList = new ArrayList<Integer>();
        for (Integer tmpValues : list)
            if (!tmpList.contains(tmpValues))
                tmpList.add(tmpValues);
        System.out.println("Number of non-repetitive values -> " + tmpList.size());

        System.out.println("Max element -> " + maxElem(list));

    }

    public static Integer maxElem(List<Integer> values){
        if (values.isEmpty()) return null;
        Integer max = Integer.MIN_VALUE;
        for(Integer value : values){
            if (max.compareTo(value)==-1){
                max = value;
            }
        }
        return max;
    }
}
