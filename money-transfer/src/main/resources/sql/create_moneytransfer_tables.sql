CREATE TABLE IF NOT EXISTS user (
  userId INT PRIMARY KEY,
  name VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS account (
  accountId IDENTITY,
  userId VARCHAR(256) NOT NULL,
  balance DECIMAL(19,4) NOT NULL,
  blocked_amount DECIMAL(19,4) NOT NULL,
  FOREIGN KEY(userId) REFERENCES user(userId)
);

CREATE TABLE IF NOT EXISTS transfer_details (
  transferId IDENTITY,
  from_account_id BIGINT NOT NULL,
  to_account_id BIGINT NOT NULL,
  amount DECIMAL(19,4) NOT NULL,
  userId VARCHAR(256) NOT NULL,
  status INT NOT NULL
  FOREIGN KEY(from_account_id) REFERENCES account(accountId),
  FOREIGN KEY(to_account_id) REFERENCES account(accountId),
)