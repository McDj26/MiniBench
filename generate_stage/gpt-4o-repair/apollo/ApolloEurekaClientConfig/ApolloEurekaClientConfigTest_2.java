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
        // Mocking dependencies
        BizConfig bizConfig = mock(BizConfig.class);
        RefreshScope refreshScope = mock(RefreshScope.class);

        // Creating an instance of the class to test
        ApolloEurekaClientConfig config = new ApolloEurekaClientConfig(bizConfig, refreshScope);

        // Test when bizConfig.eurekaServiceUrls() returns a non-empty list
        List<String> expectedUrls = List.of("http://eureka1.com", "http://eureka2.com");
        when(bizConfig.eurekaServiceUrls()).thenReturn(expectedUrls);

        assertEquals(expectedUrls, config.getEurekaServerServiceUrls("defaultZone"));

        // Test when bizConfig.eurekaServiceUrls() returns an empty list
        when(bizConfig.eurekaServiceUrls()).thenReturn(Collections.emptyList());
        
        // Assuming super.getEurekaServerServiceUrls() returns some default value for testing
        List<String> defaultUrls = List.of("http://default-eureka.com");
        ApolloEurekaClientConfig spyConfig = spy(config);
        doReturn(defaultUrls).when(spyConfig).getEurekaServerServiceUrls(anyString());
        
        assertEquals(defaultUrls, spyConfig.getEurekaServerServiceUrls("defaultZone"));
    }
}