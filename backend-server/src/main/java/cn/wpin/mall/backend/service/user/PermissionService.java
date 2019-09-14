package cn.wpin.mall.backend.service.user;

import cn.wpin.mall.client.user.PermissionClient;
import cn.wpin.mall.user.dto.PermissionNode;
import cn.wpin.mall.user.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wangpin
 */
@Component
public class PermissionService {

    @Autowired
    private PermissionClient permissionClient;


    public int create(Permission permission) {
        return permissionClient.create(permission);
    }


    public int update(Long id, Permission permission) {
        return permissionClient.update(id, permission);
    }


    public int delete(List<Long> ids) {
        return permissionClient.delete(ids);
    }


    public List<PermissionNode> treeList() {
        return permissionClient.treeList();
    }


    public List<Permission> list() {
        return permissionClient.list();
    }
}
