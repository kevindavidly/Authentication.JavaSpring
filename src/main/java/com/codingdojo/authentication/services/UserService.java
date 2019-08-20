package com.codingdojo.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
 // register user and hash their password

    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
  // find user by email


    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
  // find user by id


    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
 // authenticate user

    public boolean authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);                                        // first find the user by email
       if(user == null) {                                                                     // if we can't find it by email, return false
            return false;
        } else {
            if(BCrypt.checkpw(password, user.getPassword())) {                                // if the passwords match, return true, else, return false
                return true;
            } else {
                return false;
            }
        }
    }
}