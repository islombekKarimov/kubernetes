package com.epam.postservice.service;

import com.epam.postservice.domain.Posts;
import com.epam.postservice.domain.PostsDTO;
import com.epam.postservice.exception.NotFoundPostsException;
import com.epam.postservice.repository.PostsRepository;
import com.epam.postservice.users_service.UsersClient;
import com.epam.postservice.users_service.UsersResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

    private final UsersClient usersClient;

    public PostsDTO create(PostsDTO postsDTO) {
        postsDTO.setPostedAt(LocalDate.now());
        usersClient.increaseUsersPosts(postsDTO.getAuthorId());
        return entityToDto(postsRepository.save(dtoToEntity(postsDTO)));
    }

    public PostsDTO getPosts(Long id) {
        return entityToDto(getOptionalPost(id));
    }

    public void delete(Long id) {
        Posts posts = getOptionalPost(id);
        usersClient.decreaseUsersPosts(posts.getAuthorId());
        postsRepository.deleteById(id);
    }

    public PostsDTO update(Long id, PostsDTO postsDTO) {
        Posts posts = getOptionalPost(id);
        posts.setAuthorId(posts.getAuthorId());
        posts.setText(postsDTO.getText());
        posts.setPostedAt(posts.getPostedAt());
        return entityToDto(postsRepository.save(posts));
    }

    private Posts getOptionalPost(Long id) {
        Optional<Posts> posts = postsRepository.findById(id);
        if (posts.isPresent()) {
            return posts.get();
        } else {
            throw new NotFoundPostsException(id);
        }

    }

    private PostsDTO entityToDto(Posts posts) {
        return PostsDTO.builder().id(posts.getId()).authorId(posts.getAuthorId()).text(posts.getText()).postedAt(posts.getPostedAt()).build();
    }

    private Posts dtoToEntity(PostsDTO postsDTO) {
        return Posts.builder().authorId(postsDTO.getAuthorId()).text(postsDTO.getText()).postedAt(postsDTO.getPostedAt()).build();
    }

}
