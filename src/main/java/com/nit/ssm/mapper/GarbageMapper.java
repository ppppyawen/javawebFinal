package com.nit.ssm.mapper;

import com.nit.ssm.dto.GarbageStatisticDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 *
 * @author pyw
 * @version 1.0
 * @Description

 */
@Repository

public interface GarbageMapper {

    /**
     * @Description 获得题目的统计数据
     * @Author pyw
* @param:
     * @Return java.util.List<com.homework.ssm.dto.GarbageStatisticDTO>
     */
    @Select("SELECT tb_garbage.garbage_id,tb_sort.sort_id,tb_garbage.garbage_name,tb_sort.sort_info,tb_sort.sort_name,COUNT(case when tb_exam.sort_id = tb_exam.answer_id then 1 else null end) AS 'right_count',COUNT(tb_exam.answer_id) AS 'count'\n" +
            "FROM tb_garbage LEFT JOIN tb_exam ON tb_garbage.garbage_id=tb_exam.garbage_id,tb_sort\n" +
            "WHERE tb_garbage.sort_id = tb_sort.sort_id\n" +
            "GROUP BY tb_garbage.garbage_id")
    List<GarbageStatisticDTO> selectGarbageStatistic();

    @Select("SELECT tb_garbage.garbage_id,tb_sort.sort_id,tb_garbage.garbage_name,tb_sort.sort_info,tb_sort.sort_name,COUNT(case when tb_exam.sort_id = tb_exam.answer_id then 1 else null end) AS 'right_count',COUNT(tb_exam.answer_id) AS 'count'\n" +
            "FROM tb_garbage LEFT JOIN tb_exam ON tb_garbage.garbage_id=tb_exam.garbage_id,tb_sort\n" +
            "WHERE tb_garbage.sort_id = tb_sort.sort_id AND garbage_name LIKE CONCAT('%', #{queryText}, '%')\n" +
            "GROUP BY tb_garbage.garbage_id\n" +
            "LIMIT #{start},#{length}")
    List<GarbageStatisticDTO> listTable(@Param("start") Integer start,
                                        @Param("length") Integer length,
                                        @Param("queryText") String queryText);

    @Select("SELECT COUNT(*) FROM tb_garbage")
    Integer count();
}
