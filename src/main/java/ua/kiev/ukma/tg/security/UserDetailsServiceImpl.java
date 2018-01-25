package ua.kiev.ukma.tg.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import ua.kiev.ukma.tg.model.UserAuth;
import ua.kiev.ukma.tg.service.UserService;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserAuth userAuth = userService.getUserAuth(email);
		if (userAuth == null)
			throw new UsernameNotFoundException("No user with email " + email);
		return userAuth;
	}
}