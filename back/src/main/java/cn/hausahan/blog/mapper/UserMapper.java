package cn.hausahan.blog.mapper;

import cn.hausahan.blog.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Hausa_
 * @since 2021-11-09
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    List<Long> getMenuIds(Long userId);

    List<User> listByMenuId(Long menuId);
}
