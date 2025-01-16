package org.apache.commons.math4.neuralnet;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.apache.commons.math4.neuralnet.Precision.*;

public class NeuronTest {
    @Test
    public void containSameValuesTest() {
        double[] features1 = {1.0, 2.0, 3.0}; // sample feature array 1
        double[] features2 = {1.0, 2.0, 3.0}; // similar feature array
        double[] features3 = {1.5, 2.5, 3.5}; // different feature array with same length
        double epsilon = 0.0001; // small epsilon to compare values due to floating point errors
        
        Neuron neuron = new Neuron(1L, features1); // initialize with size matching features array length
        
        // Test case for same values in arrays
        assertTrue(neuron.containSameValues(features2));
        // Test case for different values in arrays but same length
        assertThrows(NeuralNetException.class, () -> neuron.containSameValues(features3)); // should throw exception due to size mismatch
        
        // Testing using equalsEpsilon to compare floating point numbers within epsilon range
        for (int i = 0; i < features1.length; i++) {
            assertEqualsEpsilon(features1[i], features2[i], epsilon); // should pass since arrays are similar
            assertNotEqualsEpsilon(features1[i], features3[i], epsilon); // should pass since arrays are different at this index
        }
    }
}