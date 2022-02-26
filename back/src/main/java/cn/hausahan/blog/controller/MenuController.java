package cn.hausahan.blog.controller;


import cn.hausahan.blog.common.dto.MenuDto;
import cn.hausahan.blog.common.result.BaseResult;
import cn.hausahan.blog.entity.Page;
import cn.hausahan.blog.service.IMenuService;
import cn.hausahan.blog.service.IPageService;
import cn.hutool.core.map.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Hausa_
 * @since 2021-11-09
 */
@RestController
public class MenuController extends BaseController {
    @Autowired
    IMenuService menuService;

    @GetMapping("/api/getMenu")
    public BaseResult getMenu(){
        List<MenuDto> menus = menuService.getVisitorMenu();
        return BaseResult.success(MapUtil.builder()
                            .put("menu", menus)
                            .build()
        );
    }
}
