-- liquibase formatted sql

-- changeset rnbv:001-create-tables
-- comment: JIRA-1234
CREATE TABLE HR.RULES_V2
    ( rules_v2_id    NUMBER(6) PRIMARY KEY
    , rule_name     VARCHAR2(20)
    , rule_description      VARCHAR2(255)
    );
CREATE TABLE HR.NODES
    ( node_id    NUMBER(6) PRIMARY KEY
    , node_name     VARCHAR2(20)
    , node_description      VARCHAR2(255)
    );
CREATE TABLE HR.RULES_NODES
    ( rules_nodes_id    NUMBER(6) PRIMARY KEY
    , rules_v2_id     NUMBER(6)  NOT NULL
    , node_id      NUMBER(6)  NOT NULL
    , CONSTRAINT rules_v2_id_fk
      FOREIGN KEY (rules_v2_id) REFERENCES HR.RULES_V2(rules_v2_id)
    , CONSTRAINT node_id_fk
      FOREIGN KEY (node_id) REFERENCES HR.NODES(node_id)
    );
CREATE TABLE HR.GLOBAL_VARS
    ( global_vars_id    NUMBER(6) PRIMARY KEY
    , global_vars_name     VARCHAR2(20)
    , global_vars_description      VARCHAR2(255)
    );
--rollback drop table HR.GLOBAL_VARS;
--rollback drop table HR.RULES_NODES;
--rollback drop table HR.RULES_V2;
--rollback drop table HR.NODES;
