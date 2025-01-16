package org.jctools.queues;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.jctools.util.UnsafeAccess.*;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class BaseLinkedQueuePad0Test {
    private static final int NUM_ELEMENTS = 10;
    private static final int MAX_SIZE = 100;
    private static final int COUNT_DOWN_LATCH_COUNT = 5; // number of threads to start producer and consumer threads
    private static final int TEST_ITERATIONS = 10; // number of times to run test with different scenarios
    private static final Object PADDING = new Object(); // for safety reason to ensure that fields are not optimized away by JVM
    private static final int VALUE_TO_CHECK = 42; // value to check in the queue
    private static final int VALUE_TO_CHECK_BEFORE = VALUE_TO_CHECK - 1; // value before the actual one to check for race condition
    private static final AtomicReference<LinkedQueueNode<Integer>> producerNodeRef = new AtomicReference<>(); // for producer node reference
    private static AtomicReference<LinkedQueueNode<Integer>> consumerNodeRef = new AtomicReference<>(); // for consumer node reference
    private static volatile boolean testRunning = true; // flag to control test termination
    private static CountDownLatch latch = new CountDownLatch(COUNT_DOWN_LATCH_COUNT); // latch to synchronize test start
    private BaseLinkedQueue<Integer> queue; // queue instance to test
    private LinkedQueueNode<Integer> producerNode, consumerNode; // references to producer and consumer nodes for assertions
    private Field fieldProducerNode, fieldConsumerNode; // fields to get producer and consumer nodes reflection

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        queue = new BaseLinkedQueue<>(); // initialize queue instance to test
        fieldProducerNode = BaseLinkedQueueProducerNodeRef.class.getDeclaredField("producerNode"); // get producer node field reflection
        fieldConsumerNode = BaseLinkedQueueConsumerNodeRef.class.getDeclaredField("consumerNode"); // get consumer node field reflection
        fieldProducerNode.setAccessible(true); // make fields accessible for assertions later on
        fieldConsumerNode.setAccessible(true); // make fields accessible for assertions later on
        producerNodeRef.set(null); // set producer node reference initially to null for consistency check later on assertions
        consumerNodeRef.set(null); // set consumer node reference initially to null for consistency check later on assertions
        queueStartedThread(Runnable::new); // start queue initialization thread before the test start, via a thread safe way (using latch)
        latch.await(); // wait for the queue initialization thread to complete and have the queue instance ready for testing
        producerNode = (LinkedQueueNode<Integer>) fieldProducerNode.get(queue); // get producer node reference from reflection for assertions later on
        consumerNode = (LinkedQueueNode<Integer>) fieldConsumerNode.get(queue); // get consumer node reference from reflection for assertions later on
        assertNotNull(queue); // ensure queue instance is not null before starting test
        assertNotNull(fieldProducerNode); // ensure producer node field is not null before starting test assertions on it later on in test execution time (avoid race condition)
        assertNotNull(fieldConsumerNode); // ensure consumer node field is not null before starting test assertions on it later on in test execution time (avoid race condition)
        Thread testThread = new Thread(() -> { // create a thread to run the actual test in parallel with other threads for consistency checking of data in between (simulate real concurrent environment)
            for (int i = 0; i < TEST_ITERATIONS && testRunning; i++) { // loop through iterations to simulate multiple runs of tests with different scenarios and different conditions that may affect results and validity of data being checked (to simulate real concurrent environment)
                try { // try block to catch any exceptions that may occur during test execution (e.g., race condition) and handle them accordingly (e.g., retry or continue with next iteration)
                    int size = queue.size(); // get the size of the queue as reported by method we are testing in this case (sizeTest method) to assert against it later on in the test execution time (avoid race condition)
                    assertEquals(NUM_ELEMENTS, size); // assert expected size against reported size to check whether they match as expected in terms of what method size returns when used in real concurrent environment with multiple threads accessing it at the same time (race condition may affect results and validity of data being checked) 原始大小必须匹配测试开始