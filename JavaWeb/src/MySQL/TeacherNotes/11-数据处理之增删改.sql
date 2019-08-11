# 数据处理之增删改

# 1. 插入数据( insert into ..)
# 方式一：一条一条的添加
CREATE TABLE emp3(
id INT,
NAME VARCHAR(15),
salary DOUBLE(10,2),
hire_date DATE
);

SELECT * FROM emp3;

INSERT INTO emp3
VALUES(1,'Tom',4500,'2018-04-17');

INSERT INTO emp3
VALUES(2,'Tom1',4600,NULL);

#最常用的写法。
#没有声明的字段，会自动赋值为 null
#此语句能够执行的前提是，剩下没有赋值的字段允许赋值为null
INSERT INTO emp3(id,salary)
VALUES(3,4000);


# 方式二：基于现有的表，导入数据
# 要求现有的表的字段的数据类型要与要导入到的表的数据类型一致
# 同时，现有的表的字段的数据不长于要导入到的表的字段的数据的长度
INSERT INTO emp3(id,salary,NAME)
SELECT employee_id,salary,last_name
FROM employees
WHERE department_id IN (20,30,40);

SELECT * FROM emp3;

DESC emp3;

DESC employees;

# 2.更新数据( update .. set ... where ...)
UPDATE emp3
SET NAME = 'Jerry'
WHERE id = 3;

SELECT * FROM emp3;

#更新数据，也有可能会出现更新不成功的情况
SELECT * FROM departments;
#失败
UPDATE employees
SET department_id = 2000
WHERE employee_id = 110;

#成功
UPDATE employees
SET department_id = 200
WHERE employee_id = 110;

#3. 删除数据(delete from ... where ....)
DELETE FROM emp3
WHERE id < 5;

SELECT * FROM emp3;

DELETE FROM emp3
WHERE id = 201;

# 有些时候，会导致删除数据失败
#查询所有部门的人数
SELECT d.department_id, COUNT(employee_id)
FROM departments d LEFT JOIN employees e
ON d.`department_id` = e.`department_id`
GROUP BY d.`department_id`;

#删除失败
DELETE FROM departments
WHERE department_id = 30;

#删除成功
DELETE FROM departments
WHERE department_id = 190;


