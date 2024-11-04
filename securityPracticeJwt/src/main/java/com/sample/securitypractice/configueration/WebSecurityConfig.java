package com.sample.securitypractice.configueration;

import com.sample.securitypractice.service.JwtAuthFilter;
import com.sample.securitypractice.service.MyDbUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final MyDbUserDetailService myDbUserDetailService;
    private final JwtAuthFilter jwtAuthFilter;


	@Autowired
	public WebSecurityConfig(MyDbUserDetailService myDbUserDetailService,JwtAuthFilter jwtAuthFilter) {
		this.myDbUserDetailService = myDbUserDetailService;
		this.jwtAuthFilter=jwtAuthFilter;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

        http	.authorizeRequests()
				.antMatchers("/v1.0/authenticate","/v1.0/jwts")
				.permitAll()
				.antMatchers("/v1.0/admin").hasAuthority("ADMIN")
				.antMatchers("/v1.0/user").hasAuthority("USER")
				.anyRequest()
				.authenticated()
				.and().addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	//this encoder check with prefix
	//i.e {bcrypt}$2y$12$6t86Rpr3llMANhCUt26oUen2WhvXr/A89Xo9zJion8W7gWgZ/zA0C is bcrypt encoding
	//{sha256}5ffa39f5757a0dad5dfada519d02c6b71b61ab1df51b4ed1f3beed6abe0ff5f6 is sha256 encoding
	//    @Bean
	//    public PasswordEncoder passwordEncoder() {
	//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	//    }
	//

	// is a basic bcrypt encoder
	@Bean
	@Primary
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override @Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(myDbUserDetailService);
	}



}
