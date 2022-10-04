package co.springcoders.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("{noop}password")
		.roles("USER")
		.and().withUser("admin").password("{noop}password").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable()
		.authorizeRequests().antMatchers("/login/**", "/resources/**").permitAll()
		.anyRequest().authenticated()
		.and().formLogin(loginCustomizer -> {
			loginCustomizer.loginPage("/login")
			.defaultSuccessUrl("/")
			.failureForwardUrl("/loginFailed");
		}).logout(logoutCustomizer -> {
			logoutCustomizer.clearAuthentication(true)
			.logoutUrl("/logout").deleteCookies("JSESSIONID");
		});
	}
	
}
