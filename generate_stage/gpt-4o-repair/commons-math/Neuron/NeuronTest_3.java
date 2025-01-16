package org.apache.commons.math4.neuralnet;

import org.apache.commons.numbers.core.Precision;
import org.apache.commons.math4.neuralnet.internal.NeuralNetException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NeuronTest {

    private Neuron neuron;
    private final long identifier = 1L;
    private final double[] features = {1.0, 2.0, 3.0};

    @BeforeEach
    public void setUp() {
        neuron = new Neuron(identifier, features);
    }

    @Test
    public void containSameValuesTest() {
        double[] current = {1.0, 2.0, 3.0};
        double[] expect = {1.0, 2.0, 3.0};

        assertTrue(invokeContainSameValues(current, expect), 
                   "Should return true for arrays with the same values");

        double[] different = {1.0, 2.0, 4.0};
        assertFalse(invokeContainSameValues(current, different), 
                    "Should return false for arrays with different values");

        assertThrows(NeuralNetException.class, () -> {
            double[] differentSize = {1.0, 2.0};
            invokeContainSameValues(current, differentSize);
        }, "Should throw exception when array sizes do not match neuron size");
    }

    private boolean invokeContainSameValues(double[] current, double[] expect) {
        try {
            var method = Neuron.class.getDeclaredMethod("containSameValues", double[].class, double[].class);
            method.setAccessible(true);
            return (boolean) method.invoke(neuron, current, expect);
        } catch (Exception e) {
            throw new RuntimeException("Could not invoke method", e);
        }
    }
}