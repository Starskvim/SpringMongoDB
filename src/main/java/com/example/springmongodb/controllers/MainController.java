package com.example.springmongodb.controllers;

import com.example.springmongodb.dto.PrintModelWebDTO;
import com.example.springmongodb.services.SerializeService;
import com.example.springmongodb.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final TestService testService;
    private final SerializeService serializeService;
    private final MongoTemplate mongoTemplate;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("list", testService.getAll());
        model.addAttribute("models", mongoTemplate.findAll(PrintModelWebDTO.class));
        return "index";
    }

    @GetMapping("/createAndAdd")
    public String createAndAdd() {
        testService.createAndAddService();
        return "redirect:/";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(
            @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                serializeService.addNewModel(bytes);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Пустой файл");
        }
        return "redirect:/";
    }

}
