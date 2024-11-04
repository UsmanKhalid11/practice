package com.sample.securitypractice.service;

import com.sample.securitypractice.entities.JwtTokenEntities;
import com.sample.securitypractice.reposotory.JwtDetailRepo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtUtilService {

	@Autowired
	private  JwtRepoService jwtRepoService;

	@Value("${secret.key}")
	private String SECRET;
	private long EXPIRATION_TIME = 10000;

	public String generateToken(String username) {
		Date expiry = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
		String token = Jwts.builder()
				.setSubject(username)
				.setExpiration(expiry)
				.signWith(SignatureAlgorithm.HS512, SECRET)
				.compact();
		jwtRepoService.saveJwtEntry(username, token, expiry);
		return token;
	}

	public String extractUsername(String token) {
		return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
	}
}
