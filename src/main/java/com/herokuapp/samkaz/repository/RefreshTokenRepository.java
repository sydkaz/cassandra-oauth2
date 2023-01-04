package com.herokuapp.samkaz.repository;

import com.herokuapp.samkaz.model.RefreshToken;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RefreshTokenRepository extends CassandraRepository<RefreshToken, UUID> {


    @Query("select * from refresh_token where tokenid = ?0")
    RefreshToken findByTokenId(String tokenId);

}
