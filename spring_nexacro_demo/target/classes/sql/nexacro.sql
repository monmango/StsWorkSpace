drop table nexacro;
create table nexacro(
  empl_id varchar2(10),
  full_name varchar2(50),
  dept_id varchar2(10),
  pos_cd varchar2(10),
  hire_date date,
  salary number(10),
  gender varchar2(10),
  married varchar2(10),
  memo varchar2(20)
);
 select * from nexacro;
 delete from nexacro;