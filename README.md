# Tietokantaratkaisu projekti 26

## 1. https request

### List of all https requests
Every API request is lowercase for ease of use.

-GET localhost:8080/products/search[id][q][minrange][maxrange][available]

-GET localhost:8080/productcategories/findbyid{id}

-GET localhost:8080/productcategories/all

-GET localhost:8080/customerorders/findbyid{id}

-GET localhost:8080/customerorders/all

---

### GET /products/search

Search products with optional filters.

**Query Parameters (all optional):**

- `[id]` — integer — filter by product ID
- `[q]` — string — filter by product name and description. Can take multiple values.
- `[minprice]` — decimal — minimum price filter
- `[maxprice]` — decimal — maximum price filter
- `[available]` — string — filter by availability; values:
    - `true`, `yes`, `y`, `1` → available products
    - `false`, `no`, `n`, `0` → unavailable products
    - `null` → availability is null
    - omitted → no filtering

**Example Request:**
>localhost:8080/products/search?q=quantum%20key&minprice=4&maxprice=800&available=null

Searches for products that have the words "quantum" and "key". Minimum price is 4 and maximum is 800. Availability is set as null.

---

### GET /productcategory/findbyid

Search product categories with a given id.

**Query Parameter:**

- `[id]` — integer — filter by product category ID

**Example Request:**
>localhost:8080/productcategories/findbyid/3
> 
Searches for a product category with an id of 3.

---

### GET /productcategory/all

Search all product categories.

**Query Parameter:**

- none

**Example Request:**
>localhost:8080/productcategories/all
>
Searches for all product categories.

---

### GET /customerorders/findbyid

Search customer orders with a customers id.

**Query Parameter:**

- `[id]` — integer — filter by customer order ID

**Example Request:**
>localhost:8080/customerorders/findbyid/3
>
Searches for all the orders of a customer with an id of 3.

---

### GET /customerorders/all

Search all customer orders.

**Query Parameter:**

- none

**Example Request:**
>localhost:8080/customerorders/all
>
Searches for all customer orders (it is a long list).

---

## 2. Database changes

The database products has an added "available" column which is VARCHAR(1).
If the value is "Y", then it is converted to a boolean True.

In the database, there are indexes made for (price), (price, available), (name, description).
These are the most common searches for a user.

### Indexes
```sql
CREATE INDEX idx_products_price ON products(price);

CREATE INDEX idx_products_price_available ON products(price, available);

ALTER TABLE products
ADD FULLTEXT INDEX idx_products_name_description (name, description);
```

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


## 3. Other

The product entity has a many-to-one connection to product category for product searches also to show the product category.
