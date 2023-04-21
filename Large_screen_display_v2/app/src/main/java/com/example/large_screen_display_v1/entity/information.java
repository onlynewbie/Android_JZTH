package com.example.large_screen_display_v1.entity;

/**
 * 设备信息
 */
public class information {

    public information(String equ_name, String equ_model, String address, String status) {
        this.equ_name = equ_name;
        this.equ_model = equ_model;
        this.address = address;
        this.status = status;
    }

    /**
     * 名字
     * 设备型号
     * 安装地区
     * 工作状态
     */

    private String equ_name;
    private String equ_model;
    private String address;
    private String status;

    public information() {
    }

    public String getEqu_name() {
        return equ_name;
    }

    public void setEqu_name(String equ_name) {
        this.equ_name = equ_name;
    }

    public String getEqu_model() {
        return equ_model;
    }

    public void setEqu_model(String equ_model) {
        this.equ_model = equ_model;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
