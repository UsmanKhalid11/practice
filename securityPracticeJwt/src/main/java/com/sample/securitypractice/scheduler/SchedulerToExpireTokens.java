package com.sample.securitypractice.scheduler;

import com.sample.securitypractice.entities.JwtTokenEntities;
import com.sample.securitypractice.service.JwtRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Component
public class SchedulerToExpireTokens {

	@Autowired
	private JwtRepoService jwtRepoService;

	@Scheduled(cron = "0 */2 * * * *")
	public void expireToken() {
		System.out.println("Scheduler started");
		List<JwtTokenEntities> jwtList = jwtRepoService.getByExpire(false);
		for (JwtTokenEntities jwtTokenEntity : jwtList) {
			if (jwtTokenEntity.getExpiry().compareTo(new Date(System.currentTimeMillis())) < 0)
				jwtRepoService.expireTokenUpdate(jwtTokenEntity);

		}
	}
}
