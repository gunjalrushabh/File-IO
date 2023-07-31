package com.app.enitity;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "filetbl2")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long file_id;

    @Column
    private String file_name;

    @Column
    private String file_type;
    
    @Column(name = "file_path")
    private String filePath;
    
    @Column
    private LocalDate created_at;
    
    @Column
    private LocalDate modified_at;
    
    @Column
    private String status;

    @Column
    private byte []data;
    
	@Override
	public String toString() {
		return "FileEntity [file_id=" + file_id +
				",\n file_name=" + file_name + 
				",\n file_type=" + file_type+ 
				",\n file_path=" + filePath + 
				",\n created_at=" + created_at + 
				",\n modified_at=" + modified_at
				+ ",\n status=" + status +" data: "+(data!= null ? data.length:0)+ "]";
	}


    
      
}
