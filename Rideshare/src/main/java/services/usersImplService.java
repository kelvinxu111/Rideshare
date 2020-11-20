package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import model.*;
import repository.*;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

@Service("usersService")
public class usersImplService implements usersService{
    @Autowired
    @Qualifier("usersRepository")
    private usersRepository userRepository;

    @Override
    public Users findUserById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public Users findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public Users createUser(Users user){
        Users checkUser = findUserByUsername(user.getUsername());
        if (checkUser!=null){
            return null;
        }
        //Users lastUser = userRepository.findTopByOrderByIdDesc();
        user.setPassword(getPasswordHash("",user.getPassword()));
        userRepository.save(user);
        return user;
    }
    private String getPasswordHash(String salt, String plainText){
        return Hashing.sha256().hashString(salt + plainText, StandardCharsets.UTF_8).toString();
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }
}
