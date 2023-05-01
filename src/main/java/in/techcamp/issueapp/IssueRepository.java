package in.techcamp.issueapp;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IssueRepository {
    @Insert("insert into issues (title, content, period, importance) values (#{title}, #{content}, #{period}, #{importance})")
    void insert(String title, String content, String period, char importance);

    // findAllメソッドの定義
    // issuesテーブルから全件取得
    @Select("select * from issues")
    List<IssueEntity> findAll();

    // findByIdメソッドの定義
    // idからデータを取得
    @Select("select * from issues where id = #{id}")
    IssueEntity findById(long id);

    // updateメソッドの定義
    @Update("UPDATE issues SET title = #{title}, content = #{content}, period = #{period}, importance = #{importance} WHERE id =#{id}")
    void update(long id, String title, String content, String period, char importance);

    @Delete("delete from issues where id = #{id}")
    void deleteById(Long id);
}
