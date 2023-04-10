package br.com.moneyworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.moneyworker.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
