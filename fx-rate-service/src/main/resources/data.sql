DROP TABLE IF EXISTS fx_rate; 
 
CREATE TABLE fx_rate (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
currency VARCHAR(50) NOT NULL,  
rate FLOAT NOT NULL,  
as_of_date DATE NOT NULL
);  