package com.pablo.springCRUD1.controller;

import com.pablo.springCRUD1.model.Client;
import com.pablo.springCRUD1.service.AddressService;
import com.pablo.springCRUD1.service.CarService;
import com.pablo.springCRUD1.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Pablo on 17.08.2016.
 */
@Controller
@RequestMapping(value = "client")
public class ClientController {

    private ClientService clientService;
    private AddressService addressService;
    private CarService carService;

    @Autowired(required = true)
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired(required = true)
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @Autowired(required = true)
    public void setCarService(CarService carService) {
        this.carService = carService;
    }



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String clientList(Model model){
        model.addAttribute("client", new Client());
        model.addAttribute("listClients", this.clientService.listClient());
        return "client";
    }
    //For add and update, (client address, phone number)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addClinet(@ModelAttribute("client")Client c){

        if (c.getId()==0){
            this.clientService.addClient(c);
        }
        else {
            this.clientService.updateClient(c);
        }
        return "redirect:/client";
    }
    @RequestMapping("/remove/{id}")
    public String removeClient(@PathVariable("id")int id){
        this.clientService.removeClient(id);
        return "redirect:/client";
    }

    @RequestMapping(value = "edit/{id}")
    public String editClient(@PathVariable("id")int id, Model model){

        model.addAttribute("client", this.clientService.getClientById(id));
        model.addAttribute("listClients", this.clientService.listClient());

        return "client";
    }
    @ModelAttribute("client")
    public Client loadEmptyModelBean(){
        return new Client();
    }

    @RequestMapping(value = "address/{id}")
    public String addressClient(@PathVariable("id")int id, Model model){

        model.addAttribute("Address", this.addressService.listAddress(id));
        return "client";
    }
}
