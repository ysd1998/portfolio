package com.example.demo.service.book;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.book.Books;
import com.example.demo.repository.book.BookInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookSerchService {
	
	@Autowired
	private final BookInfoRepository repository;
//	@Autowired
//	private final BookInfoRepositoryCustom repositoryCustom;
	
	public Page<Books> search(String loginId,String Name,String Password,String Typeid,Pageable pageable) {
		Page<Books> result;
		if ("".equals(loginId) && "".equals(Name) && "".equals(Password) && "".equals(Typeid)) {
			result = repository.findAll(pageable);
		} else {
			result = repository.findByTitleLikeOrAutherLikeOrPublisherLikeOrTypeidLike("%"+loginId+"%","%" +Name+"%","%" +Password+"%","%" +Typeid+"%",pageable);
		}
		return result;
	}
	
	public Books serchId(String id){
		Books book =repository.findById(id).get();
		return book;
	}
	
	public Optional<Books> check(String id){
		Optional<Books> book =repository.findById(id);
		return book;
	}
	
//	public Books serchIdthrows(String id) throws NoSuchElementException{
//		Books book;
//		try {
//			book =repository.findById(id).get();
//		} catch (NoSuchElementException e) {
//			book.setBookid("値無し");
//		}
//		return book;
//		
//	}
	
//	public List<UserInfo> searchData(String loginId,SerchForm form){
//		StringBuilder sqlBuilder = new StringBuilder();
//	    sqlBuilder.append("SELECT c.client_id, c.name,c.password "
//	            + "FROM clients AS C "
//	            + "WHERE ");
//	 
//	    // パラメータ設定用Map
//	    Map<String, String> param = new HashMap<>();
//	    // パラメータが存在した場合、where句にセット
//	    if(form.getSerchData() != null && form.getSerchData() != "") {
//	        sqlBuilder.append("c.client_id like :cd");
//	        param.put("cd", form.getSerchData());
//	    }
//	    if(form.getSerchData() != null && form.getSerchData() != "") {
//	        sqlBuilder.append(" OR c.name = :cd");
//	        param.put("cd", form.getSerchData());
//	    }
//	    if(form.getSerchData() != null && form.getSerchData() != "") {
//	        sqlBuilder.append(" OR c.password = :cd");
//	        param.put("cd", form.getSerchData());
//	    }
//	 
//	    String sql = sqlBuilder.toString();
//	 
//		//タスク一覧をMapのListで取得
//	    List<Map<String, Object>> resultList = JdbcTemplate.queryForList(sql, param);
//	    //return用の空のListを用意
//	    List<UserInfo> list = new ArrayList<UserInfo>();
//	 
//	    for(Map<String, Object> result : resultList) {
//	    	UserInfo diary = new UserInfo();
//	        diary.setLoginid((String)result.get("id"));
//	        diary.setName((String)result.get("name"));
//	        diary.setPassword((String)result.get("password"));
//	        list.add(diary);
//	    }
//	    return list;
//	}

}
