# Bubble Tea Shop
Bubble Tea Shop API written in Spring Boot with Hibernate

## System Requirements
- JDK 11 or higher
- PostgreSQL

## Quick Start
1. Clone the repository
2. Create database in PostgreSQL
3. Config Spring Data Source in `application.properties`
default configuration
```
## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url=jdbc:postgresql://localhost:5432/{Database name}
spring.datasource.username=postgres
spring.datasource.password=

# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults = false
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update
```

## Usage

### List all bubble teas
URL : `/bubbletea`

Method : `GET`

**Success Response**

Code : `200 OK`

Response example

```json
[
     {
        "id": 1,
        "sugarLevel": 0.75,
        "toppings": [
            "Bubble",
            "Coffee"
        ]
    },
    {
        "id": 2,
        "sugarLevel": 0.75,
        "toppings": [
            "Bubble",
            "Coffee"
        ]
    }
]
```

### Create new bubble tea menu
URL : `/bubbletea`

Method : `POST`

**Success Response**

Code : `200 OK`

Body example

```json
{
    "sugarLevel": 0.80,
    "toppings": ["Bubble", "Coffee"]
}
```

Response example

```json
{
    "id": 1,
    "sugarLevel": 0.8,
    "toppings": [
        "Bubble",
        "Coffee"
    ]
}
```

### Get bubble tea detail by id
URL : `/bubbletea/{id}`

Method : `GET`

**Success Response**

Code : `200 OK`

Body example

```
No body required
```

Response example

```json
{
    "id": 1,
    "sugarLevel": 0.75,
    "toppings": [
        "Bubble",
        "Coffee"
    ]
}
```

### Update bubble tea
URL : `/bubbletea/{id}`

Method : `PUT`

**Success Response**

Code : `200 OK`

Body example

```json
{
    "sugarLevel": 0.8,
    "toppings": ["Bubble", "Green Tea"]
}
```

Response example

```json
{
    "id": 1,
    "sugarLevel": 0.8,
    "toppings": [
        "Bubble",
        "Green Tea"
    ]
}
```

### Delete bubble tea
URL : `/bubbletea/{id}`

Method : `DELETE`

**Success Response**

Code : `202 ACCEPTED`

Body example

```
No body required
```

Response example

```
No Response body
```

### List all bubble tea menus
URL : `/menu`

Method : `GET`

**Success Response**

Code : `200 OK`

Response example

```json
[
    {
        "id": 1,
        "isLarge": false,
        "price": 60,
        "name": "Classic Bubble Tea",
        "bubbleTea": {
            "id": 6,
            "sugarLevel": 0.75,
            "toppings": [
                "Bubble"
            ]
        }
    },
    {
        "id": 2,
        "isLarge": true,
        "price": 80,
        "name": "Classic Bubble Tea (Large)",
        "bubbleTea": {
            "id": 6,
            "sugarLevel": 0.75,
            "toppings": [
                "Bubble"
            ]
        }
    }
]
```

### Create new bubble tea menu
URL : `/menu`

Method : `POST`

**Success Response**

Code : `200 OK`

Body example

```json
{
    "isLarge": true,
    "price": 80,
    "name": "Classic Bubble Tea (Large)",
    "bubbleTeaId": 6
}
```

Response example

```json
{
    "id": 2,
    "isLarge": true,
    "price": 80,
    "name": "Classic Bubble Tea (Large)",
    "bubbleTea": {
        "id": 6,
        "sugarLevel": 0.75,
        "toppings": [
            "Bubble"
        ]
    }
}
```

### Get bubble tea menu detail by id
URL : `/menu/{id}`

Method : `GET`

**Success Response**

Code : `200 OK`

Body example

```
No body required
```

Response example

```json
{
    "id": 2,
    "isLarge": false,
    "price": 80,
    "name": "Classic Bubble Tea",
    "bubbleTea": {
        "id": 6,
        "sugarLevel": 0.75,
        "toppings": [
            "Bubble"
        ]
    }
}
```

### Update bubble tea menu
URL : `/menu/{id}`

Method : `PUT`

**Success Response**

Code : `200 OK`

Body example

```json
{
    "isLarge": false,
    "price": 80,
    "name": "Classic Bubble Tea",
    "bubbleTeaId": 6
}
```

Response example

```json
{
    "id": 2,
    "isLarge": false,
    "price": 80,
    "name": "Classic Bubble Tea",
    "bubbleTea": {
        "id": 6,
        "sugarLevel": 0.75,
        "toppings": [
            "Bubble"
        ]
    }
}
```

### Delete bubble tea menu
URL : `/menu/{id}`

Method : `DELETE`

**Success Response**

Code : `202 ACCEPTED`

Body example

```
No body required
```

Response example

```
No Response body
```