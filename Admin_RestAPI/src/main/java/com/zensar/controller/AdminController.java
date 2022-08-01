package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.AdminDTO;
import com.zensar.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping(value = "/user", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<AdminDTO> registerAdmin(@RequestBody AdminDTO admin) {
        AdminDTO adminDTO=this.adminService.registerAdmin(admin);
        return new ResponseEntity<AdminDTO>(adminDTO,HttpStatus.CREATED);
    }

    @PutMapping(value = "/user/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<AdminDTO>  updateAdmin(@PathVariable int id, @RequestBody AdminDTO data) {
	    AdminDTO adminDTO=this.adminService.updateAdmin(id, data);
    	return new ResponseEntity<AdminDTO>(adminDTO,HttpStatus.OK);

    }

    @GetMapping(value = "/user", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<AdminDTO>>  adminList() {
    	List<AdminDTO> adminDTO=this.adminService.adminList();
	return new ResponseEntity<List<AdminDTO>>(adminDTO,HttpStatus.OK) ;
    }

    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<AdminDTO>> searchByCriteria(@RequestParam(name = "name", required = false) String name) {
        List<AdminDTO> adminDTO=this.adminService.searchByCriteria(name);
    return new ResponseEntity<List<AdminDTO>>(adminDTO,HttpStatus.OK);
    }
    
    @GetMapping(value = "/user/{id}",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<AdminDTO> userDetailsById(@PathVariable int id){
    	AdminDTO adminDTO=this.adminService.userDetailsById(id);
		return new ResponseEntity<AdminDTO>(adminDTO,HttpStatus.OK);
    	
    }
    
    @DeleteMapping(value="/user/{id}" ,produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Boolean> deleteUserById(@PathVariable int id){
    	return new ResponseEntity<Boolean>(adminService.deleteUserById(id), HttpStatus.OK);
    }

}
