package com.example.api_shop_book.repository;

import com.example.api_shop_book.model.ERole;
import com.example.api_shop_book.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
