package com.app.enitity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "filetbl")
@Getter
@Setter

public class FileEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fileName;

    @Column
    private String fileType;

    @Lob
    @Column
    private byte[] data;

    public FileEntity() {
    	
    }

	public FileEntity(Long id, String fileName, String fileType, byte[] data) {
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	@Override
	public String toString() {
		return "FileEntity [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", data="
				+ (data != null ? data.length : 0) + "]";
	}
      
}
