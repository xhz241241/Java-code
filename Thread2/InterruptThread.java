package Thread2;

public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //此处try catch 应该包裹在整个代码外部 而不是出错的单行代码
                //否则会导致本该中断的线程抛出异常后又继续执行
                try {
                    System.out.println("开始转账");
                    while(!Thread.currentThread().isInterrupted()){
                        System.out.println("转账ing...");
                        Thread.sleep(10000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(3*100);
        thread.interrupt();
    }
}
