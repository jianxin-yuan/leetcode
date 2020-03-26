package thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/fizz-buzz-multithreaded/comments/154469
 */
public class FizzBuzzForSemaphore {

    private int n;
    private int i;
    private Semaphore semaphore = new Semaphore(1);

    public FizzBuzzForSemaphore(int n) {
        this.n = n;
        this.i = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            try {
                semaphore.acquire();
                if (i > n) {
                    return;
                }

                if (i % 3 == 0 && i % 5 != 0) {
                    printFizz.run();
                    i++;
                }
            } finally {
                semaphore.release();
            }
        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            try {
                semaphore.acquire();
                if (i > n) {
                    return;
                }

                if (i % 3 != 0 && i % 5 == 0) {
                    printBuzz.run();
                    i++;
                }
            } finally {
                semaphore.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            try {
                semaphore.acquire();
                if (i > n) {
                    return;
                }

                if (i % 3 == 0 && i % 5 == 0) {
                    printFizzBuzz.run();
                    i++;
                }
            } finally {
                semaphore.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            try {
                semaphore.acquire();
                if (i > n) {
                    return;
                }

                if (i % 3 != 0 && i % 5 != 0) {
                    printNumber.accept(i);
                    i++;
                }
            } finally {
                semaphore.release();
            }
        }
    }
}