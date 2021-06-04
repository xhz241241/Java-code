package Thread3;

public class ThreadUnsafe {
    private static int N;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 1000; j++) {
                        N++;
                    }
                }
            }
        }).start();
        while(Thread.activeCount() > 1) Thread.yield();
        System.out.println(N);
    }
}
