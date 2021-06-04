package Thread2;

public class ThreadSeq {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程执行");
            }
        }, "子线程").start();
//        Thread.currentThread();
//        System.out.println("main方法执行");
        System.out.println(Thread.currentThread().getName());

    }
}
