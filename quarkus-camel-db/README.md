# quarkus-camel-with-db


GET: http://localhost:8080/api/v1/getAllData


POST: http://localhost:8080/create
{
    "name": "Mike Brown 4",
    "position": "Product Manager 43",
    "salary": 233223
}


GET: http://localhost:8080/getDataById/9


PUT: http://localhost:8080/updateDataById/4
{
    "name": "Mike Brown 4"
}

DELETE: http://localhost:8080/deleteDataById/3