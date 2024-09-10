package com.awsS3.service;

import java.util.List;

import org.springframework.http.HttpRequest;
import org.springframework.web.multipart.MultipartFile;

import com.awsS3.model.FileVo;

public interface FileService {
	
	String saveFile(MultipartFile file);
	
	Byte[] getFile(String fileName);
	
	List<FileVo> getAllFiles();

}
