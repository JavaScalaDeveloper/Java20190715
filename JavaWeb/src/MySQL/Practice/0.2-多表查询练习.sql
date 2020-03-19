# 1.显示所有员工的姓名，部门号和部门名称。
SELECT last_name,d.department_id,d.department_name
FROM employees e 
LEFT OUTER JOIN departments d
ON e.`department_id`=d.`department_id`;


# 2.查询90号部门员工的job_id和90号部门的location_id
SELECT job_id, location_id
FROM employees e, departments d
WHERE e.`department_id` = d.`department_id`
AND e.`department_id` = 90;


# 3.选择所有有奖金的员工的 last_name , department_name , location_id , city
SELECT e.last_name,d.department_name,d.location_id,l.city
FROM departments d
LEFT OUTER JOIN locations l ON d.`location_id`=l.`location_id`
RIGHT OUTER JOIN employees e ON d.`department_id`=e.`department_id`
WHERE e.commission_pct IS NOT NULL;


# 4.选择city在Toronto工作的员工的 last_name , job_id , department_id , department_name 
SELECT e.last_name , e.job_id , d.department_id , d.department_name 
FROM departments d
LEFT OUTER JOIN employees e ON e.`department_id`=d.`department_id`
RIGHT OUTER JOIN locations l ON l.`location_id`=d.`location_id`
WHERE l.`city`='Toronto';


# 5.选择指定员工的姓名，员工号，以及他的管理者的姓名和员工号，结果类似于下面的格式
#employees	Emp#	manager	Mgr#
#kochhar		101	king	100
SELECT e.last_name employees, e.employee_id 'Emp#',e.manager_id manager,e.employee_id 'Mgr#'
FROM employees e
LEFT OUTER JOIN employees em ON e.`employee_id`=em.`employee_id`;


