package com.tct.SecondProject.Service;

import com.tct.SecondProject.model.User;
import com.tct.SecondProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity=userRepository.findByUserName(username);
        if(userEntity==null){
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails
                .User(userEntity.getUserName(),
                userEntity.getPassword(),
                Collections.emptyList());
    }
}