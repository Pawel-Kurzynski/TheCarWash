package com.pablo.springCRUD1.controller;

import com.pablo.springCRUD1.model.Address;
import com.pablo.springCRUD1.model.Car;
import com.pablo.springCRUD1.model.CarInfo;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @ModelAttribute("client")
    public Client loadEmptyModelBean(){
        return new Client();
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

    @RequestMapping(value = "/edit/{id}")
    public String editClient(@PathVariable("id")int id, Model model){

        model.addAttribute("client", this.clientService.getClientById(id));
        model.addAttribute("listClients", this.clientService.listClient());

        return "client";
    }

    //address
    //take address matching by client id
    @RequestMapping(value = "address/{id}",method = RequestMethod.GET)
    public String addressClient(@PathVariable("id")int id, Model model){

        model.addAttribute("address", this.addressService.getAddressById(id));
        return "address";
    }

    //editing existing address
    @RequestMapping(value = "/address/add", method = RequestMethod.POST)
    public String addAddress(@ModelAttribute("address")Address a){

        if (a.getId()==0){
            this.addressService.addAddress(a);
        }
        else {
            this.addressService.updateAddress(a);
        }
        return "address";
    }
    @RequestMapping(value = "/carlist/add", method = RequestMethod.POST)
    public String addCar(@ModelAttribute("car")Car car, RedirectAttributes rd){
        if (car.getId()==0){
            this.carService.addCar(car);
        }
        else {
            this.carService.updateCar(car);
        }
        rd.addAttribute("clientID",car.getClient().getId());
//        model.addAttribute("listCars", this.carService.listCars(car.getClient().getId()));
        String url = "redirect:/client/carlist/{clientID}";

        return url;
    }
    @RequestMapping(value = "carlist/{id}",method = RequestMethod.GET)
    public String carList(@PathVariable("id")int clientID, Model model){

        Client client = this.clientService.getClientById(clientID);

        model.addAttribute("car", new Car(client));
        model.addAttribute("listCars", this.carService.listCars(clientID));
        return "car";
    }

    @RequestMapping(value = "carlist/{clientId}/edit/{carId}",method = RequestMethod.GET)
    public String editCar(@PathVariable("clientId")int clientID,
                          @PathVariable("carId")int carID,
                          Model model){
        model.addAttribute("car", this.carService.getCarById(carID));
        model.addAttribute("listCars", this.carService.listCars(clientID));
        return "car";
    }
}
