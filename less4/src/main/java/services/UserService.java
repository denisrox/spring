package services;


import entities.SystemUser;
import entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUserName(String userName);
    void save(SystemUser systemUser);
}
