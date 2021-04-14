package ru.test.mimimimetr.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.test.mimimimetr.demo.pojo.Cat;
import ru.test.mimimimetr.demo.servise.VoteService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileUploadController {
    private final VoteService voteService;

    @Autowired
    public FileUploadController(VoteService voteService) {
        this.voteService = voteService;
    }

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping(value = "/upload")
    public String addImage(Model model) {
        model.addAttribute("cat", new Cat());
        return "/upload";
    }

    @PostMapping(value = "/upload")
    public String createImg(
            @ModelAttribute("cat") Cat cat,
            @RequestParam("file")MultipartFile file) throws IOException {
        if (file != null) {
            File fileImg = new File(uploadPath);
            if (!fileImg.exists()) {
                fileImg.mkdir();
            }
            String uniqueName = UUID.randomUUID().toString();
            String resultFileName = uniqueName + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            cat.setFileName(resultFileName);
        }
        voteService.save(cat);
        return "redirect:/upload";
    }
}
