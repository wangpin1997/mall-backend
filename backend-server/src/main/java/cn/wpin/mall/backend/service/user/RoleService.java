package cn.wpin.mall.backend.service.user;

import cn.wpin.mall.client.user.RoleClient;
import cn.wpin.mall.user.entity.Permission;
import cn.wpin.mall.user.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wangpin
 */
@Component
public class RoleService {

    @Autowired
    private RoleClient roleClient;


    public int create(Role role) {
        return roleClient.create(role);
    }


    public int update(Long id, Role role) {
        return roleClient.update(id, role);
    }


    public int delete(List<Long> ids) {
        return roleClient.delete(ids);
    }


    public List<Permission> getPermissionList(Long roleId) {
        return roleClient.getPermissionList(roleId);
    }


    public int updatePermission(Long roleId, List<Long> permissionIds) {
        return roleClient.updatePermission(roleId, permissionIds);
    }


    public Object list() {
        return roleClient.list();
    }
}
