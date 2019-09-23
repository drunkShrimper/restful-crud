package com.scau.net17.lipan.restfulcrud.controller;

import com.scau.net17.lipan.restfulcrud.dao.DepartmentDao;
import com.scau.net17.lipan.restfulcrud.dao.EmployeeDao;
import com.scau.net17.lipan.restfulcrud.entities.Department;
import com.scau.net17.lipan.restfulcrud.entities.Employee;
import com.scau.net17.lipan.restfulcrud.exception.UserNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String queryAll(Model model){

        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){

        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable(value="id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }


    @PutMapping("/emp")
    public String updateEmp(Employee employee){

        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteById(@PathVariable(value="id") Integer id){

        employeeDao.delete(id);
        return "redirect:/emps";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("username")String username){
        if("aaa".equals(username)){
            throw new UserNotfoundException();
        } else{
            return "success";
        }
    }
}
