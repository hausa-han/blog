package cn.hausahan.blog.service.impl;

import cn.hausahan.blog.entity.Menu;
import cn.hausahan.blog.entity.Role;
import cn.hausahan.blog.entity.User;
import cn.hausahan.blog.mapper.UserMapper;
import cn.hausahan.blog.service.IMenuService;
import cn.hausahan.blog.service.IRoleService;
import cn.hausahan.blog.service.IUserRoleService;
import cn.hausahan.blog.service.IUserService;
import cn.hausahan.blog.utils.RedisUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hausa_
 * @since 2021-11-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    IRoleService roleService;
    @Autowired
    IUserRoleService userRoleService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    IMenuService menuService;
    @Autowired
    RedisUtil redisUtil;

    @Override
    public User getByUsername(String username) {
        return getOne(new QueryWrapper<User>().eq("username", username));
    }

    @Override
    public String getUserAuthorityById(Long userId) {
        String authority = "";
        User user = userMapper.selectById(userId);

        if(redisUtil.hasKey("GrantedAuthority:" + user.getUsername())){
            authority = (String) redisUtil.get("GrantedAuthority:" + user.getUsername());
        } else {
            List<Role> roleList = roleService.list(new QueryWrapper<Role>().inSql("id", "select role_id from user_role where user_id = " +
                    userId));
            if(roleList.size() > 0){
                String roleCodes = roleList.stream().map(role -> "ROLE_" + role.getCode()).collect(Collectors.joining(","));
                authority = roleCodes.concat(",");
            }

            List<Long> menuIdList = userMapper.getMenuIds(userId);
            if(menuIdList.size() > 0){
                List<Menu> menuList = menuService.listByIds(menuIdList);
                String menuPerms = menuList.stream().map(menu -> menu.getPerms()).collect(Collectors.joining(","));
                authority = authority.concat(menuPerms);
            }

            redisUtil.set("GrantedAuthority:" + user.getUsername(), authority, 3600);
        }

        return authority;
    }

    @Override
    public void clearRedisAuthorityByUsername(String username) {
        redisUtil.del("GrantedAuthority:" + username);
    }

    @Override
    public void clearRedisAuthorityByRoleId(Long roleId) {
        List<User> users = this.list(new QueryWrapper<User>()
                .inSql("id", "select user_id from user_role where role_id = " + roleId));

        users.forEach(u -> { this.clearRedisAuthorityByUsername(u.getUsername()); });
    }

    @Override
    public void clearRedisAuthorityByMenuId(Long menuId) {
        List<User> users = userMapper.listByMenuId(menuId);
        users.forEach(u -> { this.clearRedisAuthorityByUsername(u.getUsername());});
    }
}
