package com.lipanre.jvm.stack.spring.security.domain;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author LiPan
 */
@Data
public class LoginUser implements UserDetails {

    /**
     * 用户对象
     */
    private User user;

    /**
     * 权限列表
     */
    private List<String> permissions;

    @JSONField(serialize = false)
    private List<GrantedAuthority> authorities;

    public static LoginUser of(User user, List<String> permissions) {
        LoginUser loginUser = LoginUser.of(user);
        loginUser.permissions = permissions;
        return loginUser;
    }


    public static LoginUser of(User user) {
        LoginUser loginUser = new LoginUser();
        loginUser.user = user;
        return loginUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (CollUtil.isEmpty(authorities)) {
            authorities = permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());;
        }
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getUserId() {
        if (Objects.isNull(user)) {
            return null;
        }
        return user.getId();
    }
}
