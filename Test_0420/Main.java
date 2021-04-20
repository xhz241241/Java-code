package Test_0420;
//删数

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n > 1000){
                n = 999;
            }
            //创建一个链表
            List<Integer> list = new ArrayList<>();
            //先把所有的数据放到链表里面
            for(int i = 0; i < n; i++){
                list.add(i);
            }
            int i = 0;
            //当链表元素个数不为 1 时 依次删除元素
            //每隔两个就删除
            //最后当链表个数为 1 时输出那个数即可
            while(list.size() > 1){
                i = (i + 2) % list.size();
                list.remove(i);
            }
            System.out.println(list.get(0));
        }
    }
}
