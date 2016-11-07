package com.pablo.springCRUD1.controller;

import com.pablo.springCRUD1.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.pablo.springCRUD1.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Pablo on 03.08.2016.
 */
@Secured("ROLE_MANAGER")
@Controller
@RequestMapping("employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired(required = true)
    @Qualifier("employeeService")
    public void setEmployeeService(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @RequestMapping(value = "logout")
    public String logout (HttpServletRequest request, HttpServletResponse response){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/client";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String employeeList(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployees", this.employeeService.listEmployee());
        return "employee";
    }

    //For add and update person both
    @RequestMapping(value = "/add", method = RequestMethod.POST)
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

    @RequestMapping(value = "/search")
    public String findEmployeeByName(@RequestParam("name")String name, Model model){

        model.addAttribute("listEmployees", this.employeeService.getEmployeeByName(name));
        return "employee";
    }

    @ModelAttribute("employee")
    public Employee loadEmptyModelBean(){
        return new Employee();
    }
}
