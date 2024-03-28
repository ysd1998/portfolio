package com.example.demo.service.secondary;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.secondary.Employees;
import com.example.demo.form.book.BookInfo;
import com.example.demo.form.secondary.LoginForm;
import com.example.demo.repository.secondary.EmpInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpSerchService {
	
	@Autowired
	private final EmpInfoRepository repository;
//	@Autowired
//	private final EmpInfoRepositoryCustom repositoryCustom;
	
	public Page<Employees> searchEmp(String loginId,String Name,String Password,Pageable page) {
		Page<Employees> result;
		if ("".equals(loginId) && "".equals(Name) && "".equals(Password)) {
			result = repository.findAll(page);
		} else {
			result = repository.findByLoginidLikeOrNameLikeOrAuthorityLike("%"+loginId +"%", "%"+Name+"%","%"+ Password +"%",page);
		}
		return result;
	}
	
	public Employees searchId(String loginId) {
		Employees emp = new Employees();
		Optional<Employees> emps = repository.findById(loginId);
		if (emps.isPresent()) {
			emp = emps.get();
		} else {
			emp = null;
		}
		return emp;
	}
	
	public String insert(LoginForm emp) {
		Employees employees = new Employees();
		Optional<Employees> emps = repository.findById(emp.getLoginId());
		if (emps.isPresent()) {
			employees = emps.get();
		} else {
			emps = null;
		}
		employees.setAuthority(emp.getAuthority());
		repository.save(employees);
		return "auth change sucsess";
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
