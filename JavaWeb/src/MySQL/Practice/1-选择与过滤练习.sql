#别名的使用
SELECT employee_id , last_name,
salary * 12  "ANNUAL  SALARY"
FROM employees;

#去除重复行
SELECT DISTINCT job_id
FROM employees;

#连接字符串
SELECT CONCAT(employee_id, ',' , last_name , ',', salary) OUT_PUT
FROM employees;

# 1.查询工资大于12000的员工姓名和工资



# 2.查询员工号为176的员工的姓名和部门号



# 3.选择工资不在5000到12000的员工的姓名和工资



# 4.选择在20或50号部门工作的员工姓名和部门号



# 5.选择公司中没有管理者的员工姓名及job_id



#6.选择公司中有奖金的员工姓名，工资和奖金级别



# 7.选择员工姓名的第三个字母是a的员工姓名



# 8.选择姓名中有字母a和e的员工姓名



