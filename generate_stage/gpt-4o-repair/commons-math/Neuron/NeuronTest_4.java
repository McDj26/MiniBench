package org.apache.commons.math4.neuralnet;

import org.apache.commons.numbers.core.Precision;
import org.apache.commons.math4.neuralnet.internal.NeuralNetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NeuronTest {
    private Neuron neuron;

    @BeforeEach
    public void setUp() {
        double[] initialFeatures = {1.0, 2.0, 3.0};
        neuron = new Neuron(1L, initialFeatures);
    }

    @Test
    public void containSameValuesTest() {
        // Arrays that should be the same
        double[] current = {1.0, 2.0, 3.0};
        double[] expect = {1.0, 2.0, 3.0};
        assertTrue(neuron.containSameValues(current, expect), "Arrays with same values should return true");

        // Arrays that have different values
        double[] currentDiff = {1.0, 2.0, 4.0};
        assertFalse(neuron.containSameValues(currentDiff, expect), "Arrays with different values should return false");

        // Arrays with different lengths should throw exception
        double[] differentLength = {1.0, 2.0};
        assertThrows(NeuralNetException.class, () -> {
            neuron.containSameValues(current, differentLength);
        }, "Arrays with different lengths should throw NeuralNetException");
        
        // Arrays with acceptable precision differences
        double[] currentPrecision = {1.0, 2.0, 3.0000000001};
        assertTrue(neuron.containSameValues(currentPrecision, expect), "Arrays with nearly equal values should return true");
    }
}