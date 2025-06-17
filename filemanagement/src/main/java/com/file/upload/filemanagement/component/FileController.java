package com.file.upload.filemanagement.component;

import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import com.file.upload.filemanagement.model.FileModel;


@Controller
public class FileController {
	@Autowired
	StandardServletMultipartResolver multipartResolver;
	
	@RequestMapping(method = RequestMethod.GET,value = "/uploadFile")
	public void prepareFileUpload(Model data) {
		data.addAttribute("fileUploader",new FileModel());
		
//		return "uploadFile";
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/uploadFile")
	public String uploadFile(@ModelAttribute("fileUploader")FileModel fileModel) {
		try (FileOutputStream fos = new FileOutputStream("D:\\FileUploads\\"+ fileModel.getFileAttachment().getOriginalFilename())){
			fos.write(fileModel.getFileAttachment().getBytes());
			
			return "success";
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
		
	}
}
