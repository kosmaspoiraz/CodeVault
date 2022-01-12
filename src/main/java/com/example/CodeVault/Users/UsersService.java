package com.example.CodeVault.Users;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers() { return usersRepository.findAll(); }

    public void addNewUser(Users newUser) {
        Optional<Users> userByName = usersRepository.findUserByName(newUser.getName());
        if (userByName.isPresent()){
            throw new IllegalStateException(newUser.getName() + " already exists!");
        }
        usersRepository.save(newUser);
    }

    public void deleteUser(Long userId) {
        boolean exists = usersRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException("User with id:" + userId + " does not exist!");
        }
        usersRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String name, String surname, String email, String username, String password, Integer age, String country, String gender) {
        boolean exists = usersRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException("User with id:" + userId + " does not exist!");
        }
        Users userToUpdate = usersRepository.getById(userId);
        if(name != null)
            userToUpdate.setName(name);
        if(name != null)
            userToUpdate.setSurname(surname);
        if(name != null)
            userToUpdate.setEmail(email);
        if(username != null)
            userToUpdate.setUsername(username);
        if(password != null)
            userToUpdate.setPassword(password);
        if(name != null)
            userToUpdate.setAge(age);
        if(name != null)
            userToUpdate.setCountry(country);
        if(name != null)
            userToUpdate.setGender(gender);
    }
}
