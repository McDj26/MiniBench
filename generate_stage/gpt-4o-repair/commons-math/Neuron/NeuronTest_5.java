package org.apache.commons.math4.neuralnet;

import org.apache.commons.numbers.core.Precision;
import org.apache.commons.math4.neuralnet.internal.NeuralNetException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NeuronTest {
    
    private class TestNeuron extends Neuron {
        TestNeuron() {
            super(1L, new double[]{1.0, 2.0, 3.0});
        }
        
        public boolean testContainSameValues(double[] current, double[] expect) {
            return containSameValues(current, expect);
        }
    }
    
    @Test
    public void containSameValuesTest() {
        TestNeuron neuron = new TestNeuron();
        double[] current1 = {1.0, 2.0, 3.0};
        double[] expect1 = {1.0, 2.0, 3.0};
        double[] expect2 = {1.0, 2.0, 3.1};
        double[] expect3 = {1.0, 2.0}; // mismatch in length

        // Test same values, same length
        assertTrue(neuron.testContainSameValues(current1, expect1), "Arrays with same values should return true.");

        // Test different values, same length
        assertFalse(neuron.testContainSameValues(current1, expect2), "Arrays with different values should return false.");

        // Test length mismatch
        Exception exception = assertThrows(NeuralNetException.class, () -> {
            neuron.testContainSameValues(current1, expect3);
        });
        
        assertEquals(NeuralNetException.SIZE_MISMATCH, exception.getMessage(), "Expected SIZE_MISMATCH exception when array lengths differ.");
    }
}