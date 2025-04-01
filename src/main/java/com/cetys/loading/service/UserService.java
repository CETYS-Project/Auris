package com.cetys.loading.service;

import com.cetys.loading.dto.request.UserDtoRequest;
import com.cetys.loading.dto.response.UserDtoResponse;
import com.cetys.loading.mapper.UserMapper;
import com.cetys.loading.model.Subarea;
import com.cetys.loading.model.User;
import com.cetys.loading.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserDtoResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toUserDtoResponseList(users);
    }

    public UserDtoResponse getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return userMapper.toUserDtoResponse(user.orElse(null));
    }

    public UserDtoResponse createUser(UserDtoRequest user) {
        User newUser = userMapper.requestToUser(user);
        userRepository.save(newUser);
        return userMapper.toUserDtoResponse(newUser);
    }

    public UserDtoResponse updateUser(Long id, UserDtoRequest userDetails) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            userRepository.save(user);
            return userMapper.toUserDtoResponse(user);
        } else {
            return null;
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}