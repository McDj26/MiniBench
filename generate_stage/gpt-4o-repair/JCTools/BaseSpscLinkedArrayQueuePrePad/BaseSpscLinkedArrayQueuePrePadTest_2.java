package org.jctools.queues;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

public class BaseSpscLinkedArrayQueuePrePadTest {

    @Test
    public void offerTest() {
        // Create a mock of the derived class of BaseSpscLinkedArrayQueue for testing
        BaseSpscLinkedArrayQueue<Integer> queue = Mockito.mock(BaseSpscLinkedArrayQueue.class, Mockito.CALLS_REAL_METHODS);

        // Initialize necessary fields, assuming setters are available or fields are directly accessible for testing
        queue.producerBuffer = (Integer[]) new Integer[10];
        queue.producerMask = 9; // assuming buffer size of 10
        queue.producerBufferLimit = 8; // some arbitrary buffer limit
        queue.soProducerIndex(0); // start at index 0

        // Test offering a non-null element should return true
        boolean result = queue.offer(5);
        assertTrue(result);

        // Test offering a null element should throw NullPointerException
        assertThrows(NullPointerException.class, () -> {
            queue.offer(null);
        });

        // Test when producerBufferLimit is reached
        queue.producerBufferLimit = 0; // set buffer limit to 0 to force cold path
        result = queue.offer(10); // this should call offerColdPath
        // Add a stub to the mock to test interaction and return value for offerColdPath
        Mockito.when(queue.offerColdPath(Mockito.any(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.any(), Mockito.any())).thenReturn(false);
        result = queue.offer(10);
        assertFalse(result);
        // Verify that offerColdPath was indeed called
        Mockito.verify(queue).offerColdPath(Mockito.any(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.any(), Mockito.any());
    }
}