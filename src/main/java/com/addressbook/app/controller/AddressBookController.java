package com.addressbook.app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping("/test")
    public String testApi() {
        return "Address Book API is working!";
    }

}
