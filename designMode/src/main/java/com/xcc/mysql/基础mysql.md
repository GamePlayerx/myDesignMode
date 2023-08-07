## MySQL基础

### 查询

测试数据
```mysql
-- `student_demo`
create table if not exists `student_demo`
(
    `id`       integer          not null primary key AUTO_INCREMENT,
    `name`     varchar(256)     not null,
    `age`      int              null,
    `class_id`    bigint           not null,
    `score`    double default 0 null,
    `exam_num` int    default 0 null
);

insert into `student_demo` (`name`, `age`, `class_id`, `score`, `exam_num`)
values ('镇山的虎', 25, 1, 2.5, 1);
insert into `student_demo` (`name`, `age`, `class_id`, `score`, `exam_num`)
values ('明捷的豹', 18, 1, 400, 4);
insert into `student_demo` (`name`, `age`, `class_id`, `score`, `exam_num`)
values ('远见的鹰', 40, 2, 600, 4);
insert into `student_demo` (`name`, `age`, `class_id`, `score`, `exam_num`)
values ('骁勇的狼', null, 2, 360, 4);
insert into `student_demo` (`name`, `age`, `class_id`, `score`, `exam_num`)
values ('领头的羊', 19, 3, 120, 2);
insert into `student_demo` (`name`, `age`, `class_id`, `score`, `exam_num`)
values ('划水的鱼', 56, 3, 500, 4);
insert into `student_demo` (`name`, `age`, `class_id`, `score`, `exam_num`)
values ('退堂的鼓', 24, 4, 390, 3);
insert into `student_demo` (`name`, `age`, `class_id`, `score`, `exam_num`)
values ('害群的马', 23, 4, 0, 4);
insert into `student_demo` (`name`, `age`, `class_id`, `score`, `exam_num`)
values ('墙头的草', 80, 4, 600, 4);
insert into `student_demo` (`name`, `age`, `class_id`, `score`, `exam_num`)
values ('背锅的侠', 60, 5, 100.5, 1);
```

#### 全表查询
```mysql
    select * from student_demo;
```

#### 选择查询
```mysql
    select name, score from student_demo;
```

#### 别名
```mysql
    select name as '姓名', score as '成绩' from student_demo;
```

#### 常量运算
```mysql
    select name, score, score * 2 as '成绩' from student_demo;
```

#### where
```mysql
    select name, score from student_demo where name = '背锅的侠';
```

#### 运算符
```mysql
    select name, score from student_demo where name != '镇山的虎';
```

#### 空值
```mysql
    select name, age, score from student_demo where age is not null;
```

#### 模糊查询
```mysql
    select name, score from student_demo where name not like '%狼%';
```

#### 逻辑运算
```mysql
    select name, score from student_demo where name not like '%狼%' and score > 300;
```

#### 去重
```mysql
    select distinct class_id from student_demo;
```

#### 排序
```mysql
    select * from student_demo order by score desc, age asc;
```

#### 截断和偏移
```mysql
    select * from student_demo order by score desc, age asc limit 1, 3;
```

#### 条件分支
```mysql
    SELECT
        name,
        CASE
            WHEN (age > 60) THEN '老同学'
            WHEN (age > 20) THEN '年轻'
            ELSE '小同学'
            END AS age_level
    FROM
        student_demo
    ORDER BY
        name asc;
```

#### 时间函数
```mysql
    select name, date(now()) as '当前时间' from student_demo;
```

#### 聚合函数
```mysql
    select sum(score), avg(score), max(score), min(score) from student_demo;
```

#### 单字段分组
```mysql
    select class_id, avg(score) as avg_score from student_demo group by class_id;
```

#### 多字段分组
```mysql
    select class_id, exam_num, count(*) as total_num from student_demo group by class_id, exam_num;
```

#### having子句
```mysql
    SELECT class_id, SUM(score) AS total_score FROM student_demo GROUP BY class_id HAVING SUM(score) > 500;
```

