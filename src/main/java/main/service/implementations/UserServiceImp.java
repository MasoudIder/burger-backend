package main.service.implementations;

import main.domain.User;
import main.domain.repository.UserRepository;
import main.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImp implements UserService {
    private UserRepository repository;

    public UserServiceImp(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }
}