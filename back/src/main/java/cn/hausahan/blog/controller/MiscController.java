package cn.hausahan.blog.controller;

import cn.hausahan.blog.common.result.BaseResult;
import cn.hutool.core.map.MapUtil;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiscController{
    @GetMapping("/api/headImage")
    public BaseResult headImage(){
        return BaseResult.success(
                MapUtil.builder()
                .put("imageSrc","https://thirdqq.qlogo.cn/g?b=sdk&k=iaia6uKgFFHYNMfovV0pbgQA&s=100")
                .build()
        );
    }




}
