package com.ujjawal0911.WalletApplication.Controllers;

import com.ujjawal0911.WalletApplication.Models.UserAccount;
import com.ujjawal0911.WalletApplication.Services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<UserAccount> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public Optional<UserAccount> getUserInformation(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserAccount createUser(@RequestBody UserAccount userAccount) {
        return userService.createUser(userAccount);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
    public UserAccount updateUser(@PathVariable int userId, @RequestBody UserAccount userAccount) {
        return userService.updateUser(userAccount);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int userId, @RequestBody UserAccount userAccount) {
        userService.deleteUser(userAccount);
    }

}
