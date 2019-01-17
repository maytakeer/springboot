package com.project.springBoot.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UploadController {
	
	private static String UPLOADED_FOLDER = "F://temp//";
	
	@GetMapping("/")
	public String index(){
		return "upload";
	}
	
	@RequestMapping("/file")
	public String index1(){
		return "from_file";
	}
	
	//4.3以来的新注释
	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes){
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message","Please select a file to upload");
			return "redirect:uploadStatus";
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER+file.getOriginalFilename());
			Files.write(path, bytes);
			redirectAttributes.addFlashAttribute("message","You seccessfully uploades '"+file.getOriginalFilename()+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/uploadStatus";
	}
	
	@GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
}
