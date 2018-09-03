/***
 * @pName proback
 * @name JsonArrayResult
 * @user HongWei
 * @date 2018/8/1
 * @desc 标准数组JSON响应消息模板
 */
package com.wanhao.ssm.entity.util;

import java.util.List;

/**
 * 标准数组JSON响应消息模板 韦德 2018年8月1日23:05:56
 * @param <T>
 */
public class JsonArrayResult<T> extends JsonResult{

    public JsonArrayResult(Integer code, List<T> data) {
        super(code);
        this.data = data;
    }

    public JsonArrayResult(Integer code, List<T> data,Integer count) {
        super(code);
        this.data = data;
        this.count = count;
    }


    private Integer count;

    public Integer getCount() {
        if(count == null || count == 0) return this.data.size();
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
