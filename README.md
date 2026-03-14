# Tietokantaratkaisu projekti 26

+ GET localhost:8080/products/findbyid{id}
+ GET localhost:8080/products/all
+ GET localhost:8080/products/findbypricerange?minprice{}&maxprice{}
+ GET localhost:8080/productcategories/findbyid{id}
+ GET localhost:8080/productcategories/all
+ GET localhost:8080/customerorders/findbyid{id}
+ GET localhost:8080/customerorders/all

### Customer order view in the db
```sql
SELECT customers.id, customers.first_name, customers.last_name, SUM(orderitems.quantity) AS quantity_of_orders, SUM(orderitems.unit_price) AS price_of_orders

FROM customers
INNER JOIN
orders ON orders.customer_id = customers.id
INNER JOIN
orderitems ON orderitems.order_id = orders.id

GROUP BY customers.id
```
The database products has an added "available" column which is VARCHAR(1).
If the value is "Y", then it is converted to a boolean True.


Every API request is lowercase foe ease of use.