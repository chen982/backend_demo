package backend.repository;

import backend.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface UserRepository extends MongoRepository<User, String> {
    @Query("{username: ?0}")
    public List<User> findbyname(String username);
}
