CREATE TABLE asset_detail (
  ticker varchar(20) NOT NULL,
  sec_type varchar(10) NOT NULL,
  stock_price numeric(15) NULL,
  strike numeric (15) NULL,
  volatility decimal(5,2) NULL,
  interest decimal(5,2) NULL,
  time_horizon decimal(5,2) NULL
);