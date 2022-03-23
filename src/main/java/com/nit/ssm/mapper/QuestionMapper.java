package com.nit.ssm.mapper;

import com.nit.ssm.dto.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface QuestionMapper {
    @Select({"<script>SELECT "+
            "garbage_id,garbage_name "+
            "FROM tb_garbage " +
            "ORDER BY rand() "+
            "limit 10" +
            "</script>"})

    List<GarbageQuestionDTO> listGarbage() throws Exception;


    @Select("SELECT tb_sort.sort_id,tb_sort.sort_name FROM tb_sort,tb_garbage WHERE  tb_garbage.sort_id = tb_sort.sort_id AND tb_garbage.garbage_id = #{examDTO.garbageId}")
    SortDTO AnswerGarbage(@Param("examDTO") ExamDTO examDTO) throws Exception;

    @Insert("INSERT INTO tb_exam ( " +
            "exam_sn, garbage_id, user_id, sort_id, answer_id, create_time) " +
            "VALUES (#{examDTO.examSn},#{examDTO.garbageId},#{examDTO.userId},#{examDTO.sortId},#{examDTO.answerId},NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "examId", keyColumn = "exam_id")
    void InsertExam(@Param("examDTO") ExamDTO examDTO) throws Exception;

    @Select("SELECT COUNT(*) FROM (SELECT COUNT(*) FROM tb_exam WHERE user_id = #{userId} GROUP BY tb_exam.exam_sn) AS T")
    Integer countExamTable(@Param("userId") Integer userId) throws Exception;

    @Select("SELECT DISTINCT exam_sn, tb_user.user_name, tb_exam.create_time FROM tb_exam,tb_user WHERE tb_exam.user_id = tb_user.user_id  AND tb_exam.user_id = #{userId}  GROUP BY exam_sn ORDER BY create_time DESC LIMIT #{start}, #{length}")
    List<ExamHistoryDTO> listExamTable(@Param("start") Integer start,
                                       @Param("length") Integer length,
                                       @Param("userId") Integer userId) throws Exception;




    @Select("SELECT *\n" +
            "FROM (SELECT tb_exam.exam_id,tb_sort.sort_name AS answer_name FROM tb_exam,tb_sort WHERE tb_exam.answer_id = tb_sort.sort_id AND tb_exam.exam_sn = #{examSn}) AS A," +
            "(SELECT tb_exam.exam_id, tb_sort.sort_info,tb_sort.sort_name AS true_name,tb_garbage.garbage_name FROM tb_exam,tb_sort,tb_garbage WHERE tb_sort.sort_id = tb_exam.sort_id AND tb_exam.garbage_id = tb_garbage.garbage_id AND tb_exam.exam_sn = #{examSn}) \n" +
            "AS B WHERE A.exam_id = B.exam_id")
    List<ExamResultDTO> listResultTrueName(@Param("examSn") String examSn) throws Exception;

    @Select("SELECT\n" +
            "(\n" +
            "SELECT COUNT(*) FROM tb_exam WHERE user_id = #{userId} AND sort_id<>answer_id\n" +
            ")AS wrong_count,\n" +
            "(\n" +
            "SELECT COUNT(*) FROM tb_exam WHERE user_id = #{userId} AND tb_exam.sort_id= tb_exam.answer_id\n" +
            ")AS true_count")
    ExamResultPieDTO resultPieTable(@Param("userId") Integer userId) throws  Exception;

    @Select("SELECT DISTINCT * FROM\n" +
            "(\n" +
            "SELECT user_name,COUNT(*) AS true_answer FROM tb_exam,tb_user WHERE tb_exam.user_id = tb_user.user_id AND answer_id = sort_id GROUP BY tb_exam.user_id\n" +
            ") AS true_answer\n" +
            ",\n" +
            "(\n" +
            "SELECT user_name,COUNT(*) AS total_answer FROM tb_exam,tb_user WHERE tb_exam.user_id = tb_user.user_id GROUP BY tb_exam.user_id\n" +
            ") AS wrong_answer\n" +
            "WHERE true_answer.user_name = wrong_answer.user_name GROUP BY true_answer.user_name ORDER BY true_answer/total_answer DESC LIMIT 10")
    List<ExamResultRankDTO> listResultRanking() throws Exception;

    @Select("SELECT * FROM tb_exam WHERE user_id = #{userId} ORDER BY create_time DESC LIMIT 50\n")
    List<ExamDTO> listLineChart(@Param("userId") Integer userId) throws Exception;
}
