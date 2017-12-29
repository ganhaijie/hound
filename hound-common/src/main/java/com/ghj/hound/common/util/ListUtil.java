package com.ghj.hound.common.util;

import java.lang.reflect.Array;
import java.util.*;

public class ListUtil {
    
    private static final String REGEX = ",|，|;|；|\n|\r\n";
    
    /**
     * 按默认分隔符对字符串进行分隔，并裁剪分割后每个字符串的前后空格<br>
     * 默认分隔符：英文逗号、英文分号、中文逗号、中文分号，各种换行制表符
     */
    public static List<String> splitAndTrim(String src) {
        return splitTrim(src, REGEX);
    }
    
    /**
     * 按正则表达式对字符串进行分隔，并裁剪分割后每个字符串的前后空格<br>
     */
    public static List<String> splitTrim(String src, String regex) {
        if (regex == null || regex.isEmpty() || src == null || src.isEmpty()) {
            return null;
        }
        
        List<String> splitList = Arrays.asList(src.split(regex));
        List<String> dst = null;
        if (splitList != null && !splitList.isEmpty()) {
            dst = new ArrayList<String>();
            for (String str : splitList) {
                String trimedStr = str.trim();
                if (!isBlank(trimedStr)) {
                    dst.add(trimedStr);
                }
                
            }
        }
        
        return dst;
    }
    
    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 判断两个类型相同的List所含的元素个数和内容是否一样<br>
     * 列表为null和空，认为所含元素相等<br>
     * 泛型T必须实现comparable接口，能够比较
     */
    public static <T> boolean isElementEqual(List<T> srcList1, List<T> srcList2, Class<T> clazz) {
        List<T> list1 = (srcList1 == null || srcList1.isEmpty()) ? null : srcList1;
        List<T> list2 = (srcList2 == null || srcList2.isEmpty()) ? null : srcList2;
        
        if (list1 == list2) {
            return true;
        }
        if ((list1 == null && list2 != null) || (list1 != null && list2 == null)) {
            return false;
        } 
        if (list1.size() != list2.size()) {
            return false;
        }
        
        int length = list1.size();
        @SuppressWarnings("unchecked")
        T[] array1 = (T[])Array.newInstance(clazz, length);
        @SuppressWarnings("unchecked")
        T[] array2 = (T[])Array.newInstance(clazz, length);
        list1.toArray(array1);
        list2.toArray(array2);
        Arrays.sort(array1);
        Arrays.sort(array2);
        
        for (int i = 0; i < length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 对List去重去空，泛型T必须重写hashCode和equals函数
     */
    public static <T> List<T> removeDuplicationAndNull(List<T> src) {
        if (src == null || src.isEmpty()) {
            return src;
        }
        
        List<T> dst = new ArrayList<T>();
        Set<T> existSet = new HashSet<T>();
        for (T element : src) {
            if (element != null && existSet.add(element)) {
                dst.add(element);
            }
        }
        return dst;
    }
    
    /**
     * 是否含有重复元素，泛型T必须重写hashCode和equals函数
     */
    public static <T> boolean isDuplicate(List<T> src) {
        if (src == null || src.isEmpty()) {
            return false;
        }
        
        Set<T> existSet = new HashSet<T>();
        for (T element : src) {
            if (!existSet.add(element)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 对列表排序，T必须为Comparable
     */
    public static <T> List<T> sort(List<T> src) {
        if (src == null || src.isEmpty()) {
            return src;
        }
        
        @SuppressWarnings("unchecked")
        T[] array = (T[])src.toArray();
        Arrays.sort(array);
        return Arrays.asList(array);
    }
    
}
