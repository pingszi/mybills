package com.pings.mybills.service.security;

import com.pings.mybills.persistence.dao.UserMapper;
import com.pings.mybills.persistence.dao.UserRoleMapper;
import com.pings.mybills.persistence.model.User;
import com.pings.mybills.persistence.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *********************************************************
 ** @desc  ： 自定义UserDetailsService
 ** @author  Pings
 ** @date    2017/11/6
 ** @version v1.0
 * *******************************************************
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //**查找用户
        User user = new User();
        user.setUserName(userName);

        user = userMapper.selectOne(user);
        if (user == null) {
            throw new UsernameNotFoundException("用户名称不存在");
        }

        //**查找角色
        Map<String, Object> params = new HashMap<>();
        params.put("user_name", userName);
        List<UserRole> roles = userRoleMapper.selectByMap(params);
        user.setRoles(roles);

        return user;
    }
}
