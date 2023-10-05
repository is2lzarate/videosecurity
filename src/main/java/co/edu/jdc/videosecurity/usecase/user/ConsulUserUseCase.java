package co.edu.jdc.videosecurity.usecase.user;

import co.edu.jdc.videosecurity.adapter.repository.RolePermissionRepository;

import java.util.List;

public class ConsulUserUseCase {

    private RolePermissionRepository rolePermissionRepository;

    public ConsulUserUseCase(RolePermissionRepository rolePermissionRepository) {
        this.rolePermissionRepository = rolePermissionRepository;
    }

    public List<String> getPermissionUsername(String userName) {
        return rolePermissionRepository.getPermissionsByUserName(userName);
    }
}
