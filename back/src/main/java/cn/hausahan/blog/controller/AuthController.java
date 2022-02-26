package cn.hausahan.blog.controller;

import cn.hausahan.blog.common.Const;
import cn.hausahan.blog.common.result.BaseResult;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.map.MapUtil;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@RestController
public class AuthController extends BaseController{

    @Autowired
    private Producer producer;

    @GetMapping("/api/captcha")
    public BaseResult captcha() throws IOException {
        String key = UUID.randomUUID().toString();
        String code = producer.createText();

        BufferedImage image = producer.createImage(code);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);

        String base64Img = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(outputStream.toByteArray());

//        key = "key";
//        code = "code";
        redisUtil.hset(Const.CAPTCHA_KEY, key, code, 30);

        return BaseResult.success(
                MapUtil.builder()
                        .put("key", key)
                        .put("base64Img", base64Img)
                        .build()
        );
    }

}
