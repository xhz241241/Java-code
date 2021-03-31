package MapAndSet;

import java.util.HashMap;
import java.util.Map;

public class MyMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        // 1. put
        map.put(1, "zhang");
        map.put(2, "li");
        map.put(3, "sun");
        map.put(4, "qian");
        System.out.println(map);
        // 2. get / getorDefult
        String str1 = map.get(1);
        String str2 = map.getOrDefault(8, "tem");
        System.out.println(str1 + " " + str2);
        // 3. isEmpty
        System.out.println(map.isEmpty());
        // 4. size
        System.out.println(map.size());
        // 5. clear
//        map.clear();
        System.out.println(map.isEmpty());
        // 6. 单独获取 key 或 value
        for(Integer key : map.keySet()){
            System.out.println(key);
        }
        for(String value : map.values()){
            System.out.println(value);
        }
    }
}
