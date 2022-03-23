package com.nit.ssm.service;

import com.nit.ssm.dto.TableReqDTO;
import com.nit.ssm.dto.UserDTO;
import com.nit.ssm.dto.LoginDTO;

import java.util.List;
/*import com.nit.ssm.dto.TableReqDTO;
import com.nit.ssm.dto.TableRspDTO;*/


public interface UserService {

    LoginDTO login(LoginDTO loginDTO) throws Exception;

    Integer add(UserDTO userDTO) throws Exception;

    Integer repetite(UserDTO userDTO) throws  Exception;

    List<UserDTO> getUnpassedUser(TableReqDTO tableReqDTO);

    Integer countUser();

    Integer updateUserStatus(UserDTO userDTO);




}
