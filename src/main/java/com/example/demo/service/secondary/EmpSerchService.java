package com.example.demo.service.secondary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.secondary.Employees;
import com.example.demo.repository.secondary.EmpInfoRepository;
import com.example.demo.repository.secondary.EmpInfoRepositoryCustom;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpSerchService {
	
	@Autowired
	private final EmpInfoRepository repository;
	@Autowired
	private final EmpInfoRepositoryCustom repositoryCustom;
	
	public List<Employees> search(String loginId,String Name,String Password) {
		List<Employees> result;
		if ("".equals(loginId) && "".equals(Name) && "".equals(Password)) {
			result = repository.findAll();
		} else {
			result = repositoryCustom.search(loginId, Name, Password);
		}
		return result;
	}
	
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
