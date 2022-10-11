package com.ujjawal0911.WalletApplication.Controllers;

import com.ujjawal0911.WalletApplication.Models.UserAccount;
import com.ujjawal0911.WalletApplication.Services.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Get all users information from the Database.")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<UserAccount> getAllUsers() {
        return userService.getAllUsers();
    }

    @ApiOperation(value = "Get a particular user information given the userId.")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public UserAccount getUserInformation(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @ApiOperation(value = "Create a user account.")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserAccount createUser(@RequestBody UserAccount userAccount) {
        return userService.createUser(userAccount);
    }

    @ApiOperation(value = "Update a user information.")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
    public UserAccount updateUser(@PathVariable int userId, @RequestBody UserAccount userAccount) {
        return userService.updateUser(userAccount);
    }

    @ApiOperation(value = "Delete a user account.")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int userId) {
        UserAccount userAccount = userService.getUser(userId);
        userService.deleteUser(userAccount);
    }

}
