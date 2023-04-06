package br.com.moneyworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.moneyworker.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
