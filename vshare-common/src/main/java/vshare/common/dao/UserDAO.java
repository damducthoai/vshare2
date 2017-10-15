package vshare.common.dao;

import vshare.common.entity.UserEntity;

public interface UserDAO {

    int addUser(UserEntity userEntity);

    int updateUser(UserEntity userEntity);

    int deleteUser(UserEntity userEntity);

    UserEntity findUserById(long userId);

    boolean deleteUserById(long userId);

}
