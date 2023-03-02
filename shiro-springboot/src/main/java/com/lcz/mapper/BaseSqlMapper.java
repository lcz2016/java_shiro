package com.lcz.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface BaseSqlMapper {
    /*分页执行sql语句*/
    @Select("${sql}")
    List<HashMap> selectPage(Page page , String sql);

    /*不分页执行说起来查询语句*/
    @Select("${sql}")
    List<HashMap> selectData(String sql);

    /*执行插入sql语句*/
    @Insert("${sql}")
    void insertData(String sql);

    /*执行更新sql语句*/
    @Update("${sql}")
    void updateData(String sql);

    /*执行更新sql语句*/
    @Delete("${sql}")
    void deleteData(String sql);
}
