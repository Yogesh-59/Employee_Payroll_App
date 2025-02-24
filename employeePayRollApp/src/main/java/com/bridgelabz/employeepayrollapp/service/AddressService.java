package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.AddressDTO;
import com.bridgelabz.employeepayrollapp.model.AddressModel;
import com.bridgelabz.employeepayrollapp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    public AddressRepository addressRepository;
    public AddressService(AddressRepository addressRepository){
        this.addressRepository=addressRepository;
    }
    public List<AddressModel> getAllContacts(){
        return addressRepository.findAll();
    }
    public AddressModel addEntry(AddressDTO addressDTO){
        AddressModel addressModel=new AddressModel();
        addressModel.setName(addressDTO.getName());
        addressModel.setPhoneNumber(addressDTO.getPhoneNumber());
        addressModel.setEmail(addressDTO.getEmail());
        return addressRepository.save(addressModel);
    }
}
