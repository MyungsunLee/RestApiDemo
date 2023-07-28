package com.lms.restapidemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

  @RequestMapping("/home")
  public static String home() {

    System.out.println("in /");
    return "/home.html";
  }

  /*@GetMapping("/member")
  public static String*/
}
