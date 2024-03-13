package dio.web.api.controller;

import dio.web.api.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dio.web.api.model.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Operation(summary = "Returns all user in the repository")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the users",
                    content =  @Content),
            @ApiResponse(responseCode = "404", description = "Users not found",
                    content = @Content) })
    @GetMapping()
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Operation(summary = "Returns a user by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @GetMapping("/id/{id}")
    public User getOneUserById(@Parameter(description = "Id of user to be searched") @PathVariable("id") Integer id) {
        return userRepository.findById(id);
    }

    @Operation(summary = "Returns a user by username")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid username supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @GetMapping("/username/{username}")
    public User getOneUserByUsername(@Parameter(description = "Username of user to be searched") @PathVariable("username") String username) {
        return userRepository.findByUsername(username);
    }

    @Operation(summary = "Deletes a user by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @DeleteMapping("/{id}")
    public void deleteUser(@Parameter(description = "Id of user to be deleted") @PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }

    @Operation(summary = "Creates a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content) })
    @PostMapping()
    public void postUser(@Parameter(description = "Information to create a new user") @RequestBody User user) {
        userRepository.save(user);
    }

    @Operation(summary = "Updates a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content) })
    @PutMapping()
    public void putUser(@Parameter(description = "Information to update a new user") @RequestBody User user) {
        userRepository.save(user);
    }
}
