package cn.hausahan.blog.security;

import cn.hausahan.blog.common.Const;
import cn.hausahan.blog.common.exceptions.CaptchaException;
import cn.hausahan.blog.utils.RedisUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CaptchaFilter extends OncePerRequestFilter {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    LoginFailureHandler loginFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String url = request.getRequestURI();
        if ("/login".equals(url) && "POST".equals(request.getMethod()) ) {
            try{
                validate(request);
            } catch (CaptchaException e){
                loginFailureHandler.onAuthenticationFailure(request, response, e);
            }
        }
        filterChain.doFilter(request, response);
    }

    protected void validate(HttpServletRequest request) {

        String code = request.getParameter("code");
        String key = request.getParameter("key");

        if(StringUtils.isBlank(code) || StringUtils.isBlank(key)){
            throw new CaptchaException("Captcha or UUID Empty");
        }

        if(!code.equals(redisUtil.hget(Const.CAPTCHA_KEY, key))){
            throw new CaptchaException("Error captcha, click the captcha to refresh");
        }

        //Can only used one time
        redisUtil.hdel(Const.CAPTCHA_KEY, key);

    }
}
