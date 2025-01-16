package com.ctrip.framework.apollo.biz.eureka;

import com.ctrip.framework.apollo.biz.config.BizConfig;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ApolloEurekaClientConfigTest {

    @Test
    public void getEurekaServerServiceUrlsTest() {
        // Mock dependencies
        BizConfig mockBizConfig = Mockito.mock(BizConfig.class);
        RefreshScope mockRefreshScope = Mockito.mock(RefreshScope.class);
        
        // Create instance of ApolloEurekaClientConfig
        ApolloEurekaClientConfig config = new ApolloEurekaClientConfig(mockBizConfig, mockRefreshScope);

        // Test case 1: bizConfig.eurekaServiceUrls() returns a non-empty list
        List<String> expectedUrls = List.of("http://eureka1.example.com", "http://eureka2.example.com");
        when(mockBizConfig.eurekaServiceUrls()).thenReturn(expectedUrls);
        
        List<String> actualUrls = config.getEurekaServerServiceUrls("defaultZone");
        assertEquals(expectedUrls, actualUrls, "URLs from bizConfig should match");

        // Test case 2: bizConfig.eurekaServiceUrls() returns an empty list
        when(mockBizConfig.eurekaServiceUrls()).thenReturn(Collections.emptyList());
        
        // Assuming the superclass's method returns a specific zone URL
        List<String> expectedDefaultUrls = super.getEurekaServerServiceUrls("defaultZone");
        actualUrls = config.getEurekaServerServiceUrls("defaultZone");
        assertEquals(expectedDefaultUrls, actualUrls, "URLs should be obtained from the superclass method when bizConfig returns empty");
    }
}