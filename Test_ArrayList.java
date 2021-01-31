import java.util.ArrayList;
import java.util.Iterator;

public class Test_ArrayList {
    public static void main(String[] args) {
        //创建顺序表
        ArrayList<String> arrayList = new ArrayList<>();

        //1.添加元素(add)
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add(2, "f");
        System.out.println(arrayList);

        //2.删除元素
        arrayList.remove(2);
        System.out.println("按照下标删除: " + arrayList);
        arrayList.remove("c");
        System.out.println("按照值删除: " + arrayList);

        //3.查找元素
        boolean ret = arrayList.contains("d");
        System.out.println(ret);
        int index = arrayList.indexOf("a");
        System.out.println(index);

        //4.获取元素/修改元素
        String s = arrayList.get(1);
        System.out.println("1号元素为: " + s);
        arrayList.set(0, "z");
        System.out.println("修改0号元素为在z: " + arrayList);

        //5.遍历
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        //迭代器遍历
        System.out.println("迭代器遍历: ");
        Iterator<String> it = arrayList.iterator();
        //判断是否到达末尾
        while(it.hasNext()){
            //没有到达末尾就一直往下找
            String tem = it.next();
            System.out.println(tem);
        }

        //for-each遍历(本质上是迭代器)
        System.out.println("通过for each遍历");
        for(String e : arrayList){
            System.out.println(e);
        }
    }
}
