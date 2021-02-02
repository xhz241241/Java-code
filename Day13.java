import java.util.List;

public class Day13 {
    public static void main(String[] args) {
        int[] arr = {0,2,1,-6,6,-7,9,1,2,0,1};
        System.out.println(canThreePartsEqualSum(arr));
    }

    public static boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for(int t : arr){
            sum += t;
        }
        //当总和不是3的倍数时, 说明无法被分成三个相等的部分, 直接返回false
        if(sum % 3 != 0){
            return false;
        }
        int left = 0;
        int right = arr.length-1;
        int leftSum = arr[left];
        int rightSum = arr[right];

        while(left+1 < right){
            if(leftSum == sum/3 && rightSum == sum/3){
                return true;
            }
            if(sum / 3 != leftSum){
                left++;
                leftSum = leftSum + arr[left];
            }
            if(sum / 3 != rightSum){
                right--;
                rightSum = rightSum + arr[right];
            }
        }
        return false;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        for(Employee e : employees){
            if(e.id == id){
                //递归结束通道
                if (e.subordinates.size() == 0) {
                    return e.importance;
                }
                for(int sub : e.subordinates){
                    e.importance = e.importance + getImportance(employees, sub);
                }
                return e.importance;
            }
        }
        return 0;
    }
}