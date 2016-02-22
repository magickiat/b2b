package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dto.UserDTO;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.User;
import com.starboard.b2b.web.form.user.UserSearchForm;

public interface UserDao extends BaseDao {
	User findById(String id);
	
	List<User> findByCustId(Long id);

	User findByUsername(String username);
	
	User login(String username);

	List<User> list();
	
	List<User> list(Pagination page);
	
	void add(User user);
	
	void update(User user);

	SearchResult<UserDTO> search(SearchRequest<UserSearchForm> req);
}
