package com.afeng.dao.impl;

import com.afeng.dao.CustomerDao;
import com.afeng.domain.Customer;
import com.afeng.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class CustomerDaoImpl  implements CustomerDao {
    @Override
    public void save(Customer customer) {
        //获得session对象
        Session session = HibernateUtils.getCurrentSession();
        //将传来的customer对象进行保存
//        customer.setCust_id(11);
        session.save(customer);
//        System.out.println(customer);
    }

    @Override
    public List<Customer> findAll() {
        //获得session对象
        Session session = HibernateUtils.getCurrentSession();
        //查询数据库中所有Customer
        List<Customer> list = session.createCriteria(Customer.class).list();
        return list;
    }
}
