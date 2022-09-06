package com.jgsudhakar.nosql.api;

import com.jgsudhakar.nosql.api.req.UserReqDto;
import com.jgsudhakar.nosql.api.res.UserResDto;
import com.jgsudhakar.nosql.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*************************************
 * This Class is used to
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.nosql.api.UserResource
 * Date    : 05 September 2022
 * Version : 1.0
 **************************************/
@RestController
@RequestMapping("/api/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @Operation(summary = "Get List Of Users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Job List",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "List not found",
                    content = @Content) })
    @GetMapping()
    public List<UserResDto> fetchUsers() {
       return userService.findAll();
    }

    @Operation(summary = "View User")
    @GetMapping("/{userId}")
    @ApiResponses(value = {@ApiResponse (responseCode = "200", description = "View User",
            content = {@Content (mediaType = "application/json",
                    schema = @Schema(implementation = UserResDto.class))})})
    public UserResDto view(@PathVariable(name = "userId") String userId) {
        return userService.fetchUserById(userId);
    }

    @Operation(summary = "Save User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Save New User",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = UserResDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Request",content = @Content),
            @ApiResponse(responseCode = "404", description = "Error",content = @Content) })
    @PostMapping()
    public UserResDto save(@RequestBody UserReqDto userReqDto) {
       return userService.save(userReqDto);
    }

    @Operation(summary = "Update User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update User",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = UserResDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Request",content = @Content),
            @ApiResponse(responseCode = "404", description = "Error",content = @Content) })
    @PutMapping()
    public UserResDto update(@RequestBody UserReqDto userReqDto) {
        return userService.update(userReqDto);
    }

    @Operation(summary = "Delete User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Save New User",
                    content = { @Content(mediaType = "application/json",schema = @Schema(implementation = UserResDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Request",content = @Content),
            @ApiResponse(responseCode = "404", description = "Error",content = @Content) })
    @DeleteMapping("{userId}")
    public UserResDto delete(@PathVariable(name = "userId") String userId) {
        return userService.delete(userId);
    }
}
