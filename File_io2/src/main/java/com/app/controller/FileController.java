package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.Exception.FileException;
import com.app.enitity.FileEntity;
import com.app.service.FileService;

@RestController
@RequestMapping("/fileio")
public class FileController {

	@Autowired
	private FileService service;
	
//	@PostMapping("/upload")
//	public ResponseEntity<String>uploadFile(@RequestParam("file")MultipartFile file) {
//		try {
//			service.uploadFile(file);
//			return ResponseEntity.ok("File Uploaded Successfully !");
//		} 
//		catch ( IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return ResponseEntity.badRequest().body("fail to upload");
//		}
//		
//	}
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) throws FileException {
		try {
			service.uploadFile(file);
			return "File uploaded Succefully "+file.getOriginalFilename();
		} catch (FileException  | IOException i) {
			// TODO Auto-generated catch block
			i.getMessage();
			throw new FileException("File uploading failed . file name: "+file.getOriginalFilename());
		}
	}

	
//	@GetMapping("/{id}")
//	public ResponseEntity<byte[]>downloadFile(@PathVariable Long id){		
//		return service.getFile(id).map(file -> ResponseEntity.ok()
//				.header("Content-Disposition", "attachment; filename=\"" + file.getFileName() + "\"")
//				.header("myheader", "my file = "+file.getFileType())
//				.body(file.getData()))
//				.orElse(ResponseEntity.notFound().build());
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FileEntity> downloadFile(@PathVariable(value = "id") long id) throws FileException{
		return ResponseEntity.ok(service.getFileById(id));				
	}
	
	@GetMapping() // file downloading by path inside postman ->body -> form data -> key = path (text) value = file path stored in database
	public ResponseEntity<FileEntity> downloadFile(@RequestParam(value = "path") String path) throws FileException{
		System.out.println("path : "+path);
		return ResponseEntity.ok(service.getFileByFilePath(path));				
	}
}
