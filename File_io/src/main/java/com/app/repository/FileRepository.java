package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.enitity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Long> {

}
