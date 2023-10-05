package co.edu.jdc.videosecurity.adapter.repository;

import co.edu.jdc.videosecurity.domain.entities.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {

    @Query("SELECT p.name FROM RolePermission rp JOIN rp.permission p JOIN rp.role r " +
            "JOIN UserRole ur ON ur.role.id = r.id JOIN User u ON u.id = ur.user.id WHERE u.username = :userName")
    List<String> getPermissionsByUserName(@Param("userName") String userName);
}
