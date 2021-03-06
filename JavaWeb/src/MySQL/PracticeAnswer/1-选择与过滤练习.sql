SELECT employee_id , last_name,
salary * 12  "ANNUAL  SALARY"
FROM employees;

-- 去除重复行
SELECT DISTINCT job_id
FROM employees;

-- 连接字符串
SELECT CONCAT(employee_id, ',' , last_name , ',', salary) OUT_PUT
FROM employees;

# 1.查询工资大于12000的员工姓名和工资
SELECT last_name, salary
FROM employees
WHERE salary > 12000;

# 2.查询员工号为176的员工的姓名和部门号
SELECT last_name, department_id
FROM employees
WHERE employee_id = 176;

# 3.选择工资不在5000到12000的员工的姓名和工资
SELECT last_name, salary
FROM employees
WHERE salary < 5000 OR salary > 12000;

SELECT last_name, salary
FROM employees
WHERE salary NOT BETWEEN 5000 AND 12000;


# 4.选择在20或50号部门工作的员工姓名和部门号
SELECT last_name, department_id
FROM employees
WHERE department_id = 20 OR department_id = 50;

SELECT last_name, department_id
FROM employees
WHERE department_id IN(20, 50);

# 5.选择公司中没有管理者的员工姓名及job_id
SELECT last_name, job_id
FROM employees
WHERE manager_id IS NULL;


#6.选择公司中有奖金的员工姓名，工资和奖金级别
SELECT last_name, salary, commission_pct
FROM employees
WHERE commission_pct IS NOT NULL;


# 7.选择员工姓名的第三个字母是a的员工姓名
SELECT last_name
FROM employees
WHERE last_name LIKE '__a%';

# 8.选择姓名中有字母a和e的员工姓名
SELECT last_name
FROM employees
WHERE last_name LIKE '%a%e%' OR last_name LIKE '%e%a%';

