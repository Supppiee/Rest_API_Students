package sup.realtions.mapping.M_Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class S_Security {

	public SecurityFilterChain securityFIlterChain(HttpSecurity http) throws Exception {
		http.csrf(Customizer -> Customizer.disable());
		http.authorizeHttpRequests(requests -> requests.anyRequest().authenticated());
		http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());
		return http.build();
	}
}
