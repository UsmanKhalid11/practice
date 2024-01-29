package com.example.sprinInAction;

import com.example.sprinInAction.Entity.RegistrationEntity;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepo extends CrudRepository<RegistrationEntity,Long> {
}
