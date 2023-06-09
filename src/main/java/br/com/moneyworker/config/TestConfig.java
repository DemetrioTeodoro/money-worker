package br.com.moneyworker.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.moneyworker.entities.Category;
import br.com.moneyworker.entities.Order;
import br.com.moneyworker.entities.OrderItem;
import br.com.moneyworker.entities.Payment;
import br.com.moneyworker.entities.Product;
import br.com.moneyworker.entities.User;
import br.com.moneyworker.entities.enums.OrderStatus;
import br.com.moneyworker.repositories.CategoryRepository;
import br.com.moneyworker.repositories.OrderItemRepository;
import br.com.moneyworker.repositories.OrderRepository;
import br.com.moneyworker.repositories.ProductRepository;
import br.com.moneyworker.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		Category category1 = new Category(null, "Clothes");
		Category category2 = new Category(null, "Sporting");
		Category category3 = new Category(null, "Technological");

		Product product1 = new Product(null, "Cadeira gamer", "Cadeira confortavel e ergnomica", 990.9, "");
		Product product2 = new Product(null, "PC gamer", "Pc gamer com placa de video dedicada", 3500.5, "");
		Product product3 = new Product(null, "Bicicleta mountain bike", "Bicicleta aro 29 com amortecedor", 2500.5, "");
		Product product4 = new Product(null, "Camiseta", "Camiseta de algodão 100%", 4500.5, "");
		Product product5 = new Product(null, "Raquete de badmington", "Raquete de badmington leve e potente", 500.5, "");

		User user1 = new User(null, "Maria", "maria@gmail.com", "988888888", "123456");
		User user2 = new User(null, "Arthur", "arthur@gmail.com", "977777777", "123456");

		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED, user2);
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user2);

		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

		product1.getCategories().add(category3);
		product2.getCategories().add(category3);
		product3.getCategories().add(category2);
		product4.getCategories().add(category1);
		product5.getCategories().add(category2);

		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));

		OrderItem orderItem1 = new OrderItem(order1, product1, 2, product1.getPrice());
		OrderItem orderItem2 = new OrderItem(order1, product3, 1, product4.getPrice());
		OrderItem orderItem3 = new OrderItem(order2, product3, 2, product1.getPrice());
		OrderItem orderItem4 = new OrderItem(order3, product5, 3, product5.getPrice());

		orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));

		Payment payment1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), order1);

		order1.setPayment(payment1);

		orderRepository.save(order1);
	}
}
