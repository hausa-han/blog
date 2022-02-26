package cn.hausahan.blog.mapper;

import cn.hausahan.blog.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Hausa_
 * @since 2021-11-09
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Long> getMenuIdsByRoleId(Long roleId);
}
