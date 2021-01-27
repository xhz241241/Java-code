import java.util.Arrays;

public class Day9 {
    public static void main(String[] args) {
        int[] arr = {3,2,4};
//        System.out.println(Arrays.toString(twoSum(arr, 6)));
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
            StringBuilder ans = new StringBuilder();
            int ca = 0;
            for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
                int sum = ca;
                sum += i >= 0 ? a.charAt(i) - '0' : 0;
                sum += j >= 0 ? b.charAt(j) - '0' : 0;
                ans.append(sum % 2);
                ca = sum / 2;
            }
            ans.append(ca == 1 ? ca : "");
            return ans.reverse().toString();
    }




    public static int[] twoSum(int[] arr, int target) {
        int[] a = new int[2];
        for(int i = 0; i < arr.length; i++){
            a[0] = i;
            for(int j = 0; j < arr.length; j++){
                if(j == i){
                    continue;
                }
                if(arr[i] + arr[j] == target){
                    a[1] = j;
                    return a;
                }
            }
        }
        return a;
    }
}
