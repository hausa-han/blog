package cn.hausahan.blog.controller;


import cn.hausahan.blog.common.result.BaseResult;
import cn.hausahan.blog.entity.Page;
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

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Hausa_
 * @since 2021-12-24
 */
@RestController
public class PageController extends BaseController {
    @Autowired
    IPageService pageService;

    @GetMapping("/api/getPageDetail")
    public BaseResult getPageDetail(@RequestParam("id") Long id){
        Page page = pageService.getById(id);

        StringBuffer content = new StringBuffer();
        String path = page.getSrc();
        try{
            FileInputStream inputStream = new FileInputStream(path);
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String s;
            while((s=bufferedReader.readLine()) != null){ content.append(s); }
        }catch (Exception e){ }

        return BaseResult.success(
                MapUtil.builder()
                        .put("title", page.getTitle())
                        .put("date", page.getCreated())
                        .put("html", content)
                        .build()
        );
    }
}
