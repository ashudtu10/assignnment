/**
 * Producer Consumer problem solution using threads
 */

import java.util.*;

public class ProducerConsumerModelCode {
    public static void main(String[] args) throws InterruptedException
    {
        final ProducerConsumer producerConsumer = new ProducerConsumer();

        // producer thread
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    producerConsumer.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create consumer thread
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    producerConsumer.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producerThread.start();
        consumerThread.start();
        producerThread.join();
        consumerThread.join();
    }

    public static class ProducerConsumer {
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 5;

        public void produce() throws InterruptedException
        {
            int value = 0;
            while (true) {
                synchronized (this)
                {
                    while (list.size() == capacity)
                        wait();
                    System.out.println("Producer produced-" + value);
                    list.add(value++);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException
        {
            while (true) {
                synchronized (this)
                {
                    while (list.size() == 0)
                        wait();

                    int value = list.removeFirst();

                    System.out.println("Consumer consumed-" + value);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
    }
}
