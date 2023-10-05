package co.edu.jdc.videosecurity.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "security_role_permission")
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "rpe_role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_role_permission_role"))
    private Role role;
    @ManyToOne(optional = false)
    @JoinColumn(name = "rpe_permission_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_role_permission_permission"))
    private Permission permission;
}
