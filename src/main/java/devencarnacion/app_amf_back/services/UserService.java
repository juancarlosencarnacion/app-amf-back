package devencarnacion.app_amf_back.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devencarnacion.app_amf_back.entities.User;
import devencarnacion.app_amf_back.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User updateUser(Integer id, User user) {
        User currentUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el usuario con el id " + id));

        if (user.getName() != null) {
            currentUser.setName(user.getName());
        }
 
        if (user.getLastName() != null) {
            currentUser.setLastName(user.getLastName());
        }

        if (user.getEmail() != null) {
            currentUser.setEmail(user.getEmail());
        }

        return userRepository.save(currentUser);
    }

    public void deleteUser(Integer id) {
        User currentUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el usuario con el id " + id));

        userRepository.delete(currentUser);
    }

}
