select * from employee;
select * from title;
select * from department;

set foreign_key_checks = 0; 
delete from employee;
set foreign_key_checks = 1;

SELECT empno, empname FROM employee where dno=1 or manager is null;

select empno, empname, title, manager, salary, gender, dno, hire_date from employee;

select e.empno, e.empname, tno, tname, e.manager, m.empname as m_name, e.salary, e.gender, deptno, deptname, floor, e.hire_date from employee e left join title t on e.title = t.tno join department d on e.dno = d.deptno join employee m on e.manager = m.empno union select e.empno, e.empname, tno, tname, e.manager, null, e.salary, e.gender, deptno, deptname, floor, e.hire_date from employee e left join title t on e.title = t.tno join department d on e.dno = d.deptno where manager is null order by empno;
