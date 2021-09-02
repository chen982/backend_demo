package backend.service;


import backend.entity.User;

public interface UserService {

    public User register(User user);

    public User login(String username,String password);
}
