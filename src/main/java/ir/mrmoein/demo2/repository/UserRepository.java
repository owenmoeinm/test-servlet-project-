package ir.mrmoein.demo2.repository;

import ir.mrmoein.demo2.model.UserModel;

public interface UserRepository extends BaseRepo<UserModel>{

    UserModel findByUserPass(String username , String pass);
    UserModel findByUserEmail(String username , String email);
    void changePass(String pass);

}
