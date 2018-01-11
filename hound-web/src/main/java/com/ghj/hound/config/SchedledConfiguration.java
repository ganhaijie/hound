package com.ghj.hound.config;


import com.ghj.hound.schedule.CoinSchedule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.ParseException;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class SchedledConfiguration {

    // 配置中设定了
    // ① targetMethod: 指定需要定时执行scheduleInfoAction中的simpleJobTest()方法
    // ② concurrent：对于相同的JobDetail，当指定多个Trigger时, 很可能第一个job完成之前，
    // 第二个job就开始了。指定concurrent设为false，多个job不会并发运行，第二个job将不会在第一个job完成之前开始。
    // ③ cronExpression：0/10 * * * * ?表示每10秒执行一次，具体可参考附表。
    // ④ triggers：通过再添加其他的ref元素可在list中放置多个触发器。 scheduleInfoAction中的simpleJobTest()方法
    @Bean(name = "detailFactoryBean")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(CoinSchedule coinSchedule) {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        //这儿设置对应的Job对象
        bean.setTargetObject(coinSchedule);
        //这儿设置对应的方法名  与执行具体任务调度类中的方法名对应
        bean.setTargetMethod("coinPatch");
        //concurrent属性实际是将job推迟执行了
        bean.setConcurrent(false);
        return bean;
    }

    @Bean(name = "cronTriggerBean")
    public CronTriggerFactoryBean cronTriggerBean(MethodInvokingJobDetailFactoryBean detailFactoryBean) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(detailFactoryBean.getObject());
        try {
            //trigger.setCronExpression("0 0 2 1/1 * ? ");//这个时间是每天2点的时候执行一次
            trigger.setCronExpression("0/10 * * ? * *");//每5秒执行一次
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return trigger;

    }

    @Bean
    public SchedulerFactoryBean schedulerFactory(CronTriggerFactoryBean cronTriggerBean) {
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
        schedulerFactory.setTriggers(cronTriggerBean.getObject());
        return schedulerFactory;
    }
}