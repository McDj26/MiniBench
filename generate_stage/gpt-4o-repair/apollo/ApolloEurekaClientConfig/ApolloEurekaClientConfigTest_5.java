package com.ctrip.framework.apollo.biz.eureka;

import com.ctrip.framework.apollo.biz.config.BizConfig;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.context.scope.refresh.RefreshScope;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ApolloEurekaClientConfigTest {

    @Test
    public void getEurekaServerServiceUrlsTest() {
        // Arrange
        BizConfig mockBizConfig = mock(BizConfig.class);
        RefreshScope mockRefreshScope = mock(RefreshScope.class);
        ApolloEurekaClientConfig eurekaClientConfig = new ApolloEurekaClientConfig(mockBizConfig, mockRefreshScope);
        String testZone = "defaultZone";

        // Case 1: BizConfig provides URLs
        List<String> fakeUrls = List.of("http://eureka1:8761/eureka", "http://eureka2:8761/eureka");
        when(mockBizConfig.eurekaServiceUrls()).thenReturn(fakeUrls);

        // Act
        List<String> resultUrls = eurekaClientConfig.getEurekaServerServiceUrls(testZone);

        // Assert
        assertNotNull(resultUrls);
        assertFalse(resultUrls.isEmpty());
        assertEquals(fakeUrls, resultUrls);

        // Case 2: BizConfig does not provide URLs, fallback to super implementation
        when(mockBizConfig.eurekaServiceUrls()).thenReturn(Collections.emptyList());

        // Mocking the super call
        ApolloEurekaClientConfig spyEurekaClientConfig = spy(eurekaClientConfig);
        List<String> defaultUrls = List.of("http://default-eureka:8761/eureka");
        doReturn(defaultUrls).when(spyEurekaClientConfig).getEurekaServerServiceUrls(testZone);
        
        // Act
        resultUrls = spyEurekaClientConfig.getEurekaServerServiceUrls(testZone);
        
        // Assert
        assertNotNull(resultUrls);
        assertFalse(resultUrls.isEmpty());
        assertEquals(defaultUrls, resultUrls);
    }
}