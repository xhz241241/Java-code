package Test_0417;
//把字符串转换成整数

public class Main2 {
        public int StrToInt(String str) {
            if(str.length() == 0){
                return 0;
            }
            char[] arr = str.toCharArray();
            int start = 0;
            boolean flag = true;
            //标识符号位
            if(arr[0] == '-' || arr[0] == '+'){
                start = 1;
                if(arr[0] == '-'){
                    flag = false;
                }
            }
            int res = 0;
            //遍历数组, 遇到不是数字的就返回0
            //如果是数字, 就把ASCII码转成数字并乘10继续下次遍历
            for(int i = start; i < arr.length; i++){
                if(arr[i] < 48 || arr[i] > 57){
                    return 0;
                }else{
                    res = res * 10 + (arr[i] - 48);
                }
            }
            return flag == true ? res : res * -1;
        }
}
