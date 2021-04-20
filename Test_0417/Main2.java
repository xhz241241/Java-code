package Test_0417;
//把字符串转换成整数

public class Main2 {
    //核心思想就是 sum = sum * 10 + str[i] - '0'
    public int StrToInt(String str) {
        char[] ch = str.toCharArray();
        if(str == null || ch.length == 0){
            return 0;
        }
        //当标识为有符号时就把首位设为 0
        //此时就需要一个数组了, 因为 String 不可变
        int flag = 1;
        if(ch[0] == '-'){
            flag = -1;
            ch[0] = '0';
        }else if(ch[0] == '+'){
            ch[0] = '0';
        }
        int sum = 0;
        for(int i = 0; i < str.length(); i++){
            //判断不是数字的字符
            if(ch[i] < '0' || ch[i] > '9'){
                return 0;
            }
            sum = sum * 10 + ch[i] - '0';
        }
        return sum * flag;
    }
}