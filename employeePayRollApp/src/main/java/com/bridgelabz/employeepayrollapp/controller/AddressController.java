package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.AddressDTO;
import com.bridgelabz.employeepayrollapp.model.AddressModel;
import com.bridgelabz.employeepayrollapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
     @GetMapping("/contact/{id}")
     public ResponseEntity<Optional<AddressModel>> getContactById(@PathVariable Long id){
         Optional<AddressModel> contact=addressService.getContactById(id);
         return contact.isPresent() ?ResponseEntity.ok(contact):ResponseEntity.notFound().build();
     }
    @PostMapping("/add")
    public ResponseEntity<AddressModel> addEntry(@RequestBody AddressDTO addressDTO){
        AddressModel newEntry=addressService.addEntry(addressDTO);
        return ResponseEntity.ok(newEntry);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<AddressModel> updateEntry(@PathVariable Long id,@RequestBody AddressDTO addressDTO){
         Optional<AddressModel> updateEntry=addressService.updateEntry(id,addressDTO);
         return updateEntry.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id) {
        boolean isDeleted = addressService.deleteEntry(id);
        return isDeleted ? ResponseEntity.ok("Contact deleted successfully ") : ResponseEntity.notFound().build();
    }
}
