package cn.wpin.mall.backend.service.user;

import cn.wpin.mall.backend.utils.JwtTokenUtil;
import cn.wpin.mall.client.user.AdminClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.user.dto.AdminParam;
import cn.wpin.mall.user.entity.Admin;
import cn.wpin.mall.user.entity.Permission;
import cn.wpin.mall.user.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author wangpin
 */
@Component
public class AdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminService.class);

    @Autowired
    private AdminClient adminClient;

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;


    public Admin getAdminByUsername(String username) {
        return adminClient.getAdminByUserName(username);
    }


    public Admin register(AdminParam adminParam) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminParam, admin);
        admin.setCreateTime(new Date());
        admin.setStatus(1);
        //为空返回false，不存在
        if (!adminClient.adminIsExist(adminParam)) {
            //将密码进行加密操作
            String encodePassword = passwordEncoder.encode(admin.getPassword());
            admin.setPassword(encodePassword);
            adminClient.addUser(admin);
            return admin;
        }
        return null;
    }


    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递,暂时手动在后台加密用来匹配
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//            if (!passwordEncoder.matches(passwordEncoder.encode(password), userDetails.getPassword())) {
//                throw new BadCredentialsException("密码不正确");
//            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            insertLoginLog(username);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    /**
     * 添加登录记录
     *
     * @param username 用户名
     */
    private void insertLoginLog(String username) {
        adminClient.insertLoginLog(username);
    }


    public String refreshToken(String oldToken) {
        String token = oldToken.substring(tokenHead.length());
        if (jwtTokenUtil.canRefresh(token)) {
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }


    public Admin getItem(Integer id) {
        return adminClient.getItem(id);
    }


    public CommonPage<Admin> list(String name, Integer pageSize, Integer pageNum) {
        return adminClient.list(name, pageSize, pageNum);
    }


    public int update(Long id, Admin admin) {
        return adminClient.update(id, admin);
    }


    public int delete(Long id) {
        return adminClient.delete(id);
    }


    public int updateRole(Long adminId, List<Long> roleIds) {
        return adminClient.updateRole(adminId, roleIds);
    }


    public List<Role> getRoleList(Long adminId) {
        return adminClient.getRoleList(adminId);
    }


    public int updatePermission(Long adminId, List<Long> permissionIds) {
        return adminClient.updatePermission(adminId, permissionIds);
    }


    public List<Permission> getPermissionList(Long adminId) {
        return adminClient.getPermissionList(adminId);
    }
}
