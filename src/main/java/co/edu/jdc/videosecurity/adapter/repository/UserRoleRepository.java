package co.edu.jdc.videosecurity.adapter.repository;

import co.edu.jdc.videosecurity.domain.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    @Query("SELECT r.name FROM UserRole usr JOIN usr.user us JOIN usr.role r WHERE us.username = :username")
    List<String> getRolByUserName(@Param("username") String username);
}
