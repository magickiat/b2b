package com.starboard.b2b.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.starboard.b2b.dao.UserDao;
import com.starboard.b2b.model.User;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		User user = userDao.findById(id);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User %s doesn't exist!", id));
		}

//		return new SecurityUserDetail(user);
		return user;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

//	//TODO Implement isEnable to boolean
//	private static final class SecurityUserDetail extends User implements UserDetails {
//
//		private static final long serialVersionUID = 1L;
//
//		public SecurityUserDetail(User user) {
//			super(user);
//		}
//
//		@Override
//		public Collection<? extends GrantedAuthority> getAuthorities() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public String getUsername() {
//			return getId();
//		}
//
//		@Override
//		public boolean isAccountNonExpired() {
//			// TODO Auto-generated method stub
//			return false;
//		}
//
//		@Override
//		public boolean isAccountNonLocked() {
//			// TODO Auto-generated method stub
//			return false;
//		}
//
//		@Override
//		public boolean isCredentialsNonExpired() {
//			// TODO Auto-generated method stub
//			return false;
//		}
//
//		
//
//	}

}
