//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
//NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
public class Test6 {
    public static void main(String[] args) {
        int[] array = {1,0,1,1,1};
        System.out.println(minNumberInRotateArray(array));
    }

    public static int minNumberInRotateArray(int[] array) {
        int right = array.length - 1;
        int left = 0;
        if(right < 0){
            return 0;
        }
        while(left < right){
            int mid = (left + right) / 2;
            //mid必须要在while循环内部 不然mid无法更新
            if(array[mid] > array[right]){
                left = mid + 1;
            }
            else if(array[mid] < array[right]){
                right = mid;
                //right不能=mid-1
                //[3, 2, 1, 2, 5, 6, 7]时
                //mid=2, right=mid-1后=1, 此时mid=2,再次进入mid<left内 right=3, 则判断出错
            }
            else {
                right = right - 1;
            }
        }
        return array[left];
    }
}
