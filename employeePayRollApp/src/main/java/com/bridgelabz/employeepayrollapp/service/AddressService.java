package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.AddressDTO;
import com.bridgelabz.employeepayrollapp.model.AddressModel;
import com.bridgelabz.employeepayrollapp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    public  AddressRepository addressRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository){

        this.addressRepository=addressRepository;
    }
    public List<AddressModel> getAllContacts(){

        return addressRepository.findAll();
    }
    public Optional<AddressModel> getContactById(Long id){
        return addressRepository.findById(id);
    }
    public AddressModel addEntry(AddressDTO addressDTO){
        AddressModel addressModel=new AddressModel();
        addressModel.setName(addressDTO.getName());
        addressModel.setPhoneNumber(addressDTO.getPhoneNumber());
        addressModel.setEmail(addressDTO.getEmail());
        return addressRepository.save(addressModel);
    }
    public Optional<AddressModel> updateEntry(Long id, AddressDTO addressDTO){
        Optional<AddressModel> existingContact=addressRepository.findById(id);
        if(existingContact.isPresent()){
            AddressModel addressModel=existingContact.get();
            addressModel.setName(addressDTO.getName());
            addressModel.setPhoneNumber(addressDTO.getPhoneNumber());
            addressModel.setEmail(addressDTO.getEmail());
            return Optional.of(addressRepository.save(addressModel));
        }
        return Optional.empty();
    }
    public boolean deleteEntry(Long id){
        if(addressRepository.existsById(id)){
            addressRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
