import java.util.Arrays;

class MyArrayIndexOutOfBoundException extends RuntimeException{
    public MyArrayIndexOutOfBoundException(String message) {
        super(message);
    }
}

public class MyArrayList {
    private String[] data = null;
    private int size = 0;
    private int capacity = 100;

    public MyArrayList() {
        data = new String[capacity];
    }

    private void realloc() {
        capacity = capacity * 2;
        String[] newdata = new String[capacity];
        for(int i = 0; i < size; i++){
            newdata[i] = data[i];
        }
        newdata = data;
    }

    //1.add(尾插法)
    public void add(String str){
        if(size >= capacity){
            //需要扩容
            realloc();
        }
        data[size] = str;
        size++;
    }
    //2.add(中间插入元素)
    public void add(int index, String str){
        if(size >= capacity){
            realloc();
        }
        if(index < 0 || index > size){
            return;
        }
        //需要从后到index把每一个元素依次搬运到后一个位置
        for(int i = size-1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = str;
        size++;
    }

    //3.删除元素(按照下标), 返回该下标的内容
    public String remove(int index){
        if(index < 0 || index >= size){
            return null;
        }
        String tem = data[index];
        //删除元素从index到末尾,依次把元素向前移动一个位置
        for(int i = index; i < size-1; i++){
            data[i] = data[i+1];
        }
        size--;
        return tem;
    }
    //4.删除元素(按照值删), 返回boolean类型
    public boolean remeove(String str){
        int i = 0;
        for(; i < size; i++){
            if(data[i] .equals(str)){
                break;
            }
        }
        if(i == size){
            return false;
        }
        //搬运元素
        for(; i < size-1; i++){
            data[i] = data[i+1];
        }
        size--;
        return true;
    }

    //5.根据下标获取元素
    public String get(int index){
        if(index < 0 || index >= size){
            throw new MyArrayIndexOutOfBoundException("下标越界异常!");
        }
        return data[index];
    }
    //6.根据下标修改元素
    public void set(int index, String str){
        if(index < 0 || index >= size){
            throw new MyArrayIndexOutOfBoundException("下标越界异常!");
        }
        data[index] = str;
    }

    //7.判断是否存在该元素, 返回boolean
    public boolean contains(String str){
        for(int i = 0; i < size; i++){
            if(data[i].equals(str)){
                return true;
            }
        }
        return false;
    }

    //8.查找元素位置, 返回下标
    public int indexOf(String str){
        for(int i = 0; i < size; i++){
            if(data[i].equals(str)){
                return i;
            }
        }
        return -1;
    }
    //9.查找元素位置(从后往前找)
    public int LastIndexOf(String str){
        for(int i = size-1; i >= 0; i--){
            if(data[i].equals(str)){
                return i;
            }
        }
        return -1;
    }

    //10.清空数组
    public void clear(){
        size = 0;
    }

    //11.获取长度
    public int size(){
        return size;
    }

    //12.判断是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for(int i = 0; i < size; i++){
            stringBuffer.append(data[i]);
            if(i < size-1){
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
//        testadd();
//        testremove();
//        testgetandset();
        tsetconatinsAndIndexof();
    }

    private static void tsetconatinsAndIndexof() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.add("d");
        myArrayList.add("e");
        myArrayList.add("c");
        System.out.println("原顺序表为: " + myArrayList);
        System.out.println("测试contains输入 g " + myArrayList.contains("g"));
        System.out.println("测试indexof输入 c " + myArrayList.indexOf("c"));
        System.out.println("测试LastIndexOf 输入 c " + myArrayList.LastIndexOf("c"));
    }

    private static void testgetandset() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.add("d");
        myArrayList.add("e");
        System.out.println("原顺序表为: " + myArrayList);
        System.out.println("调用get方法输入3的情况: " + myArrayList.get(3));
        myArrayList.set(1, "z");
        System.out.println("调用set方法输入1, z: " + myArrayList);
    }

    private static void testremove() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.add("d");
        myArrayList.add("e");
        System.out.println("原顺序表为: " + myArrayList);
        System.out.println("验证输入下标1删除元素: ");
        myArrayList.remove(1);
        System.out.println(myArrayList);
        System.out.println("输入1000的情况为: " + myArrayList.remove(1000));

        System.out.println("验证输入字符串a删除: ");
        myArrayList.remeove("a");
        System.out.println(myArrayList);
        System.out.println("输入一个不存在的字符串: " + myArrayList.remeove("u"));
    }

    private static void testadd() {
        MyArrayList myArrayList = new MyArrayList();
        System.out.println("验证尾插法: ");
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.add("d");
        myArrayList.add("e");
        System.out.println(myArrayList);

        System.out.println("验证从中间插入元素: ");
        myArrayList.add(2, "f");
        System.out.println(myArrayList);
    }
}
