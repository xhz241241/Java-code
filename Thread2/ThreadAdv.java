package Thread2;

public class ThreadAdv {
    public static void main(String[] args) {
        //循环10亿次，每次++运算
        // 1. 串行的方式
        long start = System.nanoTime();
        loop();
        loop();
        long end = System.nanoTime();
        System.out.printf("串行时间耗时: %s毫秒%n", (end-start)/1000/1000);
        // 2. 并行的方式  main线程，子线程同时执行loop方法
        long start2 = System.nanoTime();
        new Thread(new Runnable() {
            @Override
            public void run() {
                loop();
            }
        }).start();
        loop();
        //计算时间，需要让子线程，main线程loop都执行完
        //当前main和main线程中创建的子线程，活跃线程数>1，main线程就一直让步
        //子线程执行完，main线程才能继续向下执行
        while(Thread.activeCount()>1){
            Thread.yield();
        }
        long end2 = System.nanoTime();
        System.out.printf("并行时间耗时: %s毫秒%n", (end2-start2)/1000/1000);
    }
    private static void loop(){
        int m = 0;
        for(int i =  0; i < 10_0000_0000; i++){
            m++;
        }
    }
}
