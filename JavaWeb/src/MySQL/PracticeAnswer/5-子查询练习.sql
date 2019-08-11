# 1.查询和Zlotkey相同部门的员工姓名和工资
SELECT last_name, salary
FROM employees
WHERE department_id = (
	SELECT department_id
	FROM employees
	WHERE last_name = 'Zlotkey'
)

# 2.查询工资比公司平均工资高的员工的员工号，姓名和工资。
SELECT employee_id, last_name, salary
FROM employees
WHERE salary > (
	SELECT AVG(salary)
	FROM employees
)

#3.查询各部门中工资比本部门平均工资高的员工的员工号, 姓名和工资
SELECT employee_id, last_name, salary
FROM employees e1
WHERE salary > (
	SELECT AVG(salary)
	FROM employees e2
	WHERE e2.department_id = e1.department_id
)

#4.查询和姓名中包含字母u的员工在相同部门的员工的员工号和姓名
SELECT employee_id, last_name
FROM employees
WHERE department_id = ANY(
	SELECT DISTINCT department_id
	FROM employees
	WHERE last_name LIKE '%u%'
)


# 5.查询在部门的location_id为1700的部门工作的员工的员工号
SELECT employee_id
FROM employees
WHERE department_id IN (
	SELECT department_id
	FROM departments
	WHERE location_id = 1700
)

# 6.查询管理者是King的员工姓名和工资
SELECT last_name, salary
FROM employees
WHERE manager_id IN (
	SELECT employee_id
	FROM employees
	WHERE last_name = 'King'
)


# 7. 查询工资最低的员工信息: last_name, salary	
SELECT last_name,salary
FROM employees
WHERE salary = (
		SELECT MIN(salary)
		FROM employees
	       );

		
# 8. 查询平均工资最低的部门信息
SELECT *
FROM departments
WHERE department_id = (
			SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING AVG(salary) = (
						SELECT MIN(dept_avgsal)
						FROM (
							SELECT AVG(salary) dept_avgsal
							FROM employees
							GROUP BY department_id
							) avg_sal
						)
			);





		
# 9*.查询平均工资最低的部门信息和该部门的平均工资
SELECT d.*,(SELECT AVG(salary) FROM employees WHERE department_id = d.department_id)
FROM departments d
WHERE department_id = (
			SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING AVG(salary) = (
						SELECT MIN(dept_avgsal)
						FROM (
							SELECT AVG(salary) dept_avgsal
							FROM employees
							GROUP BY department_id
							) avg_sal
						)
			);

# 10. 查询平均工资最高的 job 信息
SELECT *
FROM jobs
WHERE job_id = (
		SELECT job_id
		FROM employees
		GROUP BY job_id 
		HAVING AVG(salary) = (
					SELECT MAX(avg_sal)
					FROM(
						SELECT AVG(salary) avg_sal
						FROM employees
						GROUP BY job_id
					    ) job_avgsal
					)
		);



	
# 11. 查询平均工资高于公司平均工资的部门有哪些?
SELECT department_id
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING AVG(salary) > (
		      SELECT AVG(salary)
		      FROM employees
			);

# 12. 查询出公司中所有 manager 的详细信息.
SELECT employee_id,last_name,salary
FROM employees
WHERE employee_id IN (
		      SELECT DISTINCT manager_id
		      FROM employees
		    );

		
# 13. 各个部门中 最高工资中最低的那个部门的 最低工资是多少?
SELECT MIN(salary)
FROM employees
WHERE department_id = (
			SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING MAX(salary) = (
						SELECT MIN(dept_maxsal)
						FROM (
							SELECT MAX(salary) dept_maxsal
							FROM employees
							GROUP BY department_id
							) max_sal
						)
			);



# 14. 查询平均工资最高的部门的 manager 的详细信息: last_name, department_id, email, salary
方式一：
SELECT employee_id,last_name, department_id, email, salary
FROM employees
WHERE employee_id IN (
			SELECT DISTINCT manager_id
			FROM employees
			WHERE department_id = (
						SELECT department_id
						FROM employees
						GROUP BY department_id
						HAVING AVG(salary) = (
									SELECT MAX(avg_sal)
									FROM(
										SELECT AVG(salary) avg_sal
										FROM employees
										GROUP BY department_id
										) dept_sal
						)
			)

);

方式二：
SELECT employee_id,last_name, department_id, email, salary
FROM employees
WHERE employee_id IN (

			SELECT DISTINCT manager_id
			FROM employees
			WHERE department_id = (
						SELECT department_id
						FROM employees e
						GROUP BY department_id
						HAVING AVG(salary)>=ALL(
									SELECT AVG(salary)
									FROM employees
									GROUP BY department_id
									)
			)

);