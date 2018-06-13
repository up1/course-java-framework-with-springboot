DROP TABLE IF EXISTS account;
CREATE TABLE account(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  account_id VARCHAR(16) NOT NULL UNIQUE,
  mobile_no VARCHAR(10),
  name VARCHAR(50),
  account_type CHAR(2)
);