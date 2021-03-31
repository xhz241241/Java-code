package MapAndSet;

import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class MapSetTest {
    // 1. 给定一个非空整数数组，除了某个元素只出现一次以外，
    // 其余每个元素均出现两次。找出那个只出现了一次的元素。
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
             // 2. 遍历数组, 把所有数字插入到Map中
             for(int i : nums){
                 Integer value = map.get(i);
                 if(value == null){
                     //说明该数字还没有被插入到map中
                     map.put(i, 1);
                 }else{
                     //说明该数字已经被插入到map中过, 此时value+1即可
                     map.put(i, value+1);
                 }
             }
             //此时遍历map找出value = 1 的数字
             for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                 if(entry.getValue() == 1){
                     return entry.getKey();
                 }
             }
         return -1;
    }

    // 2. 复制带随机指针的链表
    public Node copyRandomList(Node head) {
        // 1. 创建一个map, key作为旧节点, value作为新节点
        Map<Node, Node> map = new HashMap<>();
        // 2. 遍历旧链表, 把新链表放到Value的位置上
        for(Node cur = head; cur != null; cur = cur.next){
            map.put(cur, new Node(cur.val));
        }
        // 3. 在遍历旧链表, 把旧链表的next和rendom放到新链表上
        for(Node cur = head; cur != null; cur = cur.next){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
        }
        return map.get(head);
    }

    // 3. 宝石与石头
    public int numJewelsInStones(String jewels, String stones) {
        // 1. 创建一个set用来存宝石
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < jewels.length(); i ++){
            set.add(jewels.charAt(i));
        }
        // 2. 在遍历石头, 看石头里面有没有宝石
        int count = 0;
        for(int i = 0; i < stones.length(); i++){
            if(set.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
    }

    // 4. 前K个高频单词
    public List<String> topKFrequent(String[] words, int k) {
        // 1. 创建一个map用来存每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for(String key : words){
            Integer value = map.get(key);
            if(value == null){
                map.put(key, 0);
            }else{
                map.put(key, value+1);
            }
        }
        // 2. 再把每个key都取出来放到一个List中
        List<String> wordList = new ArrayList<>(map.keySet());
        // 3. 对上述Lsit进行一定规则排序,
        //    就是先按照再map中出现的次数排序, 如果一样就按照字典序排
        Collections.sort(wordList, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                Integer count1 = map.get(o1);
                Integer count2 = map.get(o2);
                if(count1 == count2){
                    return o1.compareTo(o2);
                }
                return count2 - count1;
            }
        });
        return wordList.subList(0, k);
    }
}
