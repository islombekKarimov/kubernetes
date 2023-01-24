package com.epam.postservice.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class UsersProperties {
    @Value("${users_service.url}")
    private String url;




}
