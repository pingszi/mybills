package com.pings.mybills.persistence.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *********************************************************
 ** @desc  ： user
 ** @author  Pings
 ** @date    2017/11/1
 ** @version v1.0
 * *******************************************************
 */
//**表名
@TableName("bas_user")
public class User extends BaseModel<User> implements UserDetails {

    private String name;
    private Integer sex;
    private Integer age;
    private String mobile;
    private String userName;
    private String password;
    @TableField(exist = false)
    private List<UserRole> roles;

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    /**把角色转换成spring-security权限*/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> auths  = new ArrayList<>();
        for (UserRole role : roles) {
            auths.add(new SimpleGrantedAuthority(role.getRoleCode()));
        }

        return auths;
    }

    /**用户帐户是否没有过期*/
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**指示用户是否没有锁定*/
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**指示用户的凭据(密码)是否没有过期*/
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**指示用户是否启用*/
    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
}
