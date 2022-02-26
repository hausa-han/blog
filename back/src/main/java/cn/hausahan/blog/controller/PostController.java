package cn.hausahan.blog.controller;


import cn.hausahan.blog.common.result.BaseResult;
import cn.hausahan.blog.entity.Post;
import cn.hausahan.blog.service.IPostService;
import cn.hutool.core.map.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.StandardCharsets;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Hausa_
 * @since 2021-11-09
 */
@RestController
public class PostController extends BaseController {

    @Autowired
    IPostService postService;

    @GetMapping("/api/article")
    public BaseResult article(@RequestParam("id") Long id){

        Post post = postService.getById(id);

        StringBuffer content = new StringBuffer();
        String path = post.getSrc();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String s;
            while ((s = bufferedReader.readLine()) != null){
                content.append(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return BaseResult.success(
                MapUtil.builder()
                .put("title", post.getTitle())
                .put("date", post.getCreated())
                .put("html", content)
                .build()
        );
    }


}
