package com.sample.securitypractice.configueration;

import com.sample.securitypractice.service.CustomAuthFilter;
import com.sample.securitypractice.service.CustomAuthProvider;
import com.sample.securitypractice.service.MyDbUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final MyDbUserDetailService myDbUserDetailService;
	private final CustomAuthProvider customAuthProvider;

	@Autowired
	public WebSecurityConfig(MyDbUserDetailService myDbUserDetailService, CustomAuthProvider customAuthProvider) {
		this.myDbUserDetailService = myDbUserDetailService;
		this.customAuthProvider = customAuthProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        CustomAuthFilter customAuthenticationFilter = new CustomAuthFilter("/**", authenticationManager());

        http	.authorizeRequests()
				.antMatchers("/v1.0/home")
				.permitAll()
				.antMatchers("/v1.0/admin").hasAuthority("ADMIN")
				.antMatchers("/v1.0/user").hasAuthority("USER")
				.anyRequest()
				.authenticated()
				.and().addFilterBefore(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
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

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// auth.authenticationProvider();    we can write custom authentication provider here by writing a
		//                                   custom provider that extend AuthenticationProvider we would overide
		//                                   authenticate method
		auth.authenticationProvider(customAuthProvider);
	}

}
