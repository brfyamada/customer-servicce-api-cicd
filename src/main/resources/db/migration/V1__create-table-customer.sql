--[FLYWAY] [step 3] adicionar um arquivo do tipo sql para ser executado pelo flyway
CREATE TABLE customer (
    idt_customer_id BIGSERIAL NOT NULL,
    des_name varchar(255) NOT NULL,
    num_document varchar(14) NOT NULL,
    num_age INT NOT NULL,
    dat_creation TIMESTAMP DEFAULT NOW() NOT NULL,
    dat_update TIMESTAMP
)