package com.app.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.app.enitity.FileEntity;
import com.app.repository.FileRepository;

@Service
@Transactional
public class FileService {

	@Autowired
	private FileRepository repo;
	
    public void uploadFile(MultipartFile file) throws IOException  {
        String fileName = file.getOriginalFilename();
        String fileType = file.getContentType();
        byte[] data = file.getBytes();

        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(fileName);
        fileEntity.setFileType(fileType);
        fileEntity.setData(data);

        repo.save(fileEntity);
    }

    public Optional<FileEntity> getFile(Long id) {
        return repo.findById(id);
    }

}
