## MySQL进阶

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

create table if not exists `class`
(
    `id`       integer          not null primary key AUTOINCREMENT,
    `name`     varchar(256)     not null,
    `level`    varchar(256)     not null,
    `student_num` integer default 0 not null,
    `head_teacher_id` bigint not null
);

insert into `class` (`id`, `name`, `level`, `student_num`, `head_teacher_id`)
values (1, '唱班', '优', 10, 1);
insert into `class` (`id`, `name`, `level`, `student_num`, `head_teacher_id`)
values (2, '跳班', '良', 12, 2);
insert into `class` (`id`, `name`, `level`, `student_num`, `head_teacher_id`)
values (3, 'rap班', '普通', 15, 3);
insert into `class` (`id`, `name`, `level`, `student_num`, `head_teacher_id`)
values (6, '篮球班', '优', 20, 4);

-- `student_new`
create table if not exists `student_new`
(
    `id`       integer          not null primary key AUTO_INCREMENT,
    `name`     varchar(256)     not null,
    `age`      int              null,
    `class_id`    bigint           not null,
    `score`    double default 0 null,
    `exam_num` int    default 0 null
);

insert into `student_new` (`name`, `age`, `class_id`, `score`, `exam_num`)
values ('搅屎的棍', 20, 1, 120, 1);
insert into `student_new` (`name`, `age`, `class_id`, `score`, `exam_num`)
values ('拖油的瓶', 21, 2, 180, 2);
insert into `student_new` (`name`, `age`, `class_id`, `score`, `exam_num`)
values ('干饭的桶', 25, 1, 2.5, 1);
insert into `student_new` (`name`, `age`, `class_id`, `score`, `exam_num`)
values ('笨死的猪', 18, 1, 400, 4);

```

#### 关联查询-cross join
```mysql
    select
        s.name student_name,
        s.age student_age,
        s.class_id class_id,
        c.name class_name
    from
        student_demo s,
        class c;
```

#### 关联查询-inner join
```mysql
    select
        s.name student_name,
        s.age student_age,
        s.class_id class_id,
        c.name class_name,
        c.level class_level
    from
        student_demo s
            join class c on s.class_id = c.id;
```

#### 关联查询-outer join
```mysql
    select
        s.name student_name,
        s.age student_age,
        s.class_id class_id,
        c.name class_name,
        c.level class_level
    from
        student_demo s
            left join class c on s.class_id = c.id;
```

#### 子查询
```mysql
    select
        name,
        score,
        class_id
    from
        student_demo
    where
            class_id in (
            select distinct
                id
            from
                class
        );
```

#### 子查询 exists
```mysql
    select
        name,
        age,
        class_id
    from
        student_demo
    where
        not exists (
                select
                    class_id
                from
                    class
                where
                    class.id = student_demo.class_id
            );
```

#### 组合查询
```mysql
    select
        name,
        age,
        score,
        class_id
    from
        student_demo
    union all
    select
        name,
        age,
        score,
        class_id
    from
        student_new;
```

#### 开窗函数-avg over
```mysql
    SELECT
        id,
        name,
        age,
        score,
        class_id,
        AVG(score) OVER (
            PARTITION BY
                class_id
            ) AS class_avg_score
    FROM
        student_demo;
```

#### 开窗函数-sum over order by
```mysql
    SELECT
        id,
        name,
        age,
        score,
        class_id,
        SUM(score) OVER (
            PARTITION BY
                class_id
            ORDER BY
                score ASC
            ) AS class_sum_score
    FROM
        student_demo;
```

#### 开窗函数-rank
```mysql
    SELECT
        id,
        name,
        age,
        score,
        class_id,
        RANK() OVER (
            PARTITION BY
                class_id
            ORDER BY
                score DESC
            ) AS ranking
    FROM
        student_demo;
```

#### 开窗函数-row_number
```mysql
    SELECT
        id,
        name,
        age,
        score,
        class_id,
        ROW_NUMBER() OVER (
            PARTITION BY
                class_id
            ORDER BY
                score DESC
            ) AS row_number
    FROM
        student_demo;
```

#### 开窗函数-lag/lead
```mysql
    SELECT
        id,
        name,
        age,
        score,
        class_id,
        LAG(name) over (
            PARTITION BY
                class_id
            ORDER BY
                score DESC
            ) as prev_name,
        LEAD(name) OVER (
            PARTITION BY
                class_id
            ORDER BY
                score DESC
            ) AS next_name
    FROM
        student_demo;
```
