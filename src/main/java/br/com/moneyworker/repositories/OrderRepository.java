package br.com.moneyworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.moneyworker.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
