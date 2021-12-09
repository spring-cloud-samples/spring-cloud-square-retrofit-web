package demo.config;

import okhttp3.OkHttpClient;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Olga Maciaszek-Sharma
 */
@Configuration
public class WebClientConfig {

	@Bean
	@LoadBalanced
	public OkHttpClient.Builder builder() {
		return new OkHttpClient.Builder();
	}

}
