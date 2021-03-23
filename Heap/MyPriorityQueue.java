package Heap;

public class MyPriorityQueue {
    private static int[] arr = new int[100];
    private static int size = 0;

    //堆的核心操作就是向上调整和向下调整
    // arr表示的是该堆形成的数组,
    // size表示这个堆的有效元素大小,
    // index表示从该下标开始向下调整
    //以下例子都以大堆为例
    public static void shiftDown(int[] arr, int size, int index){
        // 向下调整主要操作就是将根节点和他的左右孩子节点进行比较
        // 将三者较大的一个放到根节点上
        //用下标来表示根节点和孩子节点
        //左子树的下标为2*i+1, 右子树下标为2*i+2
        //根节点的下标为 (i-1)/2
        int parent = index;
        int child = 2 * parent +1;
        while(child < size){
            if(child + 1 < size && arr[child] < arr[child+1]){
                child = child + 1;
            }
            if(arr[parent] < arr[child]){
                int tem = arr[parent];
                arr[parent] = arr[child];
                arr[child] = tem;
            }
            else{
                break;
            }
            parent = child;
            child = 2 * parent +1;
        }
    }

    public static void shiftUp(int[] arr, int size, int index){
        //向上调整的核心操作是把根节点和他的父亲节点进行比较
        // 把较大者放到父亲节点的位置上
        int child = index;
        int parent = (child - 1) / 2;
        while(child > 0){
            if(arr[parent] < arr[child]){
                int tem = arr[parent];
                arr[parent] = arr[child];
                arr[child] = tem;
            }else{
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    // 建堆操作
    public static void creatHeap(int[] arr){
        // 建堆操作就是从后向前遍历数组
        // 遇到每个元素都向下调整
        // 并且不需要从数组末尾开始
        // 因为叶子结点是没有子节点的, 所以不需要进行向下调整
        // 所以从最后一个节点的父节点开始即可
        for(int i = ((arr.length-1)-1) / 2; i >= 0; i--){
            shiftDown(arr, arr.length, i);
        }
    }

    // 往堆中插入元素
    public static void offer(int val){
        if(size >= arr.length){
            return;
        }
        arr[size] = val;
        size++;
        //还需要进行向上调整
        shiftUp(arr, size, size-1);
    }

    // 取堆顶元素
    public static Integer peek(){
        if(size == 0){
            return null;
        }
        return arr[0];
    }

    // 删除堆中元素(删除的是堆顶元素)
    public static Integer poll(){
        if(size == 0){
            return null;
        }
        //先把要删除的元素记录下来方便return
        int res = arr[0];
        //把0号元素和size-1号元素交换
        int tem = arr[0];
        arr[0] = arr[size-1];
        arr[size-1] = tem;
        //删除最后一个元素
        size--;
        //再从0号元素开始向下调整
        shiftDown(arr, size, 0);
        return res;
    }
}
