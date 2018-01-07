package com.ghj.hound.entity.tul;

import java.util.List;

public class TuLResponse {

    /**
     100000	文本类
     200000	链接类
     302000	新闻类
     308000	菜谱类
     40001	参数key错误
     40002	请求内容info为空
     40004	当天请求次数已使用完
     40007	数据格式异常
     */
    public String code;

    public String text;

    public String url;

    public List<ResType> list;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ResType> getList() {
        return list;
    }

    public void setList(List<ResType> list) {
        this.list = list;
    }
}
