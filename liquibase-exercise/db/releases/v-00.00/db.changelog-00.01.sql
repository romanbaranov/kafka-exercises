-- liquibase formatted sql

-- changeset rnbv:002-seed-db
-- comment: JIRA-1234
INSERT INTO HR.RULES_V2 (RULES_V2_ID, RULE_NAME, RULE_DESCRIPTION) VALUES(0, 'test-0', 'business rule test-0');
INSERT INTO HR.RULES_V2 (RULES_V2_ID, RULE_NAME, RULE_DESCRIPTION) VALUES(1, 'test-1', 'business rule test-1');
INSERT INTO HR.RULES_V2 (RULES_V2_ID, RULE_NAME, RULE_DESCRIPTION) VALUES(2, 'test-2', 'business rule test-2');
INSERT INTO HR.RULES_V2 (RULES_V2_ID, RULE_NAME, RULE_DESCRIPTION) VALUES(3, 'test-3', 'business rule test-3');
-- rollback TRUNCATE TABLE HR.RULES_V2;