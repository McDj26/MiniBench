package org.apache.commons.math4.neuralnet;

import org.apache.commons.numbers.core.Precision;
import org.apache.commons.math4.neuralnet.internal.NeuralNetException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NeuronTest {
    
    private boolean reflectContainSameValues(double[] current, double[] expect, Neuron neuron) {
        try {
            java.lang.reflect.Method method = Neuron.class.getDeclaredMethod("containSameValues", double[].class, double[].class);
            method.setAccessible(true);
            return (boolean) method.invoke(neuron, current, expect);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void containSameValuesTest() {
        long identifier = 1L;
        double[] features = {1.0, 2.0, 3.0};
        Neuron neuron = new Neuron(identifier, features);

        // Case 1: Same values
        double[] currentSame = {1.0, 2.0, 3.0};
        double[] expectSame = {1.0, 2.0, 3.0};
        assertTrue(reflectContainSameValues(currentSame, expectSame, neuron), "Arrays should be equal.");

        // Case 2: Different values
        double[] currentDiff = {1.0, 2.1, 3.0};
        double[] expectDiff = {1.0, 2.0, 3.0};
        assertFalse(reflectContainSameValues(currentDiff, expectDiff, neuron), "Arrays should not be equal.");

        // Case 3: Different lengths
        double[] currentDiffLen = {1.0, 2.0};
        // Exception is expected since we simulate calling an internal method directly
        NeuralNetException exception = assertThrows(NeuralNetException.class, () -> 
            reflectContainSameValues(currentDiffLen, expectSame, neuron)
        );
        assertEquals(exception.getType(), NeuralNetException.SIZE_MISMATCH);
    }
}