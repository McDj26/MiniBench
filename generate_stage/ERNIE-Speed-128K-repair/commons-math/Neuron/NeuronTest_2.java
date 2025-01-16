package org.apache.commons.math4.neuralnet;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NeuronTest {
    @Test
    public void containSameValuesTest() {
        double[] features1 = {1.0, 2.0, 3.0};
        double[] features2 = {1.0, 2.0, 3.0};
        double[] features3 = {4.0, 5.0, 6.0}; // Different values
        Neuron neuron = new Neuron(1L, features1); // Assuming size is inferred from features1's length
        
        // Test with same values
        assertTrue(neuron.containSameValues(features2));
        
        // Test with different values
        assertThrows(NeuralNetException.class, () -> {
            neuron.containSameValues(features3); // Should throw an exception because of size mismatch
        });
        
        // Further test cases can include testing with arrays of different lengths to ensure the exception is thrown correctly
    }
}