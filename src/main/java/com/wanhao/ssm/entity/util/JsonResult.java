/***
 * @pName proback
 * @name JsonResult
 * @user HongWei
 * @date 2018/8/1
 * @desc 标准JSON响应消息模板
 */
package com.wanhao.ssm.entity.util;

/**
 * 标准JSON响应消息模板 韦德 2018年8月1日23:05:56
 */
public class JsonResult {
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JsonResult(Integer code, String msg) {

        this.code = code;
        this.msg = msg;
    }

    public JsonResult(Integer code) {
        this.code = code;
        if(code == 0)  this.msg = "success";
        if(code == 1)  this.msg = "error";
    }
}
