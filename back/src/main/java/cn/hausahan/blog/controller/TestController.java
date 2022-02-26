package cn.hausahan.blog.controller;

import cn.hausahan.blog.service.IUserService;
import cn.hausahan.blog.common.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private IUserService userService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/test")
    public BaseResult test() {
        return BaseResult.success(userService.list());
    }

    @PreAuthorize("hasAuthority('admin:change')")
    @GetMapping("/test/register")
    public BaseResult register(){
        String password = bCryptPasswordEncoder.encode("BBGW@blog.5721");

        boolean match = bCryptPasswordEncoder.matches("BBGW@blog.5721", password);

        if(match) {
            return BaseResult.success(password);
            //$2a$10$n2vGPN1iUwGq97fw7mtbFe80jwX0i9fWJdYvvBS/exjuGumuJPfPC
        } else{
            return BaseResult.fail("Does not match.");
        }
    }
}
