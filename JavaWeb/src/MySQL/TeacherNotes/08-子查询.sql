# 子查询

#谁的工资比 Abel 高?
#方式一：
SELECT salary
FROM employees
WHERE last_name = 'Abel';

SELECT last_name,salary
FROM employees
WHERE salary > 11000;

#方式二：自连接
SELECT e2.last_name,e2.salary
FROM employees e1,employees e2
WHERE e1.`last_name` = 'Abel'
AND e1.`salary` < e2.`salary`;

#方式三：子查询

#外查询
SELECT last_name,salary
FROM employees
WHERE salary > (
		#子查询（内查询）
		SELECT salary
		FROM employees
		WHERE last_name = 'Abel'
		);

# 子查询的分类：单行子查询 ； 多行子查询


#题目：返回job_id与141号员工相同，salary比143号员工多的员工姓名，job_id 和工资
SELECT last_name,job_id,salary
FROM employees
WHERE job_id = (
		SELECT job_id
		FROM employees
		WHERE employee_id = 141
		)
AND salary > (
		SELECT salary
		FROM employees
		WHERE employee_id = 143
		);

#题目：返回公司工资最少的员工的last_name,job_id和salary

SELECT last_name,job_id,salary
FROM employees
WHERE salary = (
		SELECT MIN(salary)
		FROM employees
		);


#题目：查询最低工资大于60号部门最低工资的部门id和其最低工资

SELECT department_id,MIN(salary)
FROM employees
GROUP BY department_id
HAVING MIN(salary) > (
		      SELECT MIN(salary)
		      FROM employees
		      WHERE department_id = 60
		     );

# 关于查询的空值问题，不是错误
SELECT last_name, job_id
FROM   employees
WHERE  job_id =
                (SELECT job_id
                 FROM   employees
                 WHERE  last_name = 'Haas');

#非法使用子查询
#Subquery returns more than 1 row
SELECT employee_id, last_name
FROM   employees
WHERE  salary =
                (SELECT   MIN(salary)
                 FROM     employees
                 GROUP BY department_id);


# 多行子查询
SELECT employee_id, last_name
FROM   employees
WHERE  salary IN
                (SELECT   MIN(salary)
                 FROM     employees
                 GROUP BY department_id);
                 
                 
                 
#题目：返回其它部门中比job_id为‘IT_PROG’部门任一工资低的员工的
#员工号、姓名、job_id 以及salary

SELECT employee_id,last_name,job_id,salary
FROM employees
WHERE salary < ANY(
		SELECT salary
		FROM employees
		WHERE job_id = 'IT_PROG'
		)
AND job_id != 'IT_PROG';

#题目：返回其它部门中比job_id为‘IT_PROG’部门所有工资都低的员工
#的员工号、姓名、job_id 以及salary
SELECT employee_id,last_name,job_id,salary
FROM employees
WHERE salary < ALL(
		SELECT salary
		FROM employees
		WHERE job_id = 'IT_PROG'
		)
AND job_id != 'IT_PROG';
                
#总结：
SELECT ...,...,...,...(包含组函数)
FROM ...,...,...
WHERE 连接条件 
AND 过滤条件(不包含组函数的)
GROUP BY ...,...,...(查询中非组函数的列)
HAVING 过滤条件(包含组函数的)
ORDER BY ... ASC/DESC , ... ASC/DESC,...
LIMIT ...

或

SELECT ...,...,...,...(包含组函数)
FROM ... JOIN ...
ON ...
JOIN ...
ON ...
WHERE 过滤条件(不包含组函数的)
GROUP BY ...,...,...(查询中非组函数的列)
HAVING 过滤条件(包含组函数的)
ORDER BY ... ASC/DESC , ... ASC/DESC,...
LIMIT ...