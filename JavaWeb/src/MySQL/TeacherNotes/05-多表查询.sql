# 多表查询
#查询员工的id,姓名和部门名称(下面是错误的)
#出现了笛卡尔集的错误：如果多表查询中，没有多表的连接条件，或多表的连接条件失效。
SELECT employee_id,last_name,department_name
FROM employees,departments; # 2889

SELECT * 
FROM departments;

SELECT 107 * 27
FROM DUAL;

#查询员工的id,姓名和部门名称
SELECT employee_id,last_name,department_name
FROM employees,departments
#多表的连接条件
WHERE employees.department_id = departments.department_id;

SELECT *
FROM employees
WHERE employee_id = 147;

SELECT *
FROM departments;



#查询员工的id,姓名,部门id和部门名称
#如果查询的列，同时存在于两个不同的表中，则必须指明此列所属的表
#sql优化：我们查询的字段显式的都指明其所有的表。是较不指明效率高的。
SELECT employees.employee_id,employees.last_name,departments.department_name,departments.department_id
FROM employees,departments
#多表的连接条件
WHERE employees.department_id = departments.department_id;

#关于表的别名
SELECT e.employee_id,e.last_name,d.department_name,d.department_id
FROM employees e,departments d
#多表的连接条件
WHERE e.department_id = d.department_id;

#类似：查询员工的employee_id,last_name,job_title
SELECT e.employee_id,e.last_name,j.job_title,e.job_id
FROM employees e, jobs j
WHERE e.`job_id` = j.`job_id`;

#查询员工的employee_id,last_name,department_name,city
# 总结：如果查询中涉及到n个表，则至少有 n - 1 个连接条件
SELECT employee_id,last_name,department_name,city,d.location_id
FROM employees e,departments d,locations l
WHERE e.`department_id` = d.`department_id` 
AND d.`location_id` = l.`location_id`;

# 总结：
# 等值连接  vs  非等值连接
# 自连接  vs 非自连接
# 内连接  vs  外连接

# 非等值连接：
# 查询员工的姓名，工资，和工资的等级
SELECT last_name,salary,grade
FROM employees e,job_grades j
WHERE e.salary BETWEEN j.lowest_sal AND j.highest_sal;

# 自连接：
# 查询员工的employee_id,last_name和其管理者的employee_id,last_name
SELECT emp.employee_id,emp.last_name,mgr.employee_id,mgr.last_name
FROM employees emp,employees mgr
WHERE emp.`manager_id` = mgr.`employee_id`;

#内连接: 只能查询出两个表中匹配的行。
SELECT last_name,e.department_id,department_name
FROM employees e,departments d
WHERE e.`department_id` = d.`department_id`;

# 左外连接：除了查询出两个表中匹配的行之外，还可以返回左表中不满足条件的行
# 右外连接：除了查询出两个表中匹配的行之外，还可以返回右表中不满足条件的行
# 满外连接：除了查询出两个表中匹配的行之外，还可以返回左表和右表中不满足条件的行

# 查询所有员工的last_name,department_id,department_name
SELECT last_name,e.department_id,department_name
FROM employees e,departments d
WHERE e.`department_id` = d.`department_id`(+); #左外连接：只适用于oracle

# sql 99 语法，如何实现多表查询的
# 之前方式写的内连接：
SELECT last_name,e.department_id,department_name
FROM employees e,departments d
WHERE e.`department_id` = d.`department_id`;

# sql 99语法实现：
SELECT last_name,e.department_id,department_name
FROM employees e JOIN departments d
ON e.`department_id` = d.`department_id`;

#查询员工的employee_id,last_name,department_name,city
SELECT employee_id,last_name,department_name,city
FROM employees e JOIN departments d
ON e.`department_id` = d.`department_id`
JOIN locations l
ON d.`location_id` = l.`location_id`;
# join ... on ... 
# join ... on ...

# 使用sql 99 语法实现外连接：
#查询所有员工的last_name,department_id,department_name
SELECT last_name,e.department_id,department_name
FROM employees e LEFT JOIN departments d
ON e.`department_id` = d.`department_id`;

# 右外连接
SELECT last_name,e.department_id,department_name
FROM employees e RIGHT JOIN departments d
ON e.`department_id` = d.`department_id`;

# 满外连接:适用于oracle，不适用于mysql
SELECT last_name,e.department_id,department_name
FROM employees e FULL JOIN departments d
ON e.`department_id` = d.`department_id`;


# 课后练习：
# 等值 vs  非等值
# 自连接 vs 非自连接
# 内连接 vs 外连接 （sql 99）

SELECT ...,...,...
FROM 表1,表2,...
WHERE 多表的连接条件1 AND 多表的连接条件2 AND ....
AND 过滤条件
ORDER BY ... ASC / DESC,... ASC/DESC,...;

或

SELECT ..,..,...
FROM 表1 JOIN 表2
ON 多表的连接条件1
JOIN 表3
ON 多表的连接条件2
JOIN ...
ON ...
WHERE 过滤条件1 AND 过滤条件2 AND ....
ORDER BY ... ASC / DESC,... ASC/DESC,...;

# 1.显示所有员工的姓名，部门号和部门名称。
SELECT last_name, d.department_id, department_name
FROM employees e
LEFT JOIN departments d
ON e.`department_id` = d.`department_id`;

# 3.选择所有有奖金的员工的 last_name , department_name , location_id , city
SELECT e.last_name , d.department_name , l.location_id , l.city
FROM employees e LEFT JOIN departments d
ON e.`department_id` = d.`department_id`
LEFT JOIN locations l
ON d.`location_id` = l.`location_id`
WHERE e.`commission_pct` IS NOT NULL;

SELECT *
FROM employees
WHERE commission_pct IS NOT NULL;

# 4.选择city在Toronto工作的员工的 last_name , job_id , department_id , department_name 
SELECT last_name , job_id , e.department_id , department_name
FROM employees e, departments d, locations l
WHERE e.`department_id` = d.`department_id`
AND d.`location_id` = l.`location_id`
AND city = 'Toronto';


# 5.选择指定员工的姓名，员工号，以及他的管理者的姓名和员工号，结果类似于下面的格式
employees	Emp#	manager	Mgr#
kochhar		101	king	100

SELECT emp.last_name employees, emp.employee_id "Emp#", mgr.last_name manager, mgr.employee_id "Mgr#"
FROM employees emp 
LEFT JOIN employees mgr
ON emp.manager_id = mgr.employee_id;

