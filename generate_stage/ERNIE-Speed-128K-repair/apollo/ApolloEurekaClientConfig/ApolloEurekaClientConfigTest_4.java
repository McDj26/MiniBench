package com.ctrip.framework.apollo.biz.eureka;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class ApolloEurekaClientConfigTest {
    @Mock
    private BizConfig bizConfig;
    @Mock
    private RefreshScope refreshScope;
    @InjectMocks
    private ApolloEurekaClientConfig apolloEurekaClientConfig;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(bizConfig.eurekaServiceUrls()).thenReturn(Arrays.asList("http://localhost:8080")); // Mock the behavior of bizConfig to return a list of URLs
    }

    @Test
    public void getEurekaServerServiceUrlsTest() {
        // Given business configuration with non-empty Eureka service URLs
        List<String> expectedUrls = Arrays.asList("http://localhost:8080"); // Define the expected result
        String myZone = "defaultZone"; // Define the zone to test with
        List<String> actualUrls = apolloEurekaClientConfig.getEurekaServerServiceUrls(myZone); // Call the method to test
        assertNotNull(actualUrls); // Assert that the returned list is not null
        assertEquals(expectedUrls, actualUrls); // Assert that the returned list is equal to the expected list of URLs from bizConfig
    }
}

// Additional test case for when the `bizConfig` returns an empty list of URLs, which should result in calling the superclass's method
@Test
public void getEurekaServerServiceUrlsEmptyTest() {
    // Given business configuration with empty Eureka service URLs (or no service URLs at all) 
    when(bizConfig.eurekaServiceUrls()).thenReturn(Arrays.<String>asList()); // Mock the behavior of bizConfig to return an empty list of URLs or null (if applicable)
    String myZone = "defaultZone"; // Define the zone to test with when bizConfig returns empty list of URLs or null 
    List<String> actualUrls = apolloEurekaClientConfig.getEurekaServerServiceUrls(myZone); // Call the method to test when bizConfig returns empty list of URLs or null 
    assertNotNull(actualUrls); // Assert that the returned list is not null, since we expect the superclass's method to be called in this case (resulting in non-empty list) 
    // You can add additional assertions here to verify the content of actualUrls if necessary (e.g., if you know what urls are expected from the superclass implementation) 
}