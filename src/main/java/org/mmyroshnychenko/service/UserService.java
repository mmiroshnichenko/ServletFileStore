package org.mmyroshnychenko.service;

import org.mmyroshnychenko.model.User;
import org.mmyroshnychenko.repository.UserRepository;
import org.mmyroshnychenko.repository.impl.HibernateUserRepositoryImpl;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new HibernateUserRepositoryImpl();
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveNewUser(String username) {
        User user = new User();
        user.setUsername(username);
        return this.save(user);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user, String username) {
        user.setUsername(username);
        return userRepository.update(user);
    }

    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    public User getById(Long id) {
        return userRepository.getById(id);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public void deleteUser(User user) {
        userRepository.deleteById(user.getId());
    }
}
