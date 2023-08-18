package com.senai.segundoProjetoWeb.repository;

import com.senai.segundoProjetoWeb.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    @Query(value = "select * from usuarios where email= :email and senha = :senha", nativeQuery = true)
    public UserModel login(String email, String senha);
}
