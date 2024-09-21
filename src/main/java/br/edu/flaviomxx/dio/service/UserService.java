package br.edu.flaviomxx.dio.service;

import br.edu.flaviomxx.dio.model.User;

public interface UserService {

    public User findById(Long id);

    public User createUser(User user);
}
