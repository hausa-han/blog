package cn.hausahan.blog.service.impl;

import cn.hausahan.blog.common.dto.MenuDto;
import cn.hausahan.blog.entity.Menu;
import cn.hausahan.blog.mapper.MenuMapper;
import cn.hausahan.blog.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hausa_
 * @since 2021-11-09
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<MenuDto> getVisitorMenu() {

        Long roleId = 2L;
        List<Long> menuIds = menuMapper.getMenuIdsByRoleId(roleId);
        List<Menu> menuList = this.listByIds(menuIds);
        List<Menu> menuTree = buildTreeMenu(menuList);

        return treeToDto(menuTree);

    }

    private List<MenuDto> treeToDto(List<Menu> menuTree) {
        List<MenuDto> result = new ArrayList<>();
        menuTree.forEach(m -> {
            MenuDto dto = new MenuDto();
            dto.setId(m.getId());
            dto.setName(m.getName());
            dto.setPath(m.getPath());
            dto.setComponent(m.getComponent());
            dto.setTitle(m.getName());
            if(m.getChildren().size() > 0){
                dto.setChildren(treeToDto(m.getChildren()));
            }
            result.add(dto);
        });
        return result;
    }

    private List<Menu> buildTreeMenu(List<Menu> menuList) {
        List<Menu> result = new ArrayList<>();
        for(Menu menu : menuList){
            for(Menu m : menuList){
                if(menu.getId() == m.getParentId()){
                    menu.getChildren().add(m);
                }
            }
            if(menu.getParentId() == 0L){
                result.add(menu);
            }
        }
        return result;
    }
}
