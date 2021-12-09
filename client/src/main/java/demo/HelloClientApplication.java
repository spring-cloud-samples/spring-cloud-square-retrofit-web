package demo;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.http.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.square.retrofit.EnableRetrofitClients;
import org.springframework.cloud.square.retrofit.core.RetrofitClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Olga Maciaszek-Sharma
 */
@SpringBootApplication
@RestController
@EnableRetrofitClients
public class HelloClientApplication {

	@Autowired
	HelloClient client;

	public static void main(String[] args) {
		SpringApplication.run(HelloClientApplication.class, args);
	}

	@GetMapping("/")
	public String hello() throws IOException {
		return client.hello().execute().body();
	}

	@RetrofitClient("HelloServer")
	interface HelloClient {
		@GET("/")
		Call<String> hello();
	}
}
