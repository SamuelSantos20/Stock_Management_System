package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import security.CustomSucessHaldler;

@EnableMethodSecurity(securedEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity , AuthenticationProvider authenticationProvider , CustomSucessHaldler sucessHaldler) throws Exception {
		
		httpSecurity.csrf(crf -> crf.disable()).authorizeHttpRequests( http ->{
				
		http.requestMatchers("/index").permitAll()
		.requestMatchers("/login").permitAll()
		.requestMatchers("/loginRequest").permitAll()
		.requestMatchers("/pre/register/user").permitAll()
		.requestMatchers("/register/user").permitAll()
		.requestMatchers("/pre/register/moviment/products").authenticated()
		.requestMatchers("/register/moviment/product").authenticated()
		.requestMatchers("/pre/register/product").authenticated()
		.requestMatchers("/register/product").authenticated()
		.requestMatchers("/print/relator/stock").authenticated()
		.requestMatchers("/delete/moviment").authenticated()
		.requestMatchers("/edit/product").authenticated()
		.requestMatchers("/pre/edit/product").authenticated()
		
		
		
		
		
		.anyRequest().authenticated();		
				
		})
		
		
		
		.formLogin( form -> form.loginPage("/loginRequest").loginProcessingUrl("/login").defaultSuccessUrl("/index" , true).successHandler(sucessHaldler))
		
		.httpBasic(Customizer.withDefaults());
		
		httpSecurity.authenticationProvider(authenticationProvider);
		
		
		
		return httpSecurity.build();
		
		
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	GrantedAuthorityDefaults grantedAuthorityDefaults() {
		
		return new GrantedAuthorityDefaults("");
		
	}
	
	
	
}
