package org.apache.commons.math4.neuralnet;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NeuronTest {

    @Test
    public void containSameValuesTest() {
        // Initialize Neuron instance and create arrays with some values
        double[] featureValues = {0.1, 0.2, 0.3}; // Assuming size of Neuron is 3
        Neuron neuron = new Neuron(1L, featureValues); // Assuming the size is inferred from the array length
        double[] currentValues = new double[featureValues.length]; // Create current values array
        double[] expectedValues = new double[featureValues.length]; // Create expected values array
        System.arraycopy(featureValues, 0, currentValues, 0, featureValues.length); // Copy values to current array
        System.arraycopy(featureValues, 0, expectedValues, 0, featureValues.length); // Copy values to expected array
        // Test with same values
        assertTrue(neuron.containSameValues(currentValues, expectedValues), "Same values should return true");
        // Change some values in expected array and retest
        expectedValues[1] = 0.5; // Change a value in expected array
        assertFalse(neuron.containSameValues(currentValues, expectedValues), "Different values should return false");
        // Test with different size arrays
        double[] wrongSizeExpected = new double[featureValues.length + 1]; // Wrong size array
        assertThrows(NeuralNetException.class, () -> neuron.containSameValues(currentValues, wrongSizeExpected), "Should throw an exception for wrong size arrays");
    }
}