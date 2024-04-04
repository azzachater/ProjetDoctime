package com.app.app.repository;

import com.app.app.entities.ERole;
import com.app.app.entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role , Integer> {

    Optional<Role> findByName(ERole name);

}
