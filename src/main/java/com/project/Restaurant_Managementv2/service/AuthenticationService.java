package com.project.Restaurant_Managementv2.service;

import com.project.Restaurant_Managementv2.models.AuthenticationToken;
import com.project.Restaurant_Managementv2.models.User;

public interface AuthenticationService {

    public AuthenticationToken saveComfirmationToken(AuthenticationToken authenticationToken);

    public AuthenticationToken getToken(User user);

    public User getUser(String token);

    public AuthenticationToken authenticate(String token);
}
