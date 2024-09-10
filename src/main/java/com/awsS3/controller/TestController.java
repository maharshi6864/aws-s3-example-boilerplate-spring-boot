package com.awsS3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.awsS3.model.FileVo;
import com.awsS3.service.FileService;

@RestController
public class TestController {
	
	@Autowired
	private FileService fileService;
	
	@GetMapping(value="/")
	public ModelAndView viewFiles()
	{
		List<FileVo> fileVoList=this.fileService.getAllFiles();
		return new ModelAndView("uploadFile","fileVoList",fileVoList);
	}
	
	@PostMapping(value="/uploadFile")
	public ModelAndView uploadFile(MultipartFile fileToBeUploaded,HttpServletRequest request)
	{
		fileService.saveFile(fileToBeUploaded);
		return new ModelAndView("redirect:/");
	}


}
