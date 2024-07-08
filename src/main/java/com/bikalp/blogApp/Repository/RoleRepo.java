package com.bikalp.blogApp.Repository;

import com.bikalp.blogApp.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
