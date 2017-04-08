
INSERT INTO country (id, name) VALUES (1, 'USA');
INSERT INTO country (id, name) VALUES (2, 'Spain');
INSERT INTO country (id, name) VALUES (3, 'UK');
INSERT INTO country (id, name) VALUES (4, 'France');
INSERT INTO country (id, name) VALUES (5, 'Italy');


INSERT INTO java_skills (id, name) VALUES (1, 'Hibernate');
INSERT INTO java_skills (id, name) VALUES (2, 'Spring');
INSERT INTO java_skills (id, name) VALUES (3, 'Struts');
INSERT INTO java_skills (id, name) VALUES (4, 'Apache Wicket');
INSERT INTO java_skills (id, name) VALUES (5, 'Maven');


INSERT INTO user (id, password, gender, country_id) VALUES ('user1', 'pass1', 'M', 1);
INSERT INTO user (id, password, gender, country_id) VALUES ('user2', 'pass1', 'F', 2);
INSERT INTO user (id, password, gender, country_id) VALUES ('user3', 'pass1', 'F',1);
INSERT INTO user (id, password, gender, country_id) VALUES ('user4', 'pass1', 'M',3);

INSERT INTO user_java_skill(skill_id, user_id) VALUES(2,'user3');
INSERT INTO user_java_skill(skill_id, user_id) VALUES(3,'user3');
INSERT INTO user_java_skill(skill_id, user_id) VALUES(5,'user3');




