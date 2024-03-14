package com.example8.gp28.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }


    public void addNewUser(User user){
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("Email Exits");
        }
        userRepository.save(user);

    }


    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException(
                    "user with id" + userId + "does not exists");
        }
        userRepository.deleteById(userId);

    }

  @Transactional
    public  void updateUser(Long userId,
                            String name,
                            String surname,
                            String email,
                            String password){

      User user = userRepository.findById(userId)
              .orElseThrow(() -> new IllegalStateException("User with id " + userId + " does not exist"));



      if (name != null && !name.isEmpty() && !Objects.equals(user.getName(), name)) {
          user.setName(name);
      }

      if (surname != null && !surname.isEmpty() && !Objects.equals(user.getSurname(), surname)) {
          user.setSurname(surname);
      }

      if (email != null && !email.isEmpty() && !Objects.equals(user.getEmail(), email)) {
          Optional<User> userOptional = userRepository.findUserByEmail(email);
          if (userOptional.isPresent()) {
              throw new IllegalStateException("Email already exists");
          }
          user.setEmail(email);
      }

      if (password != null && !password.isEmpty() && !Objects.equals(user.getPassword(), password)) {
          user.setPassword(password);
      }

      userRepository.save(user);

  }

}
