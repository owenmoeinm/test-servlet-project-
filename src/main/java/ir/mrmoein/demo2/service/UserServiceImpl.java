package ir.mrmoein.demo2.service;

import ir.mrmoein.demo2.access.Locator;
import ir.mrmoein.demo2.model.UserModel;
import ir.mrmoein.demo2.model.dto.UserReqDTO;
import ir.mrmoein.demo2.model.dto.UserRespDTO;
import ir.mrmoein.demo2.repository.impl.UserRepoImpl;

import java.time.LocalDate;
import java.util.UUID;

public class UserServiceImpl implements UserService , Locator {

    private final UserRepoImpl repo;

    public UserServiceImpl(UserRepoImpl repo) {
        this.repo = repo;
    }

    @Override
    public void signup(UserReqDTO userDTO) {
        try {
            UserModel build = UserModel.builder()
                    .id(UUID.randomUUID())
                    .createDate(LocalDate.now())
                    .email(userDTO.getEmail())
                    .username(userDTO.getUsername())
                    .password(userDTO.getPassword())
                    .build();
            repo.save(build);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public UserRespDTO login(String username, String password) {
        try {
            UserModel byUserPass = repo.findByUserPass(username, password);
            return UserRespDTO.builder()
                    .email(byUserPass.getEmail())
                    .id(byUserPass.getId())
                    .createDate(byUserPass.getCreateDate())
                    .password(byUserPass.getPassword())
                    .username(byUserPass.getUsername()).build();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public UserRespDTO forgetPass(String username, String email) {
        try {
            UserModel byUserPass = repo.findByUserEmail(username , email);
            return UserRespDTO.builder()
                    .email(byUserPass.getEmail())
                    .username(byUserPass.getUsername())
                    .password(byUserPass.getPassword())
                    .id(byUserPass.getId())
                    .createDate(byUserPass.getCreateDate()).build();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
