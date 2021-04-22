package Test_0422;
import java.util.*;
//机器人走方格I

public class Main2 {
    public class Robot {
        public int countWays(int x, int y) {
            //当只有一行或者一列的时候, 此时只有一条路线
            //返回 1 即可
            if(x == 1 || y == 1){
                return  1;
            }
            //返回从目的地的左边来的路线 + 从目的地上边来的路线
            return countWays(x-1, y) + countWays(x, y-1);
        }
    }
}
