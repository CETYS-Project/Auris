package com.cetys.loading.mapper;

import com.cetys.loading.dto.request.UserDtoRequest;
import com.cetys.loading.dto.response.UserDtoResponse;
import com.cetys.loading.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User requestToUser(UserDtoRequest userDtoRequest);

    UserDtoRequest toUserDtoRequest(User user);

    User responseToUser(UserDtoResponse userDtoResponse);

    UserDtoResponse toUserDtoResponse(User user);

    List<UserDtoResponse> toUserDtoResponseList(List<User> users);

    List<User> requestToUserList(List<UserDtoRequest> userDtoRequests);

    List<UserDtoRequest> toUserDtoRequestList(List<User> users);

    List<User> responseToUserList(List<UserDtoResponse> userDtoResponses);

}