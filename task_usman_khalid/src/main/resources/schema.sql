DROP TABLE IF EXISTS payment_methods;
 
CREATE TABLE payment_methods (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL  ,
  dispaly_name VARCHAR(250) NOT NULL,
  payment_type VARCHAR(250) NOT NULL,
  net_ammount DOUBLE NOT NULL,
  tax_ammount DOUBLE NOT NULL,
  gross_ammount DOUBLE NOT NULL,
  currency VARCHAR(250) NOT NULL,
  duration VARCHAR(250) NOT NULL



);