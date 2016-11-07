package com.pablo.springCRUD1.controller;

import com.pablo.springCRUD1.Entity.Address;
import com.pablo.springCRUD1.Entity.Car;
import com.pablo.springCRUD1.Entity.Client;
import com.pablo.springCRUD1.service.AddressService;
import com.pablo.springCRUD1.service.CarService;
import com.pablo.springCRUD1.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Pablo on 17.08.2016.
 */
@Secured({"ROLE_EMPLOYEE", "ROLE_MANAGER"})
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


    @RequestMapping(value = "logout")
    public String logout (HttpServletRequest request, HttpServletResponse response){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

     /*
    * Operations on customer:
    * adding new customer
    * getting existing one
    * updating customer data
    * removing existing customer
    * JSP file - "client"
    */

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

    /*
    * The customer at start had already attached empty address,
    * operations on customer address:
    * editing customer address data
    * getting address form current customer
    * JSP file - "address"
    */

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

    /*
    * Operations on car attached to a customer:
    * adding new one
    * getting existing
    * editing
    * removing
    * JSP file - "car"
    */

    //adding and updating operation
    @RequestMapping(value = "/carlist/add", method = RequestMethod.POST)
    public String addCar(@ModelAttribute("car")Car car, RedirectAttributes ra){
        if (car.getId()==0){
            this.carService.addCar(car);
        }
        else {
            this.carService.updateCar(car);
        }
        ra.addAttribute("clientID",car.getClient().getId());
//        model.addAttribute("listCars", this.carService.listCars(car.getClient().getId()));
        String url = "redirect:/client/carlist/{clientID}";

        return url;
    }
    //reviewing existing clients cars
    @RequestMapping(value = "carlist/{id}",method = RequestMethod.GET)
    public String carList(@PathVariable("id")int clientID, Model model){

        Client client = this.clientService.getClientById(clientID);

        model.addAttribute("car", new Car(client));
        model.addAttribute("listCars", this.carService.listCars(clientID));
        return "car";
    }

    //getting specific car for edit
    @RequestMapping(value = "carlist/{clientId}/edit/{carId}",method = RequestMethod.GET)
    public String editCar(@PathVariable("clientId")int clientID,
                          @PathVariable("carId")int carID,
                          Model model){
        model.addAttribute("carInfo", this.carService.getCarById(carID));
        model.addAttribute("listCars", this.carService.listCars(clientID));
        return "car";
    }

    //remove car
    @RequestMapping("carlist/{clientId}/remove/{carId}")
    public String removeCar(@PathVariable("carId")int carID,
                            @PathVariable("clientId")int clientID,
                            RedirectAttributes ra){
        this.carService.removeCar(carID);

        ra.addAttribute("clientID",clientID);
        String url = "redirect:/client/carlist/{clientID}";

        return url;
    }
}
