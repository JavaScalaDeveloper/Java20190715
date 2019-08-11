# 基本的SELECT语句  

SELECT employee_id,last_name,email 
FROM employees;

SELECT department_id,department_name
FROM departments;

# 查询表中的所有的列
SELECT * # * :表示所有的列
FROM EMPLOYEES;

SELECT * FROM departments;

SELECT *
FROM locations;

# 关于列的别名:三种方式
# 别名可以使用一对""引起来
SELECT employee_id emp_id, last_name AS NAME, salary "monthly salary" , email "邮箱"# as : alias:别名
FROM employees;
# 注意：如果涉及到日期类型 或 字符类型 的话，需要使用一对''。


#显示表结构
DESC employees;

DESCRIBE employees;


