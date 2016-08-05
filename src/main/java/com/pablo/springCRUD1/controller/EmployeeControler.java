package com.pablo.springCRUD1.controller;

import com.pablo.springCRUD1.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.pablo.springCRUD1.service.EmployeeService;

/**
 * Created by Pablo on 03.08.2016.
 */
@Controller
public class EmployeeControler {

    private EmployeeService employeeService;

    @Autowired(required = true)
    @Qualifier("employeeService")
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employeeList(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployee", this.employeeService.listEmployee());
        return "employee";
    }

    //For add and update person both
    @RequestMapping(value = "/employee/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("person") Employee e){

        if (e.getEmployeeID() == 0){
            //new employee, add it
            this.employeeService.addEmployee(e);
        }else {
            //existing employee, call update
            this.employeeService.updateEmployee(e);
        }
        return "redirect:/employees";
    }

    @RequestMapping(value = "employees/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){

        this.employeeService.removeEmployee(id);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/edit{id}")
    public String editEmployee(@PathVariable("id") int id, Model model){

        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        model.addAttribute("listEmployees", this.employeeService.listEmployee());
        return "employee";
    }
}
