UPDATE cust c1 
SET 
    c1.cust_code = MID(c1.cust_code, 1, 6)