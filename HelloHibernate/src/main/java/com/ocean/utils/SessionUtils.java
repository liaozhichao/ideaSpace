package com.ocean.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * @Author: spring
 * @Description:
 * @Date: Created in 2017/9/17 20:05
 */
public class SessionUtils {
    private static SessionFactory sessionFactory;
    static {
        //1.创建一个Configuration对象
        Configuration configuration = new Configuration().configure();
        //2.创建一个ServiceRegistery对象,Hibernate的任何服务都要经过此对象的注册
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                                                .applySettings(configuration.getProperties())
                                                .buildServiceRegistry();
        //3.创建sessionFactory
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }
}
