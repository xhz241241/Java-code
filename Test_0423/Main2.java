package Test_0423;
import java.util.*;
//求最近公共祖先 序号从 1 开始

public class Main2 {
    public int getLCA(int a, int b) {
        //当 a 和 b 不相等时, 就让大的一方除以 2
        //直到两个数相等
        //相等的值就是他俩的公共祖先
        while(a != b){
            if(a > b){
                a = a / 2;
            }else{
                b = b / 2;
            }
        }
        return a;
    }
}
