package com.example.large_screen_display_v1.entity;

/**
 * 设备错误信息
 */
public class fault {
    /**
     * name:设备名字
     * fault:设备错误信息
     */
    private String equ_name;
    private String equ_fault;

    public fault(String equ_name, String equ_fault) {
        this.equ_name = equ_name;
        this.equ_fault = equ_fault;
    }

    public fault() {
    }

    public String getEqu_name() {
        return equ_name;
    }

    public void setEqu_name(String equ_name) {
        this.equ_name = equ_name;
    }

    public String getEqu_fault() {
        return equ_fault;
    }

    public void setEqu_fault(String equ_fault) {
        this.equ_fault = equ_fault;
    }
}
