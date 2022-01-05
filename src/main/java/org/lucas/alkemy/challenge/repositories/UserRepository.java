package org.lucas.alkemy.challenge.repositories;

import java.util.Optional;

import org.lucas.alkemy.challenge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findOptionalByUsername(String name);
}
