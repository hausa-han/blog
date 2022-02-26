package cn.hausahan.blog.service;

import cn.hausahan.blog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hausa_
 * @since 2021-11-09
 */
public interface IUserService extends IService<User> {

    User getByUsername(String username);

    String getUserAuthorityById(Long userId);

    void clearRedisAuthorityByUsername(String username);
    void clearRedisAuthorityByRoleId(Long roleId);
    void clearRedisAuthorityByMenuId(Long menuId);
}
