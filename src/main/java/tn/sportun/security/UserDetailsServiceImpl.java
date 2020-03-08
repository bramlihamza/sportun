package tn.sportun.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.sportun.services.UserService;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		tn.sportun.entities.User user = accountService.findByEmail(username);
		
		if (user == null) throw new UsernameNotFoundException(username) ;
		
		
		
		Collection<GrantedAuthority>  authorities = new ArrayList<>();
		
		
		 
		return new User(user.getEmail(),user.getPassword(),authorities);
	}

}
