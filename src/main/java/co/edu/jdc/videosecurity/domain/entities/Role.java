package co.edu.jdc.videosecurity.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "security_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rol_name", length = 50, nullable = false, unique = true)
    private String name;
    @Column(name = "rol_description", length = 255)
    private String description;
    @OneToMany(mappedBy = "role")
    private List<RolePermission> rolePermissions;
}
