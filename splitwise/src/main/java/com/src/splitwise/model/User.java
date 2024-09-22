package com.src.splitwise.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private final String userId;
    private final String userName;
    private final String emailId;
    private final String mobileNumber;
    private final Balance balance;
}
