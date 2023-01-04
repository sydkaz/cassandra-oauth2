package com.herokuapp.samkaz.service;


import com.herokuapp.samkaz.model.User;
import com.herokuapp.samkaz.util.UserDetail;

import javax.validation.constraints.NotNull;
import java.util.List;

/*
Created by Syed Kazmi(Sam Kazmi) on 4/1/23
*/
public interface UserService {	
 
  /**
   * <p>
   *   Saves provided {@link NotNull} {@link User} object to database.
   * </p>
   *
   * @param user {@link User}
   */
  void saveUser(final User user);

  
  void registerUser(final User user);

  
  UserDetail getUserDetailByUserName(final String userName);

  
  User getUserByEmail(String email);

  User getUserByUserName(final String userName);

  List<User> getAllUsers();


}