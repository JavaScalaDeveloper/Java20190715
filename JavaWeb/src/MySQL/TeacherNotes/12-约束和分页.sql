# 约束和分页
# 1. 约束(constraint)
# 约束：对表中列(或字段)的强制规定

# 常见的约束：
# 非空约束(not null)
# 唯一性约束(unique)
# 主键约束(primary key)
# 外键约束(foreign key)
# 检查约束(check)
# 默认值约束(default)

# 约束的分类：①根据约束数据列的限制：单列约束  vs 多列约束
#             ②约束的作用范围：列级约束 vs 表级约束		

# 通常，我们都是在create table的时候，给相应的列声明约束。
# 同时，我们还可以通过alter table 的方式，删除或添加列的约束

# 1.1 非空约束(not null)
# 非空约束只能使用列级约束的方式声明
CREATE TABLE myemp1(
id INT NOT NULL, # 列级约束
NAME VARCHAR(15) NOT NULL,
email VARCHAR(25),
salary DOUBLE(10,2)

);

DESC myemp1;

INSERT INTO myemp1(id,NAME,salary,email)
VALUES(1,'Tom',3400,NULL);

SELECT * FROM myemp1;
#失败
INSERT INTO myemp1(id,NAME,salary,email)
VALUES(2,NULL,3400,NULL);
#失败
INSERT INTO myemp1(NAME,salary,email)
VALUES('Jerry',3400,NULL);

# 删除非空约束
ALTER TABLE myemp1
MODIFY NAME VARCHAR(15) NULL;

DESC myemp1;

#添加非空约束
ALTER TABLE myemp1
MODIFY salary DOUBLE(15,2) NOT NULL;

# 已经存在null值的字段，不允许添加非空约束
ALTER TABLE myemp1
MODIFY email VARCHAR(15) NOT NULL;

# 1.2 唯一性约束(unique)

CREATE TABLE myemp2(
id INT UNIQUE, #列级约束
NAME VARCHAR(15),
email VARCHAR(25),
salary DOUBLE(10,2),
#表级约束
CONSTRAINT myemp2_email_uk UNIQUE(email)
);

INSERT INTO myemp2(id,NAME,email,salary)
VALUES(1,'Tom','tom@126.com',3400);
#添加失败
INSERT INTO myemp2(id,NAME,email,salary)
VALUES(1,'Tom','tom1@126.com',3400);

#添加失败
INSERT INTO myemp2(id,NAME,email,salary)
VALUES(2,'Tom','tom@126.com',3400);

INSERT INTO myemp2(id,NAME,email,salary)
VALUES(3,'Tom',NULL,3400);
# 可以向声明为unique的列中多次添加空值
INSERT INTO myemp2(id,NAME,email,salary)
VALUES(4,'Tom',NULL,3400);

SELECT * FROM myemp2;

#删除唯一性约束 (我们会给声明为unique的列自动添加索引。删除unique约束时，
# 可以使用删除索引的方式)
ALTER TABLE myemp2
DROP INDEX myemp2_email_uk;

# 1.3 主键约束(primary key):非空约束 + 唯一性约束
# 可以通过有主键约束的列，唯一的确定表中的一条记录。
# 一个表中只能声明一个主键约束

CREATE TABLE myemp3(
id INT ,
NAME VARCHAR(15),
salary DOUBLE(10,2),
email VARCHAR(25),
CONSTRAINT myemp3_id_pk PRIMARY KEY(id)
);

DESC myemp3;

INSERT INTO myemp3(id,NAME)
VALUES(1,'Tom');
#失败
INSERT INTO myemp3(id,NAME)
VALUES(1,'Tom1');
#失败
INSERT INTO myemp3(id,NAME)
VALUES(NULL,'Tom2');

#通常创建主键约束的方式：添加AUTO_INCREMENT
CREATE TABLE myemp4(
id INT AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(15)
);

INSERT INTO myemp4(NAME)
VALUES('Tom');

INSERT INTO myemp4(NAME)
VALUES('Tom1');

SELECT * FROM myemp4;

# 1.5 外键约束(foreign key)
# 外键约束作用表A的列a，在赋值时，必须要求其赋的值是表A所关联的表B中相应列b中出现过的值。
#添加外键的要求：要求表B的列b必须声明过主键约束或唯一性约束
CREATE TABLE mydept(
dept_id INT,
dept_name VARCHAR(15)

);



CREATE TABLE myemp5(
id INT,
NAME VARCHAR(15),
dept_id INT,
#表级约束
CONSTRAINT myemp5_deptid_fk FOREIGN KEY(dept_id) REFERENCES mydept(dept_id)
);

#给mydept添加主键约束或唯一性约束
ALTER TABLE mydept
ADD CONSTRAINT mydept_deptid_uk UNIQUE(dept_id);

#演示外键约束的作用
#错误的
INSERT INTO myemp5(id,NAME,dept_id)
VALUES(1,'Tom',10);

INSERT INTO mydept(dept_id,dept_name)
VALUES(10,'IT');
#正确的
INSERT INTO myemp5(id,NAME,dept_id)
VALUES(1,'Tom',10);
#错误的
UPDATE mydept
SET dept_id = 20
WHERE dept_id = 10;


# 1.5 check约束
# 在mysql中check约束失效,oracle中是有效的。
CREATE TABLE myemp6(
id INT AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(15),
salary DOUBLE(10,2) CHECK(salary >= 2000)
);

# mysql:执行成功。 oracle：执行失败
INSERT INTO myemp6(NAME,salary)
VALUES('Tom',1500);

SELECT * FROM myemp6;

# 1.6 默认值约束(default)
CREATE TABLE myemp7(
id INT AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(15),
salary DOUBLE(10,2) DEFAULT 2000
);

INSERT INTO myemp7(NAME)
VALUES('Tom');

SELECT * FROM myemp7;

INSERT INTO myemp7(NAME,salary)
VALUES('Tom1',2500);


# 2.分页
# 题目：查询工资最高的20个人 (第一页：每页20条)
SELECT employee_id,salary
FROM employees
ORDER BY salary DESC
LIMIT 0,20;

#查询第三页的数据：41 - 60 
SELECT employee_id,salary
FROM employees
ORDER BY salary DESC
LIMIT 40,20;

#统一的公式：查询第pageNo页的数据，其中每页显示pageSize条数据
LIMIT (pageNo - 1) * pageSize,pageSize;




