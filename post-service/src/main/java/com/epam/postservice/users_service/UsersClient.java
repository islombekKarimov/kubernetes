package com.epam.postservice.users_service;

import com.epam.postservice.exception.UserServiceException;
import com.epam.postservice.properties.UsersProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class UsersClient {

    private final UsersProperties usersProperties;

    public Integer increaseUsersPosts(Long userId) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        try {
            String baseUrl = usersProperties.getUrl() + "/api/v1/users/increase-posts/" + userId;
            Integer value = restTemplate.getForObject(baseUrl, Integer.class);
            return value;
        } catch (Exception e) {
            throw new UserServiceException(userId);
        }
    }

    public Integer decreaseUsersPosts(Long userId) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        try {
            String baseUrl = usersProperties.getUrl() + "/api/v1/users/decrease-posts/" + userId;
            Integer value = restTemplate.getForObject(baseUrl, Integer.class);
            return value;
        } catch (Exception e) {
            throw new UserServiceException(userId);
        }
    }

}
