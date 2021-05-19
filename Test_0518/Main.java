package Test_0518;
//变态青蛙跳台阶

public class Main {
    public int jumpFloorII(int target) {
        //因为可以直接跳 n 层台阶 所以和普通的青蛙跳台阶原理不同
        //普通的青蛙跳台阶就是求斐波那契数列
        //而这种跳法是
        //跳一层台阶的跳法有 1 个
        //跳两层台阶的跳法有 f(1) + 1 个
        //跳三层台阶的跳法有 f(2) + 1 个
        //f(n) = f(n-1) * 2
        if(target <= 0){
            return 0;
        }
        else if(target == 1){
            return 1;
        }
        return 2 * jumpFloorII(target - 1);
    }
}