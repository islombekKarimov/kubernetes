package com.epam.userservice.service;

import com.epam.userservice.domain.UsersDTO;
import com.epam.userservice.domain.Users;
import com.epam.userservice.exception.NotFoundUsersException;
import com.epam.userservice.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersDTO create(UsersDTO userDTO) {
        return entityToDto(usersRepository.save(dtoToEntity(userDTO)));
    }

    public UsersDTO getUsers(Long id) {
        return entityToDto(getOptionalUsers(id));
    }

    public void delete(Long id) {
        usersRepository.deleteById(id);
    }

    public UsersDTO update(Long id, UsersDTO dto) {
        Users users = getOptionalUsers(id);
        users.setUsername(dto.getUsername());
        users.setAmountOfPosts(dto.getAmountOfPosts());
        return entityToDto(usersRepository.save(users));
    }

    public int increaseUserPostsAmount(Long id) {
        Users users = getOptionalUsers(id);
        Long count = users.getAmountOfPosts() + 1;
        users.setAmountOfPosts(count);
        usersRepository.save(users);
        return 1;
    }

    public int decreaseUserPostsAmount(Long userId) {
        Users users = getOptionalUsers(userId);
        Long count = users.getAmountOfPosts() - 1;
        users.setAmountOfPosts(count);
        usersRepository.save(users);
        return 1;
    }

    private Users getOptionalUsers(Long id) {
        Optional<Users> users = usersRepository.findById(id);
        if (users.isPresent()) {
            return users.get();
        } else {
            throw new NotFoundUsersException(id);
        }
    }

    private Users dtoToEntity(UsersDTO userDTO) {
        return Users.builder()
                .username(userDTO.getUsername())
                .amountOfPosts(userDTO.getAmountOfPosts())
                .build();
    }

    private UsersDTO entityToDto(Users users) {
        return UsersDTO.builder()
                .id(users.getId())
                .username(users.getUsername())
                .amountOfPosts(users.getAmountOfPosts())
                .build();
    }
}
