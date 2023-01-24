package com.epam.userservice.web;

import com.epam.userservice.domain.UsersDTO;
import com.epam.userservice.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<UsersDTO> create(@RequestBody UsersDTO userDTO) {
        return ResponseEntity.ok(usersService.create(userDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> getUsers(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.getUsers(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usersService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersDTO> update(@PathVariable Long id, @RequestBody UsersDTO usersDTO) {
        return ResponseEntity.ok(usersService.update(id, usersDTO));
    }

    @GetMapping("/increase-posts/{id}")
    public ResponseEntity<Integer> increaseUserPost(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.increaseUserPostsAmount(id));
    }

    @GetMapping("/decrease-posts/{id}")
    public ResponseEntity<Integer> decreaseUserPost(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.decreaseUserPostsAmount(id));
    }
}
