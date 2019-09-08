# Bubble Tea Shop
Bubble Tea Shop API written in Spring Boot with Hibernate

## Usage

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