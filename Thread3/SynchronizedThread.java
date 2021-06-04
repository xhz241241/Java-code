package Thread3;

public class SynchronizedThread {
    private static int N;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 1000; j++) {
                        incresment1();
                        incresment2();
                        incresment3();
                    }
                }
            }
        }).start();
        while(Thread.activeCount() > 1) Thread.yield();
        System.out.println(N);
    }

    //使用静态方法加锁
    private synchronized static void incresment1() {
        N++;
    }

    //同步代码块加锁
    private static void incresment2() {
        synchronized(SynchronizedThread.class){
            N++;
        }
    }
    private static void incresment3() {
        Object object = new Object();
        synchronized(object){
            N++;
        }
    }
}
