package com.ocean;

import com.ocean.beans.NewsEntity;
import com.ocean.utils.SessionUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * @Author: spring
 * @Description:
 * @Date: Created in 2017/9/17 19:41
 */
public class TestHibnernate {

    private Session session;

    private Transaction transaction;
    @Before
    public void before(){
        session = SessionUtils.getSession();
    }

    @Test
    public void testSessionCache(){

    }

    //使用load方法加载对象,懒加载,
    // 当我们需要用到这个对象的时候才会真正到数据库中去查找
    @Test
    public void testLoad(){
        //进行强转
        NewsEntity news1 = (NewsEntity) session.load(NewsEntity.class,1);
        System.out.println(news1);
    }


    //使用get方法返回查找对象,如果缓存中找不到会直接到数据库中去找
    @Test
    public void testGet(){
        //进行强转
        NewsEntity news1 = (NewsEntity) session.get(NewsEntity.class,1);
        System.out.println(news1);
    }

    @Test
    public void testSave(){
        //1.开启事务
        transaction = session.beginTransaction();
        //2.创建对象
        NewsEntity news1 = new NewsEntity("王羲之","兰亭集序","永和九年,岁在癸丑",new Date());
        //3.存储对象
        session.save(news1);
    }

    @After
    public void after(){
        //提交事务
        transaction.commit();
        //关闭事务和session
        session.close();
    }
}
