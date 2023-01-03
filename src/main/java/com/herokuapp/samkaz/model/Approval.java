package com.herokuapp.samkaz.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.security.oauth2.provider.approval.Approval.ApprovalStatus;

import java.util.Date;
import java.util.UUID;

/*
Created by Syed Kazmi(Sam Kazmi) on 3/1/23
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "approval")
public class Approval {

    @PrimaryKey
    private UUID id;

    private String userId;

    private String clientId;

    private String scope;

    private ApprovalStatus status;

    private Date expiresAt;

    private Date lastUpdatedAt;

}
