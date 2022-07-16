package com.kepco.etax.api.service;

import com.kepco.etax.api.domain.entity.User;
import com.kepco.etax.api.domain.request.UserRequest;
import com.kepco.etax.api.exception.UserNotFoundException;
import com.kepco.etax.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

   @Autowired
   private UserRepository repository;

   public User saveUser(UserRequest userRequest) {
       User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(),
               userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
       return repository.save(user);
   }

   public List<User> getAllUsers() {
       return repository.findAll();
   }

   public User getUser(int id) throws UserNotFoundException {
       User user = repository.findByUserId(id);
       if (user!=null) {
           return user;
       } else {
           throw new UserNotFoundException("사용자ID를 찾을 수 없습니다. ID:" + id);
       }
   }
}
