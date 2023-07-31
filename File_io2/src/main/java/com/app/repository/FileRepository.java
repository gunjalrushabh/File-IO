package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.enitity.FileEntity;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
	
//	FileEntity findByFilePath(String path); // don't do it
	Optional<FileEntity> findByFilePath(String path);
}
