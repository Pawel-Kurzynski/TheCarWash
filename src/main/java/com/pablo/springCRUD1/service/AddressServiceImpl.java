package com.pablo.springCRUD1.service;

import com.pablo.springCRUD1.dao.AddressDAO;
import com.pablo.springCRUD1.model.Address;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pablo on 30.08.2016.
 */
@Service
public class AddressServiceImpl implements AddressService {

    private AddressDAO addressDAO;

    public void setAddressDAO(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @Override
    @Transactional
    public void addAddress(Address a) {
        this.addressDAO.addAddress(a);
    }

    @Override
    @Transactional
    public void updateAddress(Address a) {
        this.addressDAO.updateAddress(a);
    }

    @Transactional
    @Override
    public List<Address> listAddress() {
        return this.addressDAO.listAddress();
    }

    @Transactional
    @Override
    public Address getAddressById(int id) {
        return this.addressDAO.getAddressById(id);
    }

    @Transactional
    @Override
    public void removeAddress(int id) {
        this.addressDAO.removeAddress(id);
    }
}
