package com.file.upload.filemanagement.model;



import org.springframework.web.multipart.MultipartFile;


public class FileModel {
	MultipartFile fileAttachment;

	public MultipartFile getFileAttachment() {
		return fileAttachment;
	}

	public void setFileAttachment(MultipartFile fileAttachment) {
		this.fileAttachment = fileAttachment;
	}
	
	
}
