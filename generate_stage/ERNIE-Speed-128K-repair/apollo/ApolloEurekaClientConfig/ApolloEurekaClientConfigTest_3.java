package com.ctrip.framework.apollo.biz.eureka;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

public class ApolloEurekaClientConfigTest {
    @Mock
    private BizConfig bizConfigMock;
    @Mock
    private RefreshScope refreshScopeMock;
    @InjectMocks
    private ApolloEurekaClientConfig apolloEurekaClientConfig;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(bizConfigMock.eurekaServiceUrls()).thenReturn(Arrays.asList("http://localhost:8761/eureka")); // Assuming this is a valid URL for Eureka server service
    }

    @Test
    public void getEurekaServerServiceUrlsTest() {
        // Test when the list of URLs is not empty
        List<String> urls = apolloEurekaClientConfig.getEurekaServerServiceUrls("defaultZone"); // Assuming "defaultZone" is the correct zone name to use for this test case
        assertNotNull(urls); // Assert that the list is not null
        assertFalse(urls.isEmpty()); // Assert that the list is not empty
        assertEquals("http://localhost:8761/eureka", urls.get(0)); // Assert that the first URL is correct as provided by the mock business config object
        assertEquals("defaultZone", urls); // Assert that the zone name is correctly passed back as part of the result list (should be checked if this is indeed the correct behavior)
        verify(bizConfigMock).eurekaServiceUrls(); // Verify that the mocked business config object's method was called to retrieve the URLs
        verifyNoMoreInteractions(bizConfigMock); // Verify that no other interactions occurred with the mocked business config object that were not part of this test case (optional)
        // Test when the list of URLs is empty (using the super implementation) - This part is not shown in your provided code snippet, so I'll assume some logic for demonstration purposes
        when(bizConfigMock.eurekaServiceUrls()).thenReturn(Collections.<String>emptyList()); // Assume this as an empty list of URLs for demonstration purposes
        List<String> emptyUrls = apolloEurekaClientConfig.<String>getEurekaServerServiceUrls("fallbackZone"); // Assume there is a fallback zone scenario or default logic in super implementation
        assertNotNull(emptyUrls); // Assert that even in case of empty URLs from business config, there is still a result returned from super implementation or other fallback logic 
        assertTrue(emptyUrls.isEmpty()); // Assert that indeed the list is empty as expected due to the mocked behavior of bizConfigMock above
        // Additional assertions could be done if more specific behaviors are known about how super implementation handles empty URLs scenario 
    }  // End of getEurekaServerServiceUrlsTest method 
}  // End of ApolloEurekaClientConfigTest class