package top.msjava.base.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @BelongsProject: thoughtful-code
 * @BelongsPackage: top.msjava.base.test
 * @Author: msJava
 * @CreateTime: 2022-07-27  22:16
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
public class BaseTest {

    public static void main(String[] args) {

        BaseTest test = new BaseTest();
        new Thread(() -> test.add()).start();
        new Thread(() -> test.compare()).start();

    }

    volatile int a = 1;
    volatile int b = 1;

    public synchronized void add() {
        log.info("add start");
        for (int i = 0; i < 10000; i++) {
            a++;
            b++;
        }
        log.info("add done");
    }

    public synchronized void compare() {
        log.info("compare start");
        for (int i = 0; i < 10000; i++) {
            //a始终等于b吗？
            if (a < b) {
                log.info("a:{},b:{},{}", a, b, a > b);
                //最后的a>b应该始终是false吗？
            }
        }
        log.info("compare done");
    }


}

