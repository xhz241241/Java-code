package MapAndSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MySet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        // 1. add
        set.add(10);
        set.add(9);
        set.add(8);
        set.add(7);
        set.add(6);
        System.out.println(set);
        // 2. contains
        boolean tem = set.contains(4);
        boolean tem2 = set.contains(7);
        System.out.println(tem);
        System.out.println(tem2);
        // 3. remove
        set.remove(7);
        System.out.println(set);
        // 4. isEmpty
        System.out.println(set.isEmpty());
        // 5. size
        System.out.println(set.size());
        // 6. clear
//        set.clear();
//        System.out.println(set);
        // 7. 遍历
        for(Integer key : set){
            System.out.println(key);
        }
        // 7. 迭代器遍历
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    } // main end

}
