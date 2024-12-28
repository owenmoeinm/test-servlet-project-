package ir.mrmoein.demo2.service;

import ir.mrmoein.demo2.model.dto.UserReqDTO;
import ir.mrmoein.demo2.model.dto.UserRespDTO;

public interface UserService {
    void signup(UserReqDTO userDTO);

    UserRespDTO login(String username , String password);

    UserRespDTO forgetPass(String username , String pass);

}
