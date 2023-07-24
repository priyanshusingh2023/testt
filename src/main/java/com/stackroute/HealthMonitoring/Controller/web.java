package com.stackroute.HealthMonitoring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Priyanshu Singh
 */

@Controller
public class web {



 @GetMapping("/")
 public String getIndex() {
  return "index.html";
 }
}
