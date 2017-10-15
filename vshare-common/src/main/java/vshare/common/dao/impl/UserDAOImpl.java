package vshare.common.dao.impl;

import org.springframework.stereotype.Service;
import vshare.common.dao.UserDAO;
import vshare.common.entity.UserEntity;
import vshare.common.repository.UserRepository;
import vshare.common.returncode.StatusCode;

@Service
public class UserDAOImpl implements UserDAO {

    UserRepository userRepository;

    @Override
    public int addUser(UserEntity userEntity) {
        userRepository.save(userEntity);
        return StatusCode.ADD_SUCCESS;
    }

    @Override
    public int updateUser(UserEntity userEntity) {
        userRepository.save(userEntity);
        return StatusCode.UPDATE_SUCCESS;
    }

    @Override
    public int deleteUser(UserEntity userEntity) {
        userRepository.delete(userEntity);
        return StatusCode.DELETE_SUCCESS;
    }

    @Override
    public UserEntity findUserById(long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public boolean deleteUserById(long userId) {
        userRepository.delete(userId);
        return true;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
