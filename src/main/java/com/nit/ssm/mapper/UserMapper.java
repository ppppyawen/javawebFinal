package com.nit.ssm.mapper;

import com.nit.ssm.dto.LoginDTO;
import com.nit.ssm.dto.UserDTO;
import com.nit.ssm.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    /**
     * 添加用户
     * @param userEntity
     * @return
     * @throws Exception
     */
    @Insert("INSERT INTO tb_user ( " +
            "user_name, user_phone, user_pwd, user_card, user_status, user_type) " +
            "VALUES (#{userEntity.userName}, #{userEntity.userPhone},#{userEntity.userPwd},#{userEntity.userCard},0,2)")
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id")
    Integer add(@Param("userEntity") UserEntity userEntity) throws Exception;


    /**
     * 通过用户名和密码选择账号
     * @param loginDTO
     * @return
     * @throws Exception
     */
    @Select("select * from tb_user where user_phone=#{loginDTO.userPhone} and user_pwd=#{loginDTO.userPwd} AND user_type = \"2\"")
    LoginDTO login(@Param("loginDTO") LoginDTO loginDTO) throws Exception;

    /**
     * 通过手机号选择用户
     * @param userDTO
     * @return
     * @throws Exception
     */
    @Select("select * from tb_user where user_phone=#{userDTO.userPhone}")
    Integer repetite(@Param("userDTO") UserDTO userDTO) throws  Exception;

    /**
     * @Description 显示所有没有通过的用户信息
     * @Author pyw
* @Return java.util.List<com.homework.ssm.entity.UserEntity>
     */
    @Select("SELECT * FROM tb_user \n" +
            "WHERE tb_user.user_name LIKE CONCAT('%', #{queryText}, '%')\n" +
            "ORDER BY user_status ASC,user_id DESC\n" +
            "LIMIT #{start},#{length}")
    List<UserEntity> selectUnpassedUser(@Param("start") Integer start,
                                        @Param("length") Integer length,
                                        @Param("queryText") String queryText);
    @Select("SELECT COUNT(*) FROM tb_user")
    Integer countUser();

    /**
     * @Description *
     * @Author pyw
     * @param userDTO
     * @Return java.lang.Integer
     */
    @Update("UPDATE tb_user " +
            "SET user_Status = #{userDTO.userStatus} " +
            "WHERE user_id = #{userDTO.userId}")
    Integer updateUser(@Param(("userDTO")) UserDTO userDTO);

}