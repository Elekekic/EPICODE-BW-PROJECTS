package BW_5.gruppo_3.repository;

import BW_5.gruppo_3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public Optional<User> findByEmail(String email);
    public Optional<User> findByUsername(String username);

}
