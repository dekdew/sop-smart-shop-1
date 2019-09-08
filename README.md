# Bubble Tea Shop

## Usage

### List all bubble tea menus
**URL** : `/menu/`

**Method** : `GET`

**Success Response**

**Code** : `200 OK`

**Content examples**

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