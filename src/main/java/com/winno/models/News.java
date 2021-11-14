package com.winno.models;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class News {
	
	    private int id; 
	    
	    private String title;
	    
	    private String author;
	    
	    private Date createdDate;
	    
	    private String detail;
	    
	    private int status;
	    
	    private String picture;
	     
}
