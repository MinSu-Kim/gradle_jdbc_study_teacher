select * from employee;
select * from title;
select * from department;


select empno, empname, title, manager, salary, gender, dno, hire_date from employee;

select e.empno, e.empname, tno, tname, e.manager, m.empname as m_name, e.salary, e.gender, deptno, deptname, floor, e.hire_date from employee e left join title t on e.title = t.tno join department d on e.dno = d.deptno join employee m on e.manager = m.empno;