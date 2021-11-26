package app.weather.service;

import app.weather.model.User;

public interface AuthenticationService {
    User register(String name, String password);
}
