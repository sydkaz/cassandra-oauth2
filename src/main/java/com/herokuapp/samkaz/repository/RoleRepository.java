package com.herokuapp.samkaz.repository;



import com.herokuapp.samkaz.model.Role;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/*
Created by Syed Kazmi(Sam Kazmi) on 4/1/23
*/
@Repository
public interface RoleRepository extends CassandraRepository<Role, UUID> {

  /**
   *
   * @param roleName
   * @return
   */
  Role findByRoleName(String roleName);

}
