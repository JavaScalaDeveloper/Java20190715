# 单行函数

# 字符类型的函数
SELECT LOWER('ab c DEF'),UPPER('abc D EF')
FROM DUAL;

SELECT *
FROM employees
WHERE LOWER(last_name) = 'king';

# xxx worked for yyy
SELECT CONCAT(emp.last_name,' worked for ',mgr.last_name) "details"
FROM employees emp,employees mgr
WHERE emp.`manager_id` = mgr.`employee_id`;

#在sql中涉及索引的话，从1开始。---> JDBC(涉及索引的话，从1开始的)
SELECT SUBSTR('helloworld',2,5) 
FROM DUAL;

SELECT INSTR('helloworld', 'k') #返回指定字符首次出现的位置.若没有，返回0
FROM DUAL;

SELECT RPAD(last_name,15,' ')
FROM employees;

SELECT LPAD(salary,10,' ')
FROM employees;

SELECT TRIM(' ' FROM '  hhhellohw orldhh  ')
FROM DUAL;

SELECT REPLACE('hello','l','m')
FROM DUAL;

# 数值类型的函数
#round:四舍五入
SELECT ROUND(123.456),ROUND(123.456,0),ROUND(123.456,2),ROUND(155.456,-2)
FROM DUAL;

# truncate:截断
SELECT TRUNCATE(123.556,0),TRUNCATE(123.999,2),TRUNCATE(154.23,-2)
FROM DUAL; 

# 结果的符号与被模数一致
SELECT MOD(12,5),MOD(12,-5),MOD(-12,5),MOD(-12,-5)
FROM DUAL;

# 日期型的函数
SELECT NOW()
FROM DUAL;

# 通用型的函数
SELECT last_name,salary,12 * salary * (1 + IFNULL(commission_pct,0))
FROM employees;

# 条件表达式： case .. when .. then .. when .. then .. else .. end

#练习：查询所有部门的员工信息, 
#若部门号为 10, 则打印其工资的 1.1 倍, 
#20 号部门, 则打印其工资的 1.2 倍, 
#30 号部门打印其工资的 1.3 倍数,
#其他部门，打印其工资的1.4倍
SELECT last_name,department_id,salary,CASE department_id WHEN 10 THEN salary * 1.1
							 WHEN 20 THEN salary * 1.2
							 WHEN 30 THEN salary * 1.3
							 ELSE salary * 1.4 END "new salary"
FROM employees;





#练习：查询部门号为 10, 20, 30 的员工信息, 
#若部门号为 10, 则打印其工资的 1.1 倍, 
#20 号部门, 则打印其工资的 1.2 倍, 
#30 号部门打印其工资的 1.3 倍数

SELECT last_name,department_id,salary,CASE department_id WHEN 10 THEN salary * 1.1
							 WHEN 20 THEN salary * 1.2
							 WHEN 30 THEN salary * 1.3
							 END "new salary"
FROM employees
WHERE department_id IN (10,20,30);


SELECT last_name, job_id, salary,
       CASE job_id WHEN 'IT_PROG'  THEN  1.10*salary
                   WHEN 'ST_CLERK' THEN  1.15*salary
                   WHEN 'SA_REP'   THEN  1.20*salary
		   ELSE salary END     "REVISED_SALARY"
FROM   employees;

#课后练习
5.	使用case-when，按照下面的条件：
-- job                  grade
-- AD_PRES              A
-- ST_MAN               B
-- IT_PROG              C
-- SA_REP               D
-- ST_CLERK             E

-- 产生下面的结果
-- Last_name	Job_id	Grade
-- king	       AD_PRES	A

SELECT last_name Last_name, job_id Job_id, CASE job_id WHEN 'AD_PRES' THEN 'A'
						       WHEN 'ST_MAN' THEN 'B'
						       WHEN 'IT_PROG' THEN 'C'
						       WHEN 'SA_REP' THEN 'D'
						       WHEN 'ST_CLERK' THEN 'E'
						       ELSE 'F'
						       END "Grade"
FROM employees;

