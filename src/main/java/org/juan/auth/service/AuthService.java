package org.juan.auth.service;

import org.juan.auth.dtos.LoginRequest;

public interface AuthService {

    String login(LoginRequest loginRequest) throws Exception;

}
