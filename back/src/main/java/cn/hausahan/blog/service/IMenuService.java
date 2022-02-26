package cn.hausahan.blog.service;

import cn.hausahan.blog.common.dto.MenuDto;
import cn.hausahan.blog.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hausa_
 * @since 2021-11-09
 */
public interface IMenuService extends IService<Menu> {

    List<MenuDto> getVisitorMenu();
}
