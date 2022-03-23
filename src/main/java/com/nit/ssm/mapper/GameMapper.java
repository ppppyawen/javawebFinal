package com.nit.ssm.mapper;

import com.nit.ssm.dto.GarbageAnswerDTO;
import com.nit.ssm.dto.GarbageQuestionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GameMapper {


    @Select({"<script>SELECT " +
            "garbage_id,garbage_name " +
            "FROM tb_garbage" +
            "</script>"})

    List<GarbageQuestionDTO> listGarbage() throws Exception;

    @Select("SELECT sort_name FROM tb_sort,tb_garbage WHERE  tb_garbage.sort_id = tb_sort.sort_id AND tb_garbage.garbage_id = #{garbageAnswerDTO.garbageId}")
    GarbageAnswerDTO AnswerGarbage(@Param("garbageAnswerDTO") GarbageAnswerDTO garbageAnswerDTO) throws Exception;
}
