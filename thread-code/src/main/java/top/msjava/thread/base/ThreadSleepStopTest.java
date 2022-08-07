package top.msjava.thread.base;

/**
 * @BelongsProject: thoughtful-code
 * @BelongsPackage: top.msjava.thread.base
 * @Author: msJava
 * @CreateTime: 2022-08-07  07:39
 * @Description: 测试-中断睡眠状态中的线程
 * @Version: 1.0
 */
public class ThreadSleepStopTest implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("thread begin sleep for 2000 seconds");
            Thread.sleep(2000000);
            System.out.println("thread awaking");
        } catch (InterruptedException e) {
            System.out.println("thread is interrupted while sleeping");
            return;
        }
        System.out.println("thread leaving normally");
    }

    public static void main(String[] args) throws InterruptedException {
        // 启动子线程
        Thread thread = new Thread(new ThreadSleepStopTest());
        thread.start();
        // 主线程休眠1000毫秒
        Thread.sleep(1000);
        // 对子线程进行中断操作
        thread.interrupt();
        // 等待子线程执行完毕
        System.out.println("main thread is over");
    }
}
