package com.devcourse.board.service;

import com.devcourse.board.converter.UserConverter;
import com.devcourse.board.domain.user.User;
import com.devcourse.board.dto.user.UserCreateRequest;
import com.devcourse.board.dto.user.UserResponse;
import com.devcourse.board.dto.user.UserUpdateRequest;
import com.devcourse.board.repository.UserRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Transactional
    public Long insert(UserCreateRequest dto) {
        User user = userConverter.convertToUser(dto);
        userRepository.save(user);
        user.setInfo(user.getId());
        return user.getId();
    }

    public UserResponse findById(Long id) throws NotFoundException {
        return userRepository.findById(id)
            .map(userConverter::convertToUserResponse)
            .orElseThrow(() -> new NotFoundException("유저를 찾을 수 없습니다."));
    }

    public Page<UserResponse> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
            .map(userConverter::convertToUserResponse);
    }

    @Transactional
    public UserResponse update(UserUpdateRequest dto) throws NotFoundException {
        // Todo : Update할때 연관관계에 있는 posts필드는 어떻게 set하는게 좋은 방법?
        User foundUser = userRepository.findById(dto.getId())
            .orElseThrow(() -> new NotFoundException("업데이트할 유저를 찾을 수 없습니다."));
        User user = userConverter.convertToUser(dto, foundUser.getPosts());
        userRepository.save(user);
        return userConverter.convertToUserResponse(user);
    }

    @Transactional
    public Long delete(Long id) throws NotFoundException {
        userRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("삭제할 유저를 찾을 수 없습니다."));
        userRepository.deleteById(id);
        return id;
    }

}
