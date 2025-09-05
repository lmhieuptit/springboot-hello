package com.example.TestExternal;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping("/test")
//@CrossOrigin(origins = "*")
public class controller {
    @GetMapping("/1")
    private String test (){
        return "tesst";
    }
}
