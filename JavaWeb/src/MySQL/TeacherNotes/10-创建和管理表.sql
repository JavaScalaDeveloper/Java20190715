# 创建和管理表

# 显示已有的数据库
SHOW DATABASES;

#使用指定的数据库
USE test;
USE myemployees;

#创建数据库
CREATE DATABASE temp;

# 查看以后的数据库中的表
SHOW TABLES;

# 常见的数据库对象都有哪些？
# 表(table)/ 视图(view) / 索引(index) / 序列(sequence) / 存储过程(procedure) 
# 函数(function) / 触发器(trigger)

# 1.创建数据表(table)
# 两种方式：
# 方式一："白手起家"
CREATE TABLE emp(
id INT,
NAME VARCHAR(15),
salary DOUBLE(10,2),
hire_date DATE
);

SELECT * FROM emp;

DESC emp;

# 方式二：基于现有的表
CREATE TABLE emp1
AS
SELECT employee_id,last_name
FROM employees;
# 此种方式，会同步的将原表中的数据拷贝过来。但是部分约束不会拷贝过来
SELECT * FROM emp1;
# emp1表中字段的数据类型和数据长度，也与原表保持一致
DESC emp1;

DESC employees;

#创建新表，指定新的列的名字
CREATE TABLE emp2
AS
SELECT employee_id emp_id,last_name NAME
FROM employees
WHERE department_id IN (10,20,30,40);

SELECT * FROM emp2;

#复制一个employees表（包括数据）:
CREATE TABLE employees_copy
AS
SELECT * FROM employees;


SELECT * FROM employees_copy;

DESC employees_copy;
DESC employees;

#复制一个employees表（不包括数据）:
CREATE TABLE employees_blank
AS
SELECT *
FROM employees
WHERE 1=2;

SELECT * FROM employees_blank;


# 2.修改表(alter table)
# ① 新增一个列
ALTER TABLE emp
ADD email VARCHAR(25);

DESC emp;

# ② 删除一个列
ALTER TABLE emp
DROP COLUMN email;

DESC emp;
# ③ 修改列的数据类型、数据长度
ALTER TABLE emp
MODIFY salary DOUBLE(15,2); #修改数据长度

DESC emp;

ALTER TABLE emp
MODIFY salary VARCHAR(15);

# 一般情况下，我们不会修改数据表的列的数据类型。
ALTER TABLE emp1
MODIFY last_name DOUBLE(15,2);

ALTER TABLE emp1
MODIFY employee_id VARCHAR(15); #使用了double 到 varchar的自动类型转化

DESC emp1;

# ④ 重命名列
ALTER TABLE emp
CHANGE id emp_id INT; # oracle: rename id to emp_id.

DESC emp;

# 3. 重命名表   # rename emp to myemp;
ALTER TABLE emp
RENAME TO myemp;

DESC emp;#Table 'myemployees.emp' doesn't exist

# 4.删除表
DROP TABLE myemp;

# 5. 清空表 (truncate table):会将表中的所有数据清空，但是不会删除表结构
SELECT * FROM emp1;

# 对比 清空表(truncate table)和删除表数据(delete from ..) 
# 清空表操作一旦执行，不能回滚
# 删除表数据的操作执行完后，还可以回滚

#前提：设置不允许自动提交数据
SET autocommit = FALSE;

DELETE FROM emp1; 

SELECT * FROM emp1;

# 回滚数据
ROLLBACK;  # DCL中的操作

#********************

TRUNCATE TABLE emp1; # 不可回滚。或者理解为：每次执行以后，会自动提交数据。

ROLLBACK;  # 会回滚到最近的一次commit的位置。


#********DCL：commit / rollback***********
SET autocommit = FALSE;

SELECT * FROM employees_copy;

DELETE FROM employees_copy;

ROLLBACK;

COMMIT; # 数据一旦提交，就不可回滚。

ROLLBACK; 

# 数据库事务：一组逻辑操作单元(一条或多条DML操作),使数据从一种状态变换到另一种状态。

#举例：
# AA 给 BB 转账 100.
#过程：① 从AA账户中减100  ② 向BB账户中加100
# 第一步：
#SET autocommit = FALSE;
# try{
# 第二步：
# ① 从AA账户中减100

# 可能存在异常

# ② 向BB账户中加100

# 第三步：提交数据
# commit;

# }catch(){
# 第四步：回滚数据
# rollback;
#}
