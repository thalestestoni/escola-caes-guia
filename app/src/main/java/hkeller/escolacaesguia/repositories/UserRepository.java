package hkeller.escolacaesguia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hkeller.escolacaesguia.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    
} 