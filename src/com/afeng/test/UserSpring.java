package com.afeng.test;


import com.afeng.dao.UserDao;
import com.afeng.test.pojo.Car;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserSpring {
    /**
     * 练习基本代码的书写
     */
    @Test
    public void sayHello2Spring(){
        //加载spring的配置文件 获取上下文对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从上下文对象中获取想要获取的数据
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.sayHello();
    }

    /**
     * 练习依赖注入中的属性注入
     */
    @Test
    public void testCarDI() {
        //加载spring配置文件 获取上下文对象
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //使用上下文对象获取bean
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car.getColor() + "的" + car.getName());
    }

    /**
     * 练习依赖注入中的构造注入:不太常用
     */
    @Test
    public void testCarDI2() {
        //获取上下文对象
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得注入的bean对象
        Car newCar = (Car) applicationContext.getBean("newCar");
        System.out.println(newCar);
    }
}
