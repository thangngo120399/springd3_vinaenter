package com.winno.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.httpinvoker.SimpleHttpInvokerServiceExporter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.winno.daos.NewsDao;
import com.winno.models.News;

@Controller
@RequestMapping("news")
public class NewsController {

	@Autowired
	private NewsDao newsDao;
	
	public static final String MSG_ERR = "Không tìm thấy id, vui lòng đọc tin khác";
	public static final String MSG_SUCCESS = "Thêm tin thành công";
	public static final String DIR_UPLOAD = "uploads";

	private List<News> listNews = new ArrayList<News>();

	public NewsController() {

	}

	@GetMapping("list")
	public String list(Model model) {

		return "news/list";
	}



	@GetMapping("detail/{id}")
	public String detail(@PathVariable int id, Model model, RedirectAttributes re) {

		News findNews = null;
		if(listNews.size() >0) {
			for (News news : listNews) {
				if (news.getId() == id) {
					findNews = news;
					break;
				}

			}
		}
		
		if (findNews == null) {
			re.addFlashAttribute("msgError", MSG_ERR);
			return "redirect:/news/list";
		}
		model.addAttribute("news", findNews);

		return "news/detail";

	}
	
	@GetMapping("add")
	public String add() {

		return "news/add";
	}
	
	@PostMapping("add")
	public String add(Model model,
			@ModelAttribute News news, HttpSession session, RedirectAttributes ra, 
			HttpServletRequest request,
			@RequestParam("pic") MultipartFile pic
			) throws IllegalStateException, IOException {
		if(!pic.isEmpty()) {
			String fileName = getFileNameServer(pic.getOriginalFilename());
			pic.transferTo(pathFile(fileName, DIR_UPLOAD , request));
			news.setPicture(fileName);
		}
		
		
		
		int id = 0;
		
		if(listNews.size() > 0) {
			id  = listNews.size();
		}
		
		news.setId(id);
		news.setCreatedDate(new Date());
	
		
		
		listNews.add(news);
		session.setAttribute("list", listNews);
		ra.addFlashAttribute("msgSuccess", "Thêm thành công");
		return "redirect:/news/list";
	}
	
	
	public String getFileNameServer(String fileName) {
		if(!StringUtils.isEmpty(fileName)) {
			String extension = FilenameUtils.getExtension(fileName);
			String baseName = FilenameUtils.getBaseName(fileName);
			
			StringBuilder builder = new StringBuilder();
			builder.append(baseName)
					.append("-")
					.append(System.nanoTime())
					.append(".")
					.append(extension);
			
			return builder.toString();
		}
		return StringUtils.EMPTY;
		
		
	}
	
	public File pathFile(String fileName, String folder, HttpServletRequest request) {
		String rootPath  = request.getServletContext().getRealPath("");
		File disry = new File(rootPath + folder);
		if(!disry.exists()) {
			disry.mkdirs();
		}
		
		File file = new File(rootPath + folder + "/" + fileName);
		
		System.out.println(rootPath + folder + "/" + fileName);
		return file;
		
	}
}
