package com.app.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.app.Exception.FileException;
import com.app.enitity.FileEntity;
import com.app.repository.FileRepository;

@Service
@Transactional
public class FileService {

	@Value("${file.upload-dir}")
	private String uploadFilePath;
	
	@Autowired
	private FileRepository repo;
	
    public void uploadFile(MultipartFile file) throws IOException  {
//        String fileName = file.getOriginalFilename();
//        String fileType = file.getContentType();
//        byte[] data = file.getBytes();
//
//        FileEntity fileEntity = new FileEntity();
//        fileEntity.setFileName(fileName);
//        fileEntity.setFileType(fileType);
//        fileEntity.setData(data);
    	
    	FileEntity fileModel = new FileEntity();
    	
    	byte[] data = file.getBytes();
    	fileModel.setFile_name(file.getOriginalFilename());
    	fileModel.setFilePath(uploadFilePath+"/"+file.getOriginalFilename());
    	fileModel.setFile_type(file.getContentType());
    	fileModel.setCreated_at(LocalDate.now());
    	fileModel.setModified_at(LocalDate.now());
    	fileModel.setStatus("Just Created");
    	fileModel.setData(data);
    	
        repo.save(fileModel);
        System.out.println(fileModel);
    }

//    public Optional<FileEntity> getFile(Long id) {
//        return repo.findById(id);
//    }

    
    //------------------modification
    public FileEntity getFileById(long id) throws FileException {
    	Optional<FileEntity>optionalFile =  repo.findById(id);
    	FileEntity file = null;
    	if(optionalFile.isPresent()) {
    		file = optionalFile.get();
    	}else {
    		throw new FileException("File Not Found having id : "+id+" , Please Enter proper file id");
    	}
    	System.out.println("file is downloaded having name : "+file.getFile_name()+", having data: "+file.getData().length);
    	return file;
    }
    
    public FileEntity getFileByFilePath(String filePath) {
    	Optional<FileEntity> path =  repo.findByFilePath(filePath);
    	if(path.isPresent()) {
    		return path.get();
    	}else {
    		throw new FileException("File not Found having path : "+path);
    	}
    }
}
