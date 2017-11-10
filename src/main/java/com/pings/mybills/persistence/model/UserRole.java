package com.pings.mybills.persistence.model;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 *********************************************************
 ** @desc  ： UserRole
 ** @author  Pings
 ** @date    2017/11/6
 ** @version v1.0
 * *******************************************************
 */
@TableName("bas_user_role")
public class UserRole extends BaseModel<UserRole> {

    private String userName;
    private String roleCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
