package com.ctrip.framework.apollo.biz.eureka;

import com.ctrip.framework.apollo.biz.config.BizConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.context.scope.refresh.RefreshScope;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ApolloEurekaClientConfigTest {

    private ApolloEurekaClientConfig apolloEurekaClientConfig;
    private BizConfig bizConfig;
    private RefreshScope refreshScope;

    @BeforeEach
    public void setUp() {
        bizConfig = mock(BizConfig.class);
        refreshScope = new RefreshScope(); // Use a new instance since it's a bean that handles context refreshes
        apolloEurekaClientConfig = new ApolloEurekaClientConfig(bizConfig, refreshScope);
    }

    @Test
    public void getEurekaServerServiceUrlsShouldReturnBizConfigUrlsWhenNotEmpty() {
        // Mock the bizConfig to return specific URLs
        List<String> expectedUrls = Arrays.asList("http://eureka1.com", "http://eureka2.com");
        when(bizConfig.eurekaServiceUrls()).thenReturn(expectedUrls);

        // Call the method under test
        List<String> actualUrls = apolloEurekaClientConfig.getEurekaServerServiceUrls("defaultZone");

        // Verify the results
        assertEquals(expectedUrls, actualUrls);
    }

    @Test
    public void getEurekaServerServiceUrlsShouldReturnSuperUrlsWhenBizConfigUrlsEmpty() {
        // Mock the bizConfig to return an empty list
        when(bizConfig.eurekaServiceUrls()).thenReturn(Collections.emptyList());

        // Call the method under test, which would in turn delegate to the superclass method
        // Since the behavior for the superclass's getEurekaServerServiceUrls isn't defined here,
        // you would typically mock the superclass's behavior or confirm its default behavior.
        List<String> superUrls = Arrays.asList("http://default-eureka1.com", "http://default-eureka2.com");
        // Assume this calls the superclass's method and returns default values
        when(apolloEurekaClientConfig.getEurekaServerServiceUrlsFromSuper("defaultZone")).thenReturn(superUrls);

        List<String> actualUrls = apolloEurekaClientConfig.getEurekaServerServiceUrls("defaultZone");

        // Verify the results
        assertEquals(superUrls, actualUrls);
    }

    // Mock method to simulate getting URLs from the superclass
    // This is for illustration; in practice, handle this appropriately
    private void when(List<String> eurekaServerServiceUrlsFromSuper) {
    }
}