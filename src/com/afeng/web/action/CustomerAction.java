package com.afeng.web.action;

import com.afeng.domain.Customer;
import com.afeng.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer = new Customer();
    //之前之所以没有成功注入action层 是因为没有导入Struts和spring的结合包 所以就会无法注入 但是两边都不会报错
//    private CustomerService customerService ;
    @Override
    public Customer getModel() {
        return customer;
    }

    public String findAll(){
        CustomerService customerService =
                (CustomerService) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("customerService");
        List<Customer> list = customerService.findAll();
        ActionContext.getContext().put("list",list);
        return SUCCESS;
    }



    /**
     * 保存用户添加的客户信息
     * @return
     */
    public String save(){
//        System.out.println(customer);
        //调用service层处理保存数据应该有的业务逻辑 这里应该有一个返回值表示是否保存成功 但仅练手 不做过多的要求
        //System.out.println(customerService);
        CustomerService customerService =
                (CustomerService) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("customerService");
        customerService.save(customer);
        return "toList";
    }

    /**
     * 跳转到添加客户的页面
     * @return
     */
    public String add(){

        return "addPage";
    }

    /**
     * 为spring注入customerService提供set方法
     * @param customerService
     */
//    public void setCustomerService(CustomerService customerService) {
//        this.customerService = customerService;
//    }
}
