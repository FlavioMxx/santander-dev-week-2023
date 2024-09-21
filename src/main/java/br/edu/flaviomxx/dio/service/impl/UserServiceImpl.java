package br.edu.flaviomxx.dio.service.impl;

import br.edu.flaviomxx.dio.model.User;
import br.edu.flaviomxx.dio.repository.UserRepository;
import br.edu.flaviomxx.dio.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("Usuário de id (%d) não encontrado", id)));
    }

    @Override
    public User createUser(User user) {
        if(userRepository.existsByAccountNumber(user.getAccount().getNumber()))
            throw new IllegalArgumentException("Numero de conta já existe!");

        return userRepository.save(user);
    }
}
