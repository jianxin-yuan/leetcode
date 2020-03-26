package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/fizz-buzz-multithreaded/solution/1ge-reentrantlock-1ge-condition-1ge-volatilebian-l/
 */
public class FizzBuzzForReentrantLock {

    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int state = -1;


    public FizzBuzzForReentrantLock(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        //打印3的倍数
        for (int i = 3; i <= n; i += 3) {
            System.out.println("fizz==" + i);
            if (i % 15 == 0) {//15的倍数不处理
                continue;
            }
            try {
                lock.lock();
                while (state != 3) {
                    condition.await();
                }
                printFizz.run();
                state = -1;
                condition.signalAll();
            } finally {
                lock.unlock();
            }

        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        //打印5的倍数
        for (int i = 5; i <= n; i += 5) {
            if (i % 15 == 0) {//15的倍数不处理
                continue;
            }
            lock.lock();
            while (state != 5) {
                condition.await();
            }
            printBuzz.run();
            state = -1;
            condition.signalAll();
            lock.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        //打印5的倍数
        for (int i = 15; i <= n; i += 15) {
            lock.lock();
            while (state != 15) {
                condition.await();
            }
            printFizzBuzz.run();
            state = -1;
            condition.signalAll();
            lock.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; ++i) {
            lock.lock();
            while (state != -1) {
                condition.await();
            }

            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
            } else {
                if (i % 15 == 0) {
                    state = 15;
                }
                //交给fizzbuzz()方法处理
                else if (i % 5 == 0) {
                    state = 5;
                }
                //交给buzz()方法处理
                else {
                    state = 3;
                }
                //交给fizz()方法处理

                condition.signalAll();
            }
            lock.unlock();
        }

    }
}