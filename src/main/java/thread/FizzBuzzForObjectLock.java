package thread;

import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/fizz-buzz-multithreaded/comments/154469
 */
public class FizzBuzzForObjectLock {

    private int n;
    private int i;
    private final Object lock = new Object();

    public FizzBuzzForObjectLock(int n) {
        this.n = n;
        this.i = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n) {
            synchronized (lock) {
                if (i % 3 == 0 && i % 5 != 0) {
                    printFizz.run();
                    i++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n) {
            synchronized (lock) {
                if (i % 3 != 0 && i % 5 == 0) {
                    printBuzz.run();
                    i++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i <= n) {
            synchronized (lock) {
                if (i % 3 == 0 && i % 5 == 0) {
                    printFizzBuzz.run();
                    i++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            synchronized (lock) {
                if (i % 3 != 0 && i % 5 != 0) {
                    printNumber.accept(i);
                    i++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }
}