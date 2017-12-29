package com.ghj.hound.service.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpringUtil implements ApplicationContextAware{
    
    private static ApplicationContext ac = null;
   
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ac = applicationContext;
    }
    
    public static ApplicationContext getApplicationContext() {
        return ac;
    }
    /**
     * 得到spring中定义的一个bean
     * @param beanName  bean的id
     * @return
     */
    public static Object getBean(String beanName){
        return ac.getBean(beanName);
    }
    
    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
    	return ac.getBeansOfType(clazz);
    }
    
    /**
     * 得到spring中相应类型的一个bean(必须有@Component定义过)
     * @param clazz bean类型
     * @return
     */
    public static <T> T getBean(Class<T>  clazz){
        return ac.getBean(clazz);
    }
}
