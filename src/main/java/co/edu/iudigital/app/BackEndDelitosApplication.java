package co.edu.iudigital.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableAutoConfiguration
public class BackEndDelitosApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(BackEndDelitosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password = "123456";
		for(int i = 0; i < 3; i++) {
			String encoded = passwordEncoder.encode(password);
			System.out.println(encoded);
		}
	}
	
	

}
