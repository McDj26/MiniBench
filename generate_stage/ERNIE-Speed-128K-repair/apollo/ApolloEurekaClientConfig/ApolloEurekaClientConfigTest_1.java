package com.ctrip.framework.apollo.biz.eureka;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

public class ApolloEurekaClientConfigTest {
    
    @Test
    public void getEurekaServerServiceUrlsTest() {
        // Mock the BizConfig object and its eurekaServiceUrls method
        BizConfig mockBizConfig = Mockito.mock(BizConfig.class);
        when(mockBizConfig.eurekaServiceUrls()).thenReturn(Arrays.asList("http://test-url1", "http://test-url2")); // Mock the return value of eurekaServiceUrls
        
        // Create an instance of ApolloEurekaClientConfig using the mocked BizConfig
        ApolloEurekaClientConfig config = new ApolloEurekaClientConfig(mockBizConfig, null); // Assuming RefreshScope is not necessary for this test
        
        // Test getEurekaServerServiceUrls with a zone value (e.g., "defaultZone")
        List<String> result = config.getEurekaServerServiceUrls("defaultZone");
        assertNotNull(result); // Assert that the result is not null
        assertEquals(2, result.size()); // Assert that the result list has two elements
        assertTrue(result.containsAll(Arrays.asList("http://test-url1", "http://test-url2"))); // Assert that the result contains the expected URLs
        
        // Now test the scenario where bizConfig's eurekaServiceUrls is empty
        when(mockBizConfig.eurekaServiceUrls()).thenReturn(Arrays.asList()); // Mock an empty list for eurekaServiceUrls
        result = config.getEurekaServerServiceUrls("defaultZone"); // Call the method again with the same zone value
        assertNotNull(result); // Assert that the result is not null even when eurekaServiceUrls is empty
        assertTrue(result.isEmpty()); // Assert that the result list is empty since eurekaServiceUrls is empty
    }
}