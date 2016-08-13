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
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired(required = true)
    @Qualifier("employeeService")
    public void setEmployeeService(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String employeeList(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployees", this.employeeService.listEmployee());
        return "employee";
    }

    //For add and update person both
    @RequestMapping(value = "/employee/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee e){

        if (e.getId() == 0){
            //new employee, add it
            this.employeeService.addEmployee(e);
        }else {
            //existing employee, call update
            this.employeeService.updateEmployee(e);
        }
        return "redirect:/employee";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){

        this.employeeService.removeEmployee(id);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model){

        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        model.addAttribute("listEmployees", this.employeeService.listEmployee());
        return "employee";
    }
    @ModelAttribute("employee")
    public Employee loadEmptyModelBean(){
        return new Employee();
    }
}
