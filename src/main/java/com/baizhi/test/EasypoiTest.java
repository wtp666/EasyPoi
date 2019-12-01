package com.baizhi.test;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EasypoiTest {
    @Test
    public void test11() {
        List<Student> students = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();
        Student student1 = new Student("小胖", 18, new Date());
        Student student2 = new Student("小白", 20, new Date());
        GirdFriend girdFriend = new GirdFriend("嘻嘻嘻");
        GirdFriend girdFriend1 = new GirdFriend("嘿嘿嘿");
        Teacher teacher1 = new Teacher("小胖", 30, students, girdFriend, "C:\\Users\\Lenovo\\Pictures\\Camera Roll\\2.jpg");
        Teacher teacher2 = new Teacher("大胖", 50, students, girdFriend1, "C:\\Users\\Lenovo\\Pictures\\Camera Roll\\1.jpg");

        students.add(student1);
        students.add(student2);

        teachers.add(teacher1);
        teachers.add(teacher2);


        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("172班老师", "啦啦啦"),
                Teacher.class, teachers);
        try {
            workbook.write(new FileOutputStream(new File("E:\\easypoi.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIn() {
        ImportParams params = new ImportParams();
        params.setHeadRows(2);
        params.setTitleRows(1);

        List<Object> list = ExcelImportUtil.importExcel(new File("E:\\easypoi.xls"), Teacher.class, params);
        for (Object o : list) {
            System.out.println("o = " + o);
        }
    }


}
