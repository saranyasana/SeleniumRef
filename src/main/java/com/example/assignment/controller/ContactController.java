package com.example.assignment.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.model.Contacts;
import com.example.assignment.repo.ContactRepo;
import com.example.assignment.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {

	@Autowired
	ContactService contactService;
	@Autowired
	ContactRepo contactsRepository;

	@GetMapping("/all")
	public List<Contacts> getAll() {
		return contactService.getAllContacts();
	}

	@PostMapping("/createContact")
	public Contacts createUserDetails(@RequestBody Contacts contacts) {
		return contactService.createContacts(contacts);
	}

	@GetMapping("/user/{name}")
	public Optional<Contacts> getContactByName(@PathVariable String name) {
		return contactService.getContactByName(name);
	}

	@GetMapping("/{device}")
	public Contacts getContactByDevice(@PathVariable String device) {
		return contactsRepository.findByDevice(device);
	}


	@PutMapping("updateByDeviceName/{device}") 
	public String modifyByDeviceName(@PathVariable("device") String device, @Valid @RequestBody Contacts contact)
	{ Contacts temp = contactsRepository.findByDevice(device);
	if(temp != null) {
		temp.setEmail(contact.getEmail());
		temp.setName(contact.getName());
		temp.setPhoneNumber(contact.getPhoneNumber()); 
		contactsRepository.save(temp);
		return temp.toString();
	}
	return "Invalid Request";
	}


	@DeleteMapping("/delete/{name}")
	public String deleteUserDetails(@PathVariable String name) {
		return contactService.deleteContacts(name);
	}

	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		return contactService.deleteAll();
	}

}
