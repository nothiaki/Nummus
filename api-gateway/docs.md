## ACCOUNTS

##### create user POST /users
```JSON
{
  "fullName": String,
  "email": String,
  "password": String,
  "birth": Long
}
```

## USERS

##### create account POST /accounts/{userID}

##### list an account POST /accounts/{accountID}


## TRANSACTIONS

##### create a transaction POST /transactions/
```JSON
{
  "payerID": String,
  "payeeID": String,
  "amount": Long
  "type": TransactionType
}
```
TransactionType = DEBIT, CREDIT, PIX


## SAGA HISTORY

##### find one saga history GET /saga-history/{ID}
