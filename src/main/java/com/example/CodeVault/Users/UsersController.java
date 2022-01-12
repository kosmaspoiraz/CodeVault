package com.example.CodeVault.Users;

import com.example.CodeVault.Vault.VaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "codevault/users")
public class UsersController {

    private final UsersService usersService;
    private final VaultService vaultService;

    @Autowired
    public UsersController(UsersService usersService, VaultService vaultService) {
        this.usersService = usersService;
        this.vaultService = vaultService;
    }

    @GetMapping
    public List<Users> getUsers(){return usersService.getUsers();}

    @PostMapping
    public void addNewUser(@RequestBody Users newUser){
        usersService.addNewUser(newUser);
        vaultService.createNewVault(newUser.getId());
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        usersService.deleteUser(userId);
        vaultService.deleteVault(userId);
    }

    @PutMapping(path = "/update/{userId}")
    public void updateUserById(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String gender){
        usersService.updateUser(userId,
                name,
                surname,
                email,
                username,
                password,
                age,
                country,
                gender);
    }
}
