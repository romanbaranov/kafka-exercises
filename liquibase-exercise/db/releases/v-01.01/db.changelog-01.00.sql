-- liquibase formatted sql

-- changeset rnbv:003-seed-db context:update
-- comment: JIRA-1234
INSERT INTO HR.GLOBAL_VARS (GLOBAL_VARS_ID, global_vars_name , global_vars_description) VALUES(0, 'test-var-0', 'business rule test-var-0');
INSERT INTO HR.GLOBAL_VARS (GLOBAL_VARS_ID, global_vars_name , global_vars_description) VALUES(1, 'test-var-1', 'business rule test-var-1');
INSERT INTO HR.GLOBAL_VARS (GLOBAL_VARS_ID, global_vars_name , global_vars_description) VALUES(2, 'test-var-2', 'business rule test-var-2');
INSERT INTO HR.GLOBAL_VARS (GLOBAL_VARS_ID, global_vars_name , global_vars_description) VALUES(3, 'test-var-3', 'business rule test-var-3');
-- rollback TRUNCATE TABLE HR.GLOBAL_VARS;