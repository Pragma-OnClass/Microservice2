package com.example.on_class_users.configuration;

import com.example.on_class_users.adapters.driven.jpa.mysql.adapter.RoleAdapter;
import com.example.on_class_users.adapters.driven.jpa.mysql.adapter.UserAdapter;
import com.example.on_class_users.adapters.driven.jpa.mysql.mapper.IRoleEntityMapper;
import com.example.on_class_users.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.example.on_class_users.adapters.driven.jpa.mysql.repository.IRoleRepository;
import com.example.on_class_users.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.example.on_class_users.domain.api.IRoleServicePort;
import com.example.on_class_users.domain.api.IUserServicePort;
import com.example.on_class_users.domain.api.usecase.RoleUseCase;
import com.example.on_class_users.domain.api.usecase.UserUseCase;
import com.example.on_class_users.domain.spi.IRolePersistencePort;
import com.example.on_class_users.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Bean
    public IRolePersistencePort rolePersistencePort(){
        return new RoleAdapter(roleRepository, roleEntityMapper);
    }
    @Bean
    public IRoleServicePort roleServicePort(){
        return new RoleUseCase(rolePersistencePort());
    }

    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserAdapter(userRepository, userEntityMapper);
    }
    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort());
    }
}