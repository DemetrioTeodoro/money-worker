package br.com.moneyworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.moneyworker.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
