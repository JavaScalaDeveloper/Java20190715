# 过滤和排序数据
# 返回在90号部门工作的所有员工的信息

SELECT *
FROM employees
#where 过滤条件； where 需要声明在from的后面
WHERE department_id = 90;

SELECT employee_id,last_name,salary
FROM employees
#WHERE salary  =  6000;
WHERE salary != 6000;

# between ... and ... (包含边界)
SELECT employee_id,last_name,salary
FROM employees
WHERE salary BETWEEN 6000 AND 8000;
#where salary >= 6000 and salary <= 8000;
#查询不到数据
#where salary between 8000 and 6000;

# in (..,...,..)
SELECT last_name,department_id
FROM employees
#where department_id in (50,60,70);
WHERE department_id = 50 OR department_id = 60 OR department_id = 70;

# like ... 模糊查询
SELECT last_name,email
FROM employees
WHERE last_name = 'Austin';#精确查询； 字符型需要使用一对''括起来

# 查询姓名中包含字符a的员工信息
SELECT last_name,email
FROM employees
WHERE last_name LIKE '%a%'; # %:表示0个，1个或多个字符

# 查询姓名中最后一个字符是a的员工信息
SELECT last_name,email
FROM employees
WHERE last_name LIKE '%a';

# 查询姓名中第三个字符是a的员工信息
SELECT last_name,email
FROM employees
WHERE last_name LIKE '__a%'; # _ :表示为一个字符

# 查询姓名中第二个字符是_,第三个字符是a的员工信息
SELECT last_name,email
FROM employees
WHERE last_name LIKE '_\_a%' ;  # 默认转义字符是：\

SELECT last_name,email
FROM employees
WHERE last_name LIKE '_$_a%' ESCAPE '$';# 此时 $ 也是转义字符

# is null:为空值的数据
SELECT last_name,salary,commission_pct
FROM employees
WHERE commission_pct IS NULL;


SELECT last_name,salary,commission_pct
FROM employees
WHERE commission_pct IS NOT NULL;

# 凡是空值参与的运算，结果也为空。   String name = null; name = "";
# 空值，不同于0,也不同与''
SELECT last_name,salary,commission_pct,salary * (1 + commission_pct) * 12 "annual salary"
FROM employees;

SELECT last_name,salary,commission_pct,salary * (1 + IFNULL(commission_pct,0)) * 12 "annual salary"
FROM employees;

# 逻辑运算符： and  /  or  / not


# 排序数据 (order by ... )

# 查询公司员工的工资，从高到低排序
# asc(ascend):升序
# desc(descend):降序
SELECT employee_id,last_name,salary
FROM employees
ORDER BY salary DESC;

SELECT employee_id,last_name,salary
FROM employees
#order by salary asc;
ORDER BY salary; # 默认按照升序排列

# 二级排序：查询公司员工的信息，按照部门从小到大排列,按照姓名从大到小排序
SELECT employee_id,last_name,department_id
FROM employees
ORDER BY department_id ,last_name DESC;

# 可以按照列的别名实现排序
SELECT employee_id,last_name,salary sal
FROM employees
ORDER BY sal;

# 如果出现过滤条件（where)和排序(order by)的话，排序写在后面
SELECT employee_id,last_name,department_id,salary sal
FROM employees
WHERE department_id IN (50,60,70,80)
ORDER BY sal;

#不能使用列的别名实现过滤
SELECT employee_id,last_name,salary sal
FROM employees
WHERE sal = 6000;

#练习中涉及的问题
# 查询公司中员工的job_id都有哪些
SELECT DISTINCT job_id
FROM employees;


SELECT DISTINCT department_id
FROM employees;

#选择工资不在5000到12000的员工的姓名和工资
SELECT last_name,salary
FROM employees
#where salary < 5000 or salary > 12000;
WHERE salary NOT BETWEEN 5000 AND 12000;

#选择公司中没有管理者的员工姓名及job_id
SELECT last_name,job_id
FROM employees
WHERE manager_id IS NULL;

#选择姓名中有字母a和e的员工姓名
SELECT last_name
FROM employees
#where last_name like '%a%e%' or last_name like '%e%a%';
WHERE last_name LIKE '%a%' AND last_name LIKE '%e%';

