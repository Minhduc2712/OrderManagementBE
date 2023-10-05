package com.project.Restaurant_Managementv2.serviceImpl;

import com.project.Restaurant_Managementv2.config.documentation.MessageString;
import com.project.Restaurant_Managementv2.exceptions.AuthenticationFailException;
import com.project.Restaurant_Managementv2.models.AuthenticationToken;
import com.project.Restaurant_Managementv2.models.User;
import com.project.Restaurant_Managementv2.repository.TokenRepository;
import com.project.Restaurant_Managementv2.service.AuthenticationService;
import com.project.Restaurant_Managementv2.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    TokenRepository tokenRepository;

    @Override
    public AuthenticationToken saveComfirmationToken(AuthenticationToken authenticationToken) {
        return tokenRepository.save(authenticationToken);
    }

    public AuthenticationToken getToken(User user){
        return tokenRepository.findTokenByUser(user);
    }

    @Override
    public User getUser(String token) {
        AuthenticationToken authenticationToken = tokenRepository.findTokenByToken(token);
        if (Helper.notNull(authenticationToken)) {
            if (Helper.notNull(authenticationToken.getUser())) {
                return authenticationToken.getUser();
            }
        }
        return null;
    }


    public AuthenticationToken authenticate(String token) throws AuthenticationFailException {
        if(!Helper.notNull(token)){
            throw new AuthenticationFailException(MessageString.AUTH_TOEKN_NOT_PRESENT);
        }
        if(!Helper.notNull(getUser(token))){
            throw new AuthenticationFailException(MessageString.AUTH_TOEKN_NOT_VALID);
        }
        return null;
    }
}
