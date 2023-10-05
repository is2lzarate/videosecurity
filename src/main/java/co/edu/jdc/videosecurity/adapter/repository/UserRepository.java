package co.edu.jdc.videosecurity.adapter.repository;

import co.edu.jdc.videosecurity.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u")
    List<User> findAll();
    @Query(value = "SELECT COUNT (u) FROM User u WHERE u.username = :username")
    Long existsUser(String username);
    @Query(value = "SELECT COUNT (u) FROM User u WHERE u.id = :id")
    Long existUser(Long id);
    User findByUsername(String username);
}
