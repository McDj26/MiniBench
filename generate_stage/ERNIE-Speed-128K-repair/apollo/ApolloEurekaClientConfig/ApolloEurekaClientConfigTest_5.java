package com.ctrip.framework.apollo.biz.eureka;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ApolloEurekaClientConfigTest {
    private ApolloEurekaClientConfig config; // The instance of ApolloEurekaClientConfig to be tested
    private BizConfig bizConfigMock; // Mock object for BizConfig
    private RefreshScope refreshScopeMock; // Mock object for RefreshScope
    private final String myZone = "defaultZone"; // The zone to be tested
    private List<String> expectedUrls = Arrays.asList("http://localhost:8761/eureka/"); // Mocked Eureka server URLs

    @BeforeEach
    public void setUp() {
        bizConfigMock = mock(BizConfig.class); // Create a mock object for BizConfig
        refreshScopeMock = mock(RefreshScope.class); // Create a mock object for RefreshScope
        config = new ApolloEurekaClientConfig(bizConfigMock, refreshScopeMock); // Initialize the config with mocks
        when(bizConfigMock.eurekaServiceUrls()).thenReturn(expectedUrls); // Mock the behavior of bizConfig for eurekaServiceUrls()
    }

    @Test
    public void getEurekaServerServiceUrlsTest() {
        // Assert that the urls returned by getEurekaServerServiceUrls are correct when bizConfig has urls
        List<String> actualUrls = config.getEurekaServerServiceUrls(myZone); // Call the method to test
        assertNotNull(actualUrls); // Assert that the returned list is not null
        assertEquals(expectedUrls, actualUrls); // Assert that the returned list is the same as the expected list of mocked URLs
        verify(bizConfigMock).eurekaServiceUrls(); // Verify that the mocked behavior of bizConfig was called correctly for eurekaServiceUrls()
    }

    // Add another test case to cover the scenario when bizConfig does not have any urls
    @Test
    public void getEurekaServerServiceUrlsWithNoUrlsInBizConfigTest() {
        // Assume there are no urls in bizConfig, so we need to mock bizConfig to return an empty list or null
        when(bizConfigMock.eurekaServiceUrls()).thenReturn(null); // Mock the behavior of bizConfig to return null for eurekaServiceUrls()
        // Call the method to test and assert that it falls back to the super implementation or returns an empty list
        List<String> actualUrls = config.getEurekaServerServiceUrls(myZone); // Call the method to test with no urls in bizConfig
        assertTrue(((actualUrls == null) || actualUrls.isEmpty()), "Expected either an empty list or null, but got " + actualUrls); // Assert that actual result is either null or an empty list as expected
        verify(bizConfigMock).eurekaServiceUrls(); // Verify that the mocked behavior of bizConfig was called correctly for eurekaServiceUrls() in this scenario too
    }
}