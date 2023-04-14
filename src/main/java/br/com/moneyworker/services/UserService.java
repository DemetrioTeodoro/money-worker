package br.com.moneyworker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.moneyworker.entities.User;
import br.com.moneyworker.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		return userOptional.get();
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(Long id, User obj) {
		User user = userRepository.getReferenceById(id);
		updateData(user, obj);
		return userRepository.save(user);
	}

	private void updateData(User user, User obj) {
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
		user.setPhone(obj.getPhone());
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
