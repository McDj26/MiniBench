package com.ctrip.framework.apollo.biz.eureka;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ApolloEurekaClientConfigTest {
    @InjectMocks
    private ApolloEurekaClientConfig apolloEurekaClientConfig; // Instance to be tested
    @Mock
    private BizConfig bizConfigMock; // Mock the dependency injection of BizConfig
    @Mock
    private RefreshScope refreshScopeMock; // Mock the dependency injection of RefreshScope
    private List<String> serviceUrls; // List to hold the service URLs for testing purposes

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks before each test case
        serviceUrls = Arrays.asList("http://localhost:8761/eureka"); // Mock the list of service URLs fetched from BizConfig
        when(bizConfigMock.eurekaServiceUrls()).thenReturn(serviceUrls); // Configure mock behavior when eurekaServiceUrls is called on bizConfigMock
    }

    @Test
    public void getEurekaServerServiceUrlsTest() {
        String myZone = "defaultZone"; // The zone you want to test against (should be the default zone)
        List<String> expectedUrls = serviceUrls; // Initialize expected URLs from mock data or actual data if necessary
        List<String> actualUrls = apolloEurekaClientConfig.getEurekaServerServiceUrls(myZone); // Call the method to test
        assertNotNull(actualUrls); // Assert that the returned list is not null
        assertEquals(expectedUrls, actualUrls); // Assert that the returned list of URLs matches the expected list of URLs from the mock or actual data source
    }
}