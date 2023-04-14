/***
 * We can implement Stack by using two and single queue.
 * For our purposes, we can solve it using single queue
 */

import java.util.*;

public class StackUsingQueueCode {

    Queue<Integer> queue = new LinkedList<Integer>();

    void push(int x) {
        int queue_size = queue.size();
        queue.add(x);

        for (int i = 0; i < queue_size; i++) {
            queue.add(queue.remove());
        }
    }

    void pop() {
        if (queue.isEmpty())
            return;
        queue.remove();
    }

    int top() {
        if (queue.isEmpty())
            return -1;
        return queue.peek();
    }

    int size() {
        return queue.size();
    }
}

/**
 * Algorithm:
 * 1. We take a single queue and add the first element to it
 * 2. Everytime we add an element, we pop all the present elements in the queue and put them back inside
 * 3. This keeps the latest element at the front of the queue and pop works in O(1)
 * 4. However push operation is costly and takes O(n) time
 */