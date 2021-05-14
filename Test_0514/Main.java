package Test_0514;
//微信红包(就是判断一个数组中出现次数超过一般的数字)

import java.util.*;

public class Main {
    public class Gift {
        public int getValue(int[] gifts, int n) {
            // write code here
            //先对数组进行排序
            Arrays.sort(gifts);
            //如果存在该数字 那么数组中间的数字必定是该数字
            int mid = gifts[n/2];
            //检验是否有这个数字
            //看数组中间的数字出现的次数是否大于 n/2
            int count = 0;
            for(int tem = 0; tem < gifts.length; tem++){
                if(mid == gifts[tem]){
                    count++;
                }
            }
            return count > n/2 ? mid : 0;
        }
    }
}
