package app.weather.service;

import app.weather.model.User;

public interface UserService {
    User add(User user);

    User findByName(String name);
}
