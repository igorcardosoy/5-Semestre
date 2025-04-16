package br.com.ifsp.arq.exer1.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProfileController {

    @GetMapping("profile")
    public String profile(
            @RequestParam(name = "name", defaultValue = "anonymous") String name,
            @RequestParam(name = "profession", defaultValue = "unemployed") String profession,
            @RequestParam(name = "phone", defaultValue = "9999999999") String phone,
            Model model
    ){

        model.addAttribute("name", name);
        model.addAttribute("profession", profession);
        model.addAttribute("phone", phone);

        return "profile";
    }}
