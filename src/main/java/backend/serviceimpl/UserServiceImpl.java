package backend.serviceimpl;

import backend.entity.User;
import backend.repository.UserRepository;
import backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User register(User user)
    {

        if(userRepository.findbyname(user.getUsername()).isEmpty())
        {
            userRepository.save(user);
            return user;
        }
        else
            return null;
    }

    @Override
    public User login(String username,String password){
        List<User> userlist = userRepository.findbyname(username);
        if(userlist.isEmpty())
        {
            return null;
        }
        else
        {
            User user = userlist.get(0);
            if(user.getPassword().compareTo(password)==0) {
                user.setPassword("已隐藏");
                return user;
            }
            else
                return null;
        }

    }
}
