package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.AddressDTO;
import com.bridgelabz.employeepayrollapp.model.AddressModel;
import com.bridgelabz.employeepayrollapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
     public AddressController(AddressService addressService){
         this.addressService=addressService;
     }
     @GetMapping("/contacts")
     public ResponseEntity<List<AddressModel>> getAllContacts(){
         return ResponseEntity.ok(addressService.getAllContacts());
     }
    @PostMapping("/add")
    public ResponseEntity<AddressModel> addEntry(@RequestBody AddressDTO addressDTO){
        AddressModel newEntry=addressService.addEntry(addressDTO);
        return ResponseEntity.ok(newEntry);
    }
}
