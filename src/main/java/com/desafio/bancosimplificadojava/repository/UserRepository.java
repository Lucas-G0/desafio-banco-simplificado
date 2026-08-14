package com.desafio.bancosimplificadojava.repository;

import com.desafio.bancosimplificadojava.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
