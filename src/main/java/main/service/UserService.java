package main.service;

import main.domain.User;

import java.util.Optional;

public interface UserService {
    public void save(User user);

    public Optional<User> findByEmailAndPassword(String email, String password);
}
