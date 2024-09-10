package com.awsS3.service;


import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.awsS3.dao.FileDao;
import com.awsS3.model.FileVo;

@Service
@Transactional
public class FileServiceImp implements FileService{
	
	@Autowired
	private StorageService storageService;
	
	@Autowired
	private FileDao fileDao;

	@Override
	public String saveFile(MultipartFile file) {
		FileVo fileVo = new FileVo();
		Map<String, String> response = storageService.uploadFile(file);
		fileVo.setFileName(file.getOriginalFilename());
		fileDao.saveFileDetails(fileVo);
		return "File Added Successfully";
	}

	@Override
	public Byte[] getFile(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileVo> getAllFiles() {
		List<FileVo> fileVoList=this.fileDao.getAllFiles();
		for (FileVo fileVo : fileVoList) {
			String key="newFolderCreatedforTesting/"+fileVo.getFileName();
			fileVo.setSize(this.storageService.getObjectSize(key));	
		}
		return fileVoList;
	}

}
