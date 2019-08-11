# 分组函数
# 常见的数据类型：数值型；字符型；日期型

# avg() / sum() : 只适用于数值型的变量。不适用于字符型 和日期型
SELECT AVG(salary),SUM(salary)
FROM employees;

# oracle:报错。 mysql:不报错，结果是0
SELECT AVG(last_name) #,avg(hire_date)
FROM employees;


# max() / min(): 适用于数值型；字符型；日期型的变量
SELECT MAX(salary),MIN(salary),MAX(last_name),MIN(last_name)
FROM employees;



# count()：求所对应列中非空数值的个数。适用于数值型；字符型；日期型的变量
SELECT COUNT(employee_id),COUNT(last_name),COUNT(commission_pct)
FROM employees;

SELECT COUNT(salary),COUNT(1),COUNT(2)
FROM employees;


SELECT commission_pct
FROM employees
WHERE commission_pct IS NOT NULL;

SELECT COUNT(*),COUNT(NULL)
FROM employees;

#思考题？
SELECT AVG(salary),SUM(salary) / COUNT(salary)
FROM employees;

# 结论： avg = sum / count
SELECT AVG(commission_pct),SUM(commission_pct) / COUNT(commission_pct),
SUM(commission_pct)/ 107,SUM(commission_pct) / COUNT(IFNULL(commission_pct,0))
FROM employees;

# group by的使用
#求出EMPLOYEES表中各部门的平均工资
SELECT department_id,AVG(salary)
FROM employees
GROUP BY department_id;

SELECT job_id,AVG(salary)
FROM employees
GROUP BY job_id;

# 错误的写法。（oracle:报错！ mysql:没报错，但结果不错）
SELECT job_id,AVG(salary)
FROM employees;

#查询不同部门，不同job_id的员工的平均工资
# 结论：如果select中出现了组函数的列和非组函数的列，那么一定要使用非组函数的列进行分组。
# 即：非组函数的列一定要声明在group by中。
SELECT department_id,job_id,AVG(salary)
FROM employees
GROUP BY department_id,job_id;

#反之，出现在group by中的列不一定非要声明在select中
SELECT department_id,AVG(salary)
FROM employees
GROUP BY department_id,job_id;


SELECT job_id,department_id,AVG(salary)
FROM employees
GROUP BY job_id,department_id;

#having的使用
#部门最高工资比 10000 高的部门

#错误的写法
SELECT department_id,MAX(salary)
FROM employees
# 如果过滤条件中出现了组函数，则必须使用having 替换 where
WHERE MAX(salary) > 10000
GROUP BY department_id;

#正确的写法
SELECT department_id,MAX(salary)
FROM employees
# 1.如果过滤条件中出现了组函数，则必须使用having 替换 where
# 2.mysql中要求having声明在group by后面，而oracle中没有此要求。
GROUP BY department_id
HAVING MAX(salary) > 10000;


#从10,20,30,40部门中，查找部门最高工资比 10000 高的部门
#方式一：
SELECT department_id,MAX(salary)
FROM employees
GROUP BY department_id
HAVING MAX(salary) > 10000 
AND department_id IN (10,20,30,40);

或
# 方式二：
# 总结：方式二从sql优化的角度来说，要优于方式一。
# having 过滤是在进行完全表检索以后，实现的过滤。
# 结论：包含非组函数的过滤条件要声明在where中，包含组函数的过滤条件声明在having中
SELECT department_id,MAX(salary)
FROM employees
WHERE department_id IN (10,20,30,40)
GROUP BY department_id
HAVING MAX(salary) > 10000;

#课后练习：7.查询所有部门的名字，location_id，员工数量和工资平均值
SELECT department_name,location_id,COUNT(employee_id),AVG(salary)
FROM employees e RIGHT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`
GROUP BY department_name,location_id



