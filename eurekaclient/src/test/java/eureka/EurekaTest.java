package eureka;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ly.spring.SpringBootBaseTest;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

public class EurekaTest extends SpringBootBaseTest {
	
	@Autowired
	private EurekaClient discoveryClient;
	
	public String serviceUrl() {
		 InstanceInfo instance = discoveryClient.getNextServerFromEureka("spring-eureka-producer", false);
		 return instance.getHomePageUrl();
	}
	
	@Test
	public void testInstance() {
		System.out.println(serviceUrl());
	}
}
