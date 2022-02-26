package cn.hausahan.blog.security;

import cn.hausahan.blog.entity.User;
import cn.hausahan.blog.service.IUserService;
import cn.hausahan.blog.service.impl.UserServiceImpl;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.GenericArrayType;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getByUsername(s);

        if (user == null){
            throw new UsernameNotFoundException("Wrong username or password");
        }
        return new AccountUser(user.getId(), user.getUsername(), user.getPassword(), getUserAuthority(user.getId()));
    }

    /**
     * get user authority (role, menu)
     * @param userId
     * @return
     */
    public List<GrantedAuthority> getUserAuthority(Long userId){

        String authority = userService.getUserAuthorityById(userId);

        return AuthorityUtils.commaSeparatedStringToAuthorityList(authority);
    }
}
