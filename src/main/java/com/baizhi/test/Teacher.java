package com.baizhi.test;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ExcelTarget(value = "教师")
public class Teacher {
    @Excel(name = "姓名", needMerge = true)
    private String name;
    @Excel(name = "年龄", needMerge = true)
    private Integer age;
    @ExcelCollection(name = "学生们", orderNum = "8")
    private List<Student> students;
    @ExcelEntity(name = "女朋友")
    private GirdFriend girdFriend;
    @Excel(name = "图像", type = 2)
    private String src;
}
