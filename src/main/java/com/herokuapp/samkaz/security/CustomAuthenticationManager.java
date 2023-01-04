package com.herokuapp.samkaz.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

/*
Created by Syed Kazmi(Sam Kazmi) on 4/1/23
*/
public class CustomAuthenticationManager  implements AuthenticationManager {
	
	private CustomAuthenticationProvider customAuthenticationProvider;

		
	public CustomAuthenticationManager(CustomAuthenticationProvider customAuthenticationProvider) {
		this.customAuthenticationProvider = customAuthenticationProvider;
	
	}

	/**
	 * <p>
	 *   Authenticates current authentication.
	 * </p>
	 *
	 * @param authentication
	 *
	 * @return
	 */
	@Override
	public Authentication authenticate(Authentication authentication) {
		
		return customAuthenticationProvider.authenticate(authentication);
		
	}
}
