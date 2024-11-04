package com.sample.securitypractice.service;

import com.sample.securitypractice.entities.JwtTokenEntities;
import com.sample.securitypractice.reposotory.JwtDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JwtRepoService {

	@Autowired
	private JwtDetailRepo jwtDetailRepo;
	public void saveJwtEntry(String username,String token, Date expiry){
		JwtTokenEntities jwt= jwtDetailRepo.findByUserNameAndExpired(username,false);
		if(jwt!=null){
			jwt.setExpiry(expiry);
			jwt.setToken(token);
		}else {
			jwt= JwtTokenEntities.builder().userName(username).token(token).expiry(expiry).build();
		}
		jwtDetailRepo.save(jwt);



	}
	public JwtTokenEntities getByName(String name){

		return  jwtDetailRepo.findByUserNameAndExpired(name,false);
	}
	public List<JwtTokenEntities> getByExpire(boolean expiryFlag){
		return  jwtDetailRepo.findByExpired(expiryFlag);
	}
	public void expireTokenUpdate(JwtTokenEntities jwtTokenEntities){
		jwtTokenEntities.setExpired(true);
		jwtDetailRepo.save(jwtTokenEntities);
	}
	public List<JwtTokenEntities> get(){
		return  jwtDetailRepo.findAll();
	}
}
