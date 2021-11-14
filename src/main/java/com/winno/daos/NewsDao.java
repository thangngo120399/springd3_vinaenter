package com.winno.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.winno.models.News;

@Repository
public class NewsDao {

	public List<News> getList() {
		List<News> datas = new ArrayList<News>();

		datas.add(new News(1, "Tin tức 1", "John", new Date(), "Detail 1", 1,null));
		datas.add(new News(2, "Tin tức 2", "John", new Date(), "Detail 2", 1,null));
		datas.add(new News(3, "Tin tức 3", "John", new Date(), "Detail 3", 1,null));
		datas.add(new News(4, "Tin tức 4", "John", new Date(), "Detail 4", 1,null));
		datas.add(new News(5, "Tin tức 5", "John", new Date(), "Detail 5", 1,null));
		datas.add(new News(6, "Tin tức 6", "John", new Date(), "Detail 6", 1,null));
		datas.add(new News(7, "Tin tức 7", "John", new Date(), "Detail 7", 1,null));
		datas.add(new News(8, "Tin tức 8", "John", new Date(), "Detail 8", 0,null));
		datas.add(new News(9, "Tin tức 9", "John", new Date(), "Detail 9", 1,null));
		
		
		return datas;
	}
	
//	public News getNewsById(int id) {
//		
//	}
}
