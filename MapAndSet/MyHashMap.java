package MapAndSet;


class HashNode{
    int key;
    int val;
    HashNode next;

    public HashNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class MyHashMap {
    private HashNode[] arr = new HashNode[20];
    private int size = 0;

    //通过这个方法把key映射成下标
    private int hashCode(int key){
        return key % arr.length;
    }

    public void put(int key, int val){
        // 1. 先计算要放到哪个下标上
        int index = hashCode(key);
        // 2. 再遍历该下标所在的链表看该 key 是否存在
        //     如果存在直接修改 val 的值即可
        for(HashNode cur = arr[index]; cur != null; cur = cur.next){
            if(key == cur.key){
                cur.val = val;
                return;
            }
        }
        // 3. 如果该 key 不存在就创建一个新节点,头插到链表上
        HashNode newNode = new HashNode(key, val);
        newNode.next = arr[index];
        arr[index] = newNode;
        size++;
        // 4. 这时还需要判断数组内元素是不是过于多了, 哈希冲突的可能就会越大
        //    我们引入一个 负载因子 的概念
        //    就是 元素个数 / 数组长度
        //    这里设成 0.75 是因为java标准库中的负载因子就是 0.75
        if((double)size / arr.length > 0.75){
            resize();
        }
    }

    private void resize() {
        //扩容的原理就是创建一个更大的数组, 把原来的数组中的元素搬运到新数组中就行了
        HashNode[] newarr = new HashNode[arr.length*2];
        for(int i = 0; i < arr.length; i++){
            HashNode next = null;
            for(HashNode cur = arr[i]; cur != null; cur = cur.next){
                next = cur.next;
                int newIndex = cur.key % newarr.length;
                cur.next = newarr[newIndex];
                newarr[newIndex] = cur;
            }
        }
        arr = newarr;
    }

    public Integer get(int key){
        int index = hashCode(key);
        for(HashNode cur = arr[index]; cur != null; cur = cur.next){
            if(key == cur.key){
                return cur.val;
            }
        }
        return null;
    }

    public void remove(int key){
        int index = hashCode(key);
        for(HashNode cur = arr[index]; cur != null;){
            HashNode pre = cur;
            if(key == cur.key){
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;
        }
    }
}
