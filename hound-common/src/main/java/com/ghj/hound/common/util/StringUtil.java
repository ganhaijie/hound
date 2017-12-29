package com.ghj.hound.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	public static String toString(Object obj) {
		return obj == null ? null : obj.toString();
	}
	
	/**
     * <p>Checks if a String is whitespace, empty ("") or null after String.trim().</p>
     *
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     */
	public static boolean isBlankAfterTrim(final String str) {
	    if (str == null) {
	        return true;
	    }
	    
	    return StringUtils.isBlank(str.trim());
	}
	
	private static final String REG_EX="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
	
	
	public static boolean checkIllegalCharacter(String str){
		Pattern p = Pattern.compile(REG_EX);
		Matcher m = p.matcher(str);
		return m.find();
	}
	
    /**
     * 用于返回查询的对象的String形式
     * 如果为空则返""
     * @param obj
     * @return
     */
    public static String getStringValue(Object obj) {
        if (obj != null) {
            return obj.toString();
        } else {
            return "";
        }
    }
	
}
