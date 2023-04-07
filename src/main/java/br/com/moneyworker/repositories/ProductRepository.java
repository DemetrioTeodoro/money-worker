package br.com.moneyworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.moneyworker.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
