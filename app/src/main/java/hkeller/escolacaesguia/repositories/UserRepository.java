package hkeller.escolacaesguia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hkeller.escolacaesguia.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    boolean existsByEmail(String email);
} 