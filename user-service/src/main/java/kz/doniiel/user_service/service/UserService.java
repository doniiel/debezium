package kz.doniiel.user_service.service;

import kz.doniiel.user_service.dto.UserRequest;
import kz.doniiel.user_service.model.User;

public interface UserService {

    User createUser(UserRequest request);

    User updateUser(Long id, UserRequest request);
}
