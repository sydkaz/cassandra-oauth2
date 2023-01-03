package com.herokuapp.samkaz.util;

import com.herokuapp.samkaz.model.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;


/*
Created by Syed Kazmi(Sam Kazmi) on 3/1/23
*/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserUtils {
	
	public static boolean isAdminUser(User user ){
		boolean isAdmin = false; // Nagative approach is batter
		
		if( user != null && !CollectionUtils.isEmpty(user.getRoles())){
			for(String role : user.getRoles() ){
				if( role != null && ( role.equals(RoleEnum.ROLE_ADMIN.name()) || role.equals(RoleEnum.ROLE_SUPER_ADMIN.name()) ) ){
					isAdmin = true;
					break;
				}
			}
		}
		
		return isAdmin;
	}
	
	public static boolean isSuperAdminUser(User user ){
		boolean isSuperAdmin = false; // Nagative approach is batter
		
		if(user!=null && user.getRoles()!=null){
			for(String role : user.getRoles() ){
				if(role!=null && role.equals(RoleEnum.ROLE_SUPER_ADMIN.name())){
					isSuperAdmin = true;
					break;
				}
			}
		}
		
		return isSuperAdmin;
	}

}
