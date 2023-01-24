package com.epam.postservice.web;


import com.epam.postservice.domain.PostsDTO;
import com.epam.postservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostsController {

    private final PostsService postsService;

    @PostMapping
    public ResponseEntity<PostsDTO> create(@RequestBody PostsDTO postsDTO) {
        return ResponseEntity.ok(postsService.create(postsDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostsDTO> getPosts(@PathVariable Long id) {
        return ResponseEntity.ok(postsService.getPosts(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postsService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostsDTO> update(@PathVariable Long id, @RequestBody PostsDTO postsDTO) {
        return ResponseEntity.ok(postsService.update(id, postsDTO));
    }

}
