package com.sopra.TPFinal.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sopra.TPFinal.services.CustomUserDetailService;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;

	@Autowired
	private CustomUserDetailService userDetailService;



	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/**/edit").authenticated().and().formLogin().antMatchers("/**").permitAll();
//	http.authorizeRequests().antMatchers("/menu/").authenticated().and().formLogin().loginPage("/login")
//				.failureUrl("/login?error=erreur").permitAll().and().logout().permitAll()
//				.logoutSuccessUrl("/deconnexion/");
		http.authorizeRequests().antMatchers("/client/").permitAll();
		http.authorizeRequests().antMatchers("/passager/").permitAll();
//		http.authorizeRequests().antMatchers("/rest/**").authenticated().and().httpBasic();
		http.authorizeRequests().antMatchers("/rest/**").permitAll();
		
		http.authorizeRequests().anyRequest().permitAll();

		http.csrf().disable();
		http.headers().frameOptions().disable();
//	System.out.println(getPasswordEncoder().encode("admin"));
		
//		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//	      .authorizeRequests().antMatchers(HttpMethod.OPTIONS).anonymous();
//	      http.headers().frameOptions().disable();
//	      // http.authorizeRequests().antMatchers("/**/edit").authenticated().and().formLogin().antMatchers("/**").permitAll();
//	      http.authorizeRequests().antMatchers("/**/edit").authenticated().and().formLogin().loginPage("/login")
//	              .failureUrl("/login?error=erreur").permitAll().and().logout().permitAll()
//	              .logoutSuccessUrl("/adherent/");
//	      http.authorizeRequests().antMatchers("/adherent/").permitAll();
//	      http.authorizeRequests().antMatchers("/article/").permitAll();
//
//
////	      http.authorizeRequests().antMatchers("/rest/**").authenticated().and().httpBasic();
//	      http.authorizeRequests().antMatchers("/rest/**").permitAll();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(getPasswordEncoder());
	}

	@Bean(name = "passwordEncoder")
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();

	}


}
