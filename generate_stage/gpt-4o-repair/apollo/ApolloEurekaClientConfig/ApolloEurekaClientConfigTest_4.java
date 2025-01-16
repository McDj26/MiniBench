package com.ctrip.framework.apollo.biz.eureka;

import com.ctrip.framework.apollo.biz.config.BizConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cloud.context.scope.refresh.RefreshScope;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ApolloEurekaClientConfigTest {

    private BizConfig bizConfig;
    private RefreshScope refreshScope;
    private ApolloEurekaClientConfig apolloEurekaClientConfig;

    @BeforeEach
    public void setUp() {
        bizConfig = Mockito.mock(BizConfig.class);
        refreshScope = Mockito.mock(RefreshScope.class);
        apolloEurekaClientConfig = new ApolloEurekaClientConfig(bizConfig, refreshScope);
    }

    @Test
    public void testGetEurekaServerServiceUrlsWithNonEmptyBizConfigUrls() {
        // Arrange
        List<String> configuredUrls = List.of("http://localhost:8761/eureka/");
        when(bizConfig.eurekaServiceUrls()).thenReturn(configuredUrls);

        // Act
        List<String> result = apolloEurekaClientConfig.getEurekaServerServiceUrls("default");

        // Assert
        assertEquals(configuredUrls, result, "The URLs should match the non-empty list from bizConfig");
    }

    @Test
    public void testGetEurekaServerServiceUrlsWithEmptyBizConfigUrls() {
        // Arrange
        when(bizConfig.eurekaServiceUrls()).thenReturn(Collections.emptyList());
        List<String> superUrls = List.of("http://fallback:8761/eureka/");
        Mockito.doReturn(superUrls).when((EurekaClientConfigBean) apolloEurekaClientConfig).getEurekaServerServiceUrls("default");

        // Act
        List<String> result = apolloEurekaClientConfig.getEurekaServerServiceUrls("default");

        // Assert
        assertEquals(superUrls, result, "The URLs should match the list from the superclass method");
    }
}