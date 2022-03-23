package com.nit.ssm.service.impl;

import com.nit.ssm.dto.TableReqDTO;
import com.nit.ssm.dto.UserDTO;
import com.nit.ssm.dto.LoginDTO;
import com.nit.ssm.entity.UserEntity;
import com.nit.ssm.mapper.UserMapper;
import com.nit.ssm.service.UserService;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;
    @Override
    public  LoginDTO login(LoginDTO loginDTO) throws Exception{
        //MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        //UserEntity userEntity = mapperFactory.getMapperFacade().map(loginDTO, UserEntity.class);
        return userMapper.login(loginDTO);
    }

    @Autowired(required = false)
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer add(UserDTO userDTO) throws Exception {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        UserEntity userEntity = mapperFactory.getMapperFacade().map(userDTO, UserEntity.class);
        return userMapper.add(userEntity);
    }

    @Autowired(required = false)
    @Override
    public Integer repetite(UserDTO userDTO) throws Exception{

        return  userMapper.repetite(userDTO);
    }

    @Override
    public List<UserDTO> getUnpassedUser(TableReqDTO tableReqDTO) {
        List<UserEntity> userEntities = userMapper.selectUnpassedUser(tableReqDTO.getStart(),tableReqDTO.getPageSize(),tableReqDTO.getQueryText());
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        return mapperFactory.getMapperFacade().mapAsList(userEntities, UserDTO.class);
    }

    @Override
    public Integer countUser() {
        return userMapper.countUser();
    }

    @Override
    public Integer updateUserStatus(UserDTO userDTO) {
        Integer res = userMapper.updateUser(userDTO);
        return res;
    }


}
