package com.example.bulletin_board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		// ログイン設定
		.formLogin(login -> login
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.usernameParameter("userid")
				.passwordParameter("password")
				.defaultSuccessUrl("/board")
				.failureUrl("/login?error")
				.permitAll()
				
		)
		// 認可の設定
		.authorizeHttpRequests(authz -> authz
				.requestMatchers("/css/**",
												 "/images/**").permitAll()
				.requestMatchers("/user/registration").permitAll()
		)
		.authorizeHttpRequests(authz -> authz
				.requestMatchers("/management").hasAuthority("ROLE_ADMIN")
				.anyRequest().authenticated()
		)
		
		// ログアウト設定
		.logout(logout -> logout
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login")
		)
		
		.exceptionHandling(ex -> ex
				.accessDeniedPage("/accessDenied")
		);
		return http.build();
	}
	
	// パスワードハッシュ化するためのやつ
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
