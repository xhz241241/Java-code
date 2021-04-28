package Test_0428;
//拿手套问题

import java.util.*;

public class Main2 {
    public class Gloves {
        public int findMinimum(int n, int[] left, int[] right) {
            // write code here
            int sum = 0;
            int countleft = 0;
            int countright = 0;
            //因为题目保证左右手手套总数不超过26
            //所以最坏情况就是左手或右手有26只
            int leftmin = 27;
            int rightmin = 27;
            for(int i = 0; i < n; i++){
                if(left[i] * right[i] == 0){
                    //当前颜色左右手有一个为 0 或都为 0
                    sum = sum + (left[i] + right[i]);
                }else{
                    //左右手该颜色都不为 0
                    countleft = countleft + left[i];
                    countright = countright + right[i];
                    if(leftmin > left[i]){
                        leftmin = left[i];
                    }
                    if(rightmin > right[i]){
                        rightmin = right[i];
                    }
                }
            }
            countleft = countleft - leftmin + 1;
            countright = countright - rightmin + 1;
            if(countleft < countright){
                return sum + countleft + 1;
            }else{
                return sum + countright + 1;
            }
        }
    }
}
