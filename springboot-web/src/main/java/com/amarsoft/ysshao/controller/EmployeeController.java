package com.amarsoft.ysshao.controller;

import com.amarsoft.ysshao.dao.DepartmentDao;
import com.amarsoft.ysshao.dao.EmployeeDao;
import com.amarsoft.ysshao.entities.Department;
import com.amarsoft.ysshao.entities.Employee;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * @author ysshao
 * @create 2020-05-05 11:24
 */

@Controller
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工
    @GetMapping("/emps")
    public String queryEmps(Map<String,Object> map){
        Collection<Employee> all = employeeDao.getAll();
        map.put("empsdata",all);
        logger.info("查询所有员工信息...");
        return  "/emp/list";
    }

    //查询所有员工 对象
    @ResponseBody
    @GetMapping("/empslist")
    public  Collection<Employee>  queryEmpsList(Map<String,Object> map){
        Collection<Employee> all = employeeDao.getAll();
        map.put("empsdata",all);
        logger.info("查询所有员工信息...");
        return  all;
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //真正的员工添加
    /*
    *    SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    *
    * 注意实体类的日期 必须要传  yyyy/MM/dd  否则会进行前台校验。并且报错。
    *  或者是在yml文件中 自己指定格式。
    * 员工添加完毕后。 需要重新返回员工列表页面
    * */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面
        logger.info("保存的员工信息："+employee);
        //保存员工
        employeeDao.save(employee);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/emps";
    }

    //进入员工编辑页面
    //来到修改页面，查出当前员工，在页面回显
    // PathVariable 为路径变量

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);//返回该员工的信息
        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "emp/add";
    }


    @PutMapping("/emp")
    public String updateEmp(Employee employee ){
        logger.info("更新员工信息");
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id ){
        logger.info("删除员工信息");
        employeeDao.delete(id);
        return "redirect:/emps";
    }


}
