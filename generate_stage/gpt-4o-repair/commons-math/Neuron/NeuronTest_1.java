package org.apache.commons.math4.neuralnet;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NeuronTest {

    private Neuron neuron;
    private final double[] initialFeatures = {1.0, 2.0, 3.0};
    private final double[] sameFeatures = {1.0, 2.0, 3.0};
    private final double[] differentFeatures = {3.0, 2.0, 1.0};
    private final double[] differentSizeFeatures = {1.0, 2.0};

    @BeforeEach
    public void setUp() {
        neuron = new Neuron(1L, initialFeatures);
    }

    @Test
    public void containSameValuesTest() {
        // Test when both arrays are the same
        boolean result = neuron.containSameValues(initialFeatures, sameFeatures);
        assertTrue(result, "Arrays with the same content should return true.");

        // Test when arrays have different content
        result = neuron.containSameValues(initialFeatures, differentFeatures);
        assertFalse(result, "Arrays with different content should return false.");

        // Test when array sizes mismatch, expecting an exception
        Exception exception = assertThrows(NeuralNetException.class, () -> {
            neuron.containSameValues(initialFeatures, differentSizeFeatures);
        });
        assertEquals(NeuralNetException.SIZE_MISMATCH, exception.getMessage());
    }
}