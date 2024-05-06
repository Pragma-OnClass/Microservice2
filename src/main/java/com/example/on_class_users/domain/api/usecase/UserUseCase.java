package com.example.on_class_users.domain.api.usecase;

import com.example.on_class_users.domain.api.IUserServicePort;
import com.example.on_class_users.domain.model.User;
import com.example.on_class_users.domain.spi.IUserPersistencePort;

public class UserUseCase implements IUserServicePort {
    private IUserPersistencePort userPersistencePort;
    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveAdminUser(User user) {
        userPersistencePort.saveAdminUser(user);
    }

    @Override
    public void saveTutorUser(User user) {
        userPersistencePort.saveTutorUser(user);
    }

    @Override
    public void saveStudentUser(User user) {
        userPersistencePort.saveStudentUser(user);
    }

    @Override
    public void saveUser(User user) {
        userPersistencePort.saveUser(user);
    }

    @Override
    public void createSuperAdmin() {
        userPersistencePort.createSuperAdmin();
    }
}
