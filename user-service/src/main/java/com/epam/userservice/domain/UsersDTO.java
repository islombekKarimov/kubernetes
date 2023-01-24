package com.epam.userservice.domain;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsersDTO {

    private Long id;

    private String username;

    private long amountOfPosts;

}
