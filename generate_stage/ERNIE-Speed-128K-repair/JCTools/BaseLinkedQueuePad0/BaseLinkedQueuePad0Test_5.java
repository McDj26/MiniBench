package org.jctools.queues;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.jctools.util.UnsafeAccess.*;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class BaseLinkedQueuePad0Test {
    private static final int NUMBER_OF_ELEMENTS = 10;
    private static final int MAX_SIZE = Integer.MAX_VALUE;
    private static final int NO_LIMIT = -1;
    private static final long NANOS_BETWEEN_FILLING = 1L; // time between adding elements in nanoseconds
    private static final long MAX_TIME_IN_MILLIS = TimeUnit.SECONDS.toNanos(1); // Max time for a test method in nanos
    private volatile boolean stopping = false; // To stop filling the queue in the separate thread
    private static final ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>(); // utility queue to get more than 2 pointers to complete tests properly on various hardware and JVMs
    private static BaseLinkedQueue<Integer> queueUnderTest; // the queue to test size method
    private static LinkedQueueNode<Integer> producerNode; // to test lvProducerNode method in size method (when racing with producer)
    private static LinkedQueueNode<Integer> consumerNode; // to test lvConsumerNode method in size method (when racing with consumer)
    private final AtomicLong count = new AtomicLong(); // used to track how many elements were added to the queue in the separate thread filling it with elements
    private volatile boolean threadFinished = false; // signal that filling thread has finished execution and we can check results
    private static final Field P_NODE_FIELD = findField(BaseLinkedQueueProducerNodeRef.class, "producerNode"); // producer node field reflection for setting it to test lvProducerNode method in size method
    private static final Field C_NODE_FIELD = findField(BaseLinkedQueueConsumerNodeRef.class, "consumerNode"); // consumer node field reflection for setting it to test lvConsumerNode method in size method
    private static volatile int countOnWorkerThread = 0; // used to check if worker thread has finished its job (to avoid blocking indefinitely) when the main thread waits for its results after test has already failed due to a different reason
    private static final int MAX_COUNT_ON_WORKER_THREAD = 5000; // if the worker thread reaches this count then it knows that there's no reason for blocking anymore since we've already failed the test and this is just to avoid infinite loop
    private static volatile boolean producerFinished = false; // to indicate that producer thread has finished adding items into the queue in a test that runs multiple threads filling the queue concurrently
    private static volatile boolean consumerFinished = false; // to indicate that consumer thread has finished processing items from the queue in a test that runs multiple threads filling the queue concurrently and checking size() during processing
    static class SizeTesterThread extends Thread { // A separate thread used to fill the queue with elements while testing size method
        final int limit; // limit of elements to add or -1 for no limit
        final long nanosBetweenFilling; // time between adding elements in nanoseconds or 0 for no delay (only used when limit is set)
        final Random random; // used to add a delay after each addition of element so we do not fill all cores if all tests run in parallel (delay value varies)
        SizeTesterThread(int limit, long nanosBetweenFilling) { // constructor initialization of fields
            this.limit = limit; this.nanosBetweenFilling = nanosBetweenFilling; this.random = new Random(); // initialise fields of the thread instance (using random to avoid core saturation)
        } // thread entry point that starts execution of the thread (the actual implementation of the thread logic)
        public void run() {
            int cntAddedThisRun = 0; // counter for current run of filling process to avoid concurrent access to count variable of the main test class that might lead to inaccurate count (with threading) when other threads change state during a read attempt on shared variable without proper synchronization which could result in a test failure due to wrong results reported by count field on shared memory if no synchronization exists during access of that shared variable between threads from multiple CPUs where CPUs have their own caches that do not get updated by other CPUs immediately after a write operation on shared memory by another CPU which could result in reading old value from memory cache of another CPU after it has been updated by another thread running on a different CPU core) NOTE: all these problems are due to lack of proper synchronization which can be achieved by using atomic variables or locks but here we are using