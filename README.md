# restAssignment

# Request URL( GET,POST,PUT,DELETE)

# To Fetch All the Record

Mothod Name : GET URL :
http://localhost:8080/api/allCustomers

Response: 
[ {
  "customerId": 1,
  "customerFirstName": "Kumar",
  "customerLastName": "Mukash"
} ]

*******************************************************
# To Fetch Single Record based On Id

Mothod Name : GET 
URL :http://localhost:8080/api/customers/{id}

Response: 
{
  "customerId": 1,
  "customerFirstName": "Kumar",
  "customerLastName": "Mukash"
}

********************************************************

# To Insert Record

Mothod Name : POST 
URL :http://localhost:8080/api/customers

Request Body:

{ "customerFirstName": "Rahul", "customerLastName": "Kumar" }

**********************************************************

# To Update the record based on id

Mothod Name : PUT 
URL : http://localhost:8080/api/customer/{id}

{
  "customerFirstName": "Vikash",
  "customerId": 1,
  "customerLastName": "Kumar"
}


*************************************************************

# To delete The record based on id

Mothod Name : DELETE 
URL : http://localhost:8080/api/{id}


# To count the record

Mothod Name : GET
URL:http://localhost:8080/api/customerCount



# Swagger URL

http://localhost:8080/swagger-ui.html


# Databas H2 no need to install any external databas





