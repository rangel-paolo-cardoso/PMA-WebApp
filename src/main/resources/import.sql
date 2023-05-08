-- INSERT EMPLOYEES
insert into employee (first_name, last_name, email) values ('John', 'Warton', 'warton@gmail.com');
insert into employee (first_name, last_name, email) values ('Mike', 'Lanister', 'lanister@gmail.com');
insert into employee (first_name, last_name, email) values ('Steve', 'Reeves', 'reeves@gmail.com');
insert into employee (first_name, last_name, email) values ('Ronald', 'Connor', 'connor@gmail.com');
insert into employee (first_name, last_name, email) values ('Jim', 'Salvator', 'sal@gmail.com');
insert into employee (first_name, last_name, email) values ('Peter', 'Henley', 'henley@gmail.com');
insert into employee (first_name, last_name, email) values ('Richard', 'Carson', 'carson@gmail.com');
insert into employee (first_name, last_name, email) values ('Honor', 'Miles', 'miles@gmail.com');
insert into employee (first_name, last_name, email) values ('Tony', 'Roggers', 'roggers@gmail.com');

-- INSERT PROJECTS
insert into project (project_id, name, stage, description) values (1000, 'Large Production Deploy', 'NOTSTARTED', 'This requires all hands on deck for the final deployment of the software into production');
insert into project (project_id, name, stage, description) values (1001, 'New Employee Budget', 'COMPLETED', 'Decide on a new employee bonus budget for the year and figure out who will be promoted');
insert into project (project_id, name, stage, description) values (1002, 'Office Reconstruction', 'INPROGRESS', 'The office building in Monroe has been damaged due to hurricane in the region, This needs to be reconstructed');
insert into project (project_id, name, stage, description) values (1003, 'Improve Intranet Security', 'INPROGRESS', 'Withthe recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation');

-- INSERT PROJECT_EMPLOYEE_RELATION
insert into project_employee (employee_id, project_id) values (1, 1000)
insert into project_employee (employee_id, project_id) values (1, 1001)
insert into project_employee (employee_id, project_id) values (1, 1002)
insert into project_employee (employee_id, project_id) values (1, 1000)
insert into project_employee (employee_id, project_id) values (3, 1000)
insert into project_employee (employee_id, project_id) values (3, 1003)
insert into project_employee (employee_id, project_id) values (1, 1001)
insert into project_employee (employee_id, project_id) values (1, 1002)
insert into project_employee (employee_id, project_id) values (6, 1002)
insert into project_employee (employee_id, project_id) values (6, 1003)
insert into project_employee (employee_id, project_id) values (6, 1002)
insert into project_employee (employee_id, project_id) values (6, 1003)
