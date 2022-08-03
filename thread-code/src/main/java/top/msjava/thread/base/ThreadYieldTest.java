package top.msjava.thread.base;

/**
 * @BelongsProject: thoughtful-code
 * @BelongsPackage: top.msjava.thread.test
 * @Author: msJava
 * @CreateTime: 2022-08-01  21:59
 * @Description: 测试-让出CPU执行权的yield方法
 * @Version: 1.0
 */
public class ThreadYieldTest implements Runnable {

    ThreadYieldTest() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if ((i % 5) == 0) {
                System.out.println(Thread.currentThread() + "yield cpu...");
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread() + "is over");
    }

    public static void main(String[] args) {
        new ThreadYieldTest();
        new ThreadYieldTest();
    }
}
