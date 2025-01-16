package org.apache.commons.math4.neuralnet;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NeuronTest {
    @Test
    public void containSameValuesTest() {
        // Prepare test data
        double[] currentValues = {1.0, 2.0, 3.0};
        double[] expectedValues = {1.5, 2.5, 3.5};
        Neuron neuron = new Neuron(1, currentValues); // Assuming size is set in the constructor
        int size = neuron.getSize(); // Assuming this method returns the size of the Neuron
        try {
            // Test case with matching lengths and values
            assertTrue(neuron.containSameValues(expectedValues, expectedValues));
            // Test case with different values but matching length
            expectedValues[0] = 0.5; // Change the first value to something different
            assertFalse(neuron.containSameValues(currentValues, expectedValues)); // Should return false since values are different
            // Test case with length mismatch (expected length is not equal to size)
            double[] wrongLengthExpectedValues = new double[size + 1]; // Add an extra element to the array
            assertThrows(NeuralNetException.class, () -> neuron.containSameValues(currentValues, wrongLengthExpectedValues)); // Should throw an exception for length mismatch
        } catch (NeuralNetException e) {
            // Handle exception if necessary (e.g., log error message)
            fail("Exception should not be thrown in this test case."); // Fail the test if an exception is thrown unexpectedly
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e); // Fail the test if any other unexpected exception is thrown
        }
    }
}