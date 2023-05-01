package in.techcamp.issueapp;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
