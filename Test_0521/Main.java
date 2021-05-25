package Test_0521;
//求正数数组的最小不可组成和

//背包问题
public class Main {
    /**
     *	正数数组中的最小不可组成和
     *	输入：正数数组arr
     *	返回：正数数组中的最小不可组成和
     */
    public int getFirstUnFormedNum(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            max += arr[i];
            min = Math.min(arr[i], min);
        }
        boolean[] flag = new boolean[max+1];
        flag[0] = true;
        for(int i = 0; i < arr.length; i++){
            for(int j = max; j >= arr[i]; j--){
                flag[j] = flag[j - arr[i]] || flag[j];
            }
        }
        //遍历结果数组 遇到第一个false的就返回 不然就返回max+1
        for(int i = min; i < flag.length; i++){
            if(!flag[i]){
                return i;
            }
        }
        return max+1;
    }
}
