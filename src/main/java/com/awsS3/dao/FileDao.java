package com.awsS3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awsS3.model.FileVo;

public interface FileDao {
	
	void saveFileDetails(FileVo fileVo);
	
	List<FileVo> getAllFiles();

}
