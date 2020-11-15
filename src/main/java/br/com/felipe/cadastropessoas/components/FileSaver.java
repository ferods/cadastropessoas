package br.com.felipe.cadastropessoas.components;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class FileSaver {
	
	
	@Autowired
	HttpServletRequest request;

	public String write(String basefolder, MultipartFile imagem) {
		
		try {
			String realPath = request.getServletContext().getRealPath("/" + basefolder);
			new File(realPath).mkdir();
			String path = realPath + "/" + imagem.getOriginalFilename();
			imagem.transferTo(new File(path));
			
			return "\\" + basefolder + "\\"  + imagem.getOriginalFilename();
			
		} catch (IOException | IllegalStateException e) {
			throw new RuntimeException(e);
		} 
		
	}

}
