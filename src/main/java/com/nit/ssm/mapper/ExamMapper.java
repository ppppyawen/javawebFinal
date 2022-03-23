package com.nit.ssm.mapper;

import com.nit.ssm.dto.ExamInfoDTP;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * TODO
 *
 * @author pyw
 * @version 1.0

 */

public interface ExamMapper {

    /**
     * @Description 获得一次测试的用户名, 时间, 正确的题目数
     * @Author pyw
* @param:
     * @Return java.util.List<com.homework.ssm.dto.ExamInfoDTP>
     */
    @Select("SELECT tb_exam.exam_sn,tb_user.user_name,tb_exam.create_time,COUNT(case when tb_exam.sort_id = tb_exam.answer_id then 1 else null end) AS `correct_num` FROM tb_user,tb_exam\n" +
            "WHERE tb_user.user_id = tb_exam.user_id AND tb_user.user_name LIKE CONCAT('%', #{queryText}, '%') \n" +
            "GROUP BY tb_exam.exam_sn\n" +
            "LIMIT #{start},#{length}")
    List<ExamInfoDTP> getAllExamInfo(@Param("start") Integer start,
                                     @Param("length") Integer length,
                                     @Param("queryText") String queryText);

    /**
     * @Description 所有的条目数
     * @Author pyw
* @param:
     * @Return java.lang.Integer
     */
    @Select("SELECT COUNT(*) FROM (SELECT * FROM tb_exam GROUP BY tb_exam.exam_sn) test")
    Integer countExam();

}
