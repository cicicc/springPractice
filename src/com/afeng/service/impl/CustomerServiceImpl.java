package com.afeng.service.impl;

import com.afeng.dao.CustomerDao;
import com.afeng.domain.Customer;
import com.afeng.service.CustomerService;
import com.afeng.utils.HibernateUtils;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerServiceImpl  implements CustomerService {
    private CustomerDao customerDao;

    /**
     * 开启事务 并调用dao层将action传来的数据存入数据库中
     * @param customer action传来的数据
     */
    @Override
    public void save(Customer customer) {
        //开启事务
        Transaction transaction = HibernateUtils.getCurrentSession().beginTransaction();
        customerDao.save(customer);
        System.out.println(customer);
        //提交事务
        transaction.commit();
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list =null;
        //开启事务
        Transaction transaction = HibernateUtils.getCurrentSession().beginTransaction();
        list = customerDao.findAll();
        //提交事务
        transaction.commit();

        return list;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
