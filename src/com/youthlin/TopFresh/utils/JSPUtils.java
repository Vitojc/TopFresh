package com.youthlin.TopFresh.utils;
//Only a type can be imported. XYZ resolves to a package.
//出错原因可能是包名是小写的utils，但之前可能是Utils，后来改成的小写，删掉out目录重新生成即可

import java.text.MessageFormat;

/**
 * Created by lin on 2016-05-26-026.
 * JSP页面工具类
 */
public class JSPUtils {
    //"<li><a href=\"xxx?pageNo={0}\">{1}</a></li>"     //normal
    //"<li{0}><span>{1}</span></li>"                    //current,disabled
    public static String pagination(int current, int last, String normal, String currentOrDisabled,
                                    String prevText, String nextText) {
        //一共才一页，不需要分页
        if (last == 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String temp;
        if (current > 1) {          //有上一页
            temp = MessageFormat.format(normal, current - 1, prevText);
        } else {                    //上一页不可点击
            temp = MessageFormat.format(currentOrDisabled, " class=\"disabled prev\"", prevText);
        }
        sb.append(temp);
        for (int i = 1; i <= last; i++) {
            if (i == current) {
                temp = MessageFormat.format(currentOrDisabled, " class=\"active current\"", i);
            } else {
                temp = MessageFormat.format(normal, i, i);
            }
            sb.append(temp);
        }
        if (current == last) {      //下一页不可点击
            temp = MessageFormat.format(currentOrDisabled, " class=\"disabled next\"", nextText);
        } else {
            temp = MessageFormat.format(normal, current + 1, nextText);
        }
        sb.append(temp);
        return sb.toString();
    }
}
