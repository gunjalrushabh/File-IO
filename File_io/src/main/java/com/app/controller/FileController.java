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

import com.app.service.FileService;

@RestController
@RequestMapping("/fileio")
public class FileController {

	@Autowired
	private FileService service;
	
	@PostMapping("/upload")
	public ResponseEntity<String>uploadFile(@RequestParam("file")MultipartFile file){
		
		try {
			service.uploadFile(file);
			return ResponseEntity.ok("File Uploaded Successfully !");
		} catch (IOException e) {
			
			e.printStackTrace();
			return ResponseEntity.badRequest().body("fail to upload");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<byte[]>downloadFile(@PathVariable Long id){
		
		return service.getFile(id).map(file -> ResponseEntity.ok()
				.header("Content-Disposition", "attachment; filename=\"" + file.getFileName() + "\"")
				.body(file.getData()))
				.orElse(ResponseEntity.notFound().build());
	}	
	
}
