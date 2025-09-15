package kz.doniiel.user_service.service.impl;

import kz.doniiel.user_service.dto.UserRequest;
import kz.doniiel.user_service.model.User;
import kz.doniiel.user_service.repository.UserRepository;
import kz.doniiel.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(UserRequest request) {
        var user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(Long id, UserRequest request) {
        var existUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not foud with user id: " + id));
        existUser.setName(request.getName());
        existUser.setEmail(request.getEmail());
        userRepository.save(existUser);
        return existUser;
    }
}
