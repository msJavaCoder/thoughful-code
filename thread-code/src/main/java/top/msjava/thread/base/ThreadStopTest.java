package top.msjava.thread.base;

/**
 * @BelongsProject: thoughtful-code
 * @BelongsPackage: top.msjava.thread.base
 * @Author: msJava
 * @CreateTime: 2022-08-07  07:39
 * @Description: 测试-中断正在运行中的线程
 * @Version: 1.0
 */
public class ThreadStopTest implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted() && count < 1000) {
            System.out.println("count = " + count++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 启动子线程
        Thread thread = new Thread(new ThreadStopTest());
        thread.start();

        // 主线程休眠5毫秒
        Thread.sleep(5);

        System.out.println("main thread interrupt thread");
        // 对子线程进行中断操作
        thread.interrupt();

        // 等待子线程执行完毕
        thread.join();
        System.out.println("main over");
    }
}
