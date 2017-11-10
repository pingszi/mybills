package com.pings.mybills.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

/**
 *********************************************************
 ** @desc  ： BaseModel
 ** @author  Pings
 ** @date    2017/11/1
 ** @version v1.0
 * *******************************************************
 */
public class BaseModel<T extends BaseModel> extends Model<T> {

    private Integer id;
    private String addWho;
    private String addTime;
    private String editWho;
    private String editTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddWho() {
        return addWho;
    }

    public void setAddWho(String addWho) {
        this.addWho = addWho;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getEditWho() {
        return editWho;
    }

    public void setEditWho(String editWho) {
        this.editWho = editWho;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }
}
