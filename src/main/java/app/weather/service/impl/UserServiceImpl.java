package app.weather.service.impl;

import app.weather.model.User;
import app.weather.repository.UserRepository;
import app.weather.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findUserByName(name).orElseThrow(()
                -> new RuntimeException("Can't find user " + name + " in DB. "));
    }
}
