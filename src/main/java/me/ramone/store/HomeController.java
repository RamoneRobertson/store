package me.ramone.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Tell Spring this class is a web controller
@Controller
public class HomeController {
    @Value("${spring.application.name}")
    private String appName;

    // another annotation that tells the controller how to handle the endpoint /
    @RequestMapping("/") // This annotation requires a
    public String index(){
        System.out.println("App Name: " + appName);
        // Whenever a request is mad to the endpoint / or root return the index.html page
        return "index.html";
    }


}
