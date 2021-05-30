package Thread;

public class newRunnable {
    public static void main(String[] args) {
        // 1. 使用runnable接口创建任务 再创建一个线程把任务传进去
        Runnable ru = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnableSsuccess!");
            }
        };
        Thread thread = new Thread(ru);

        // 2. 以上合并的写法
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnableSuccess!");
            }
        });
    }
}
