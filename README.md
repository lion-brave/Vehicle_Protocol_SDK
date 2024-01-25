# Vehicle host M20 communication protocol

## 1. Brief description of the protocol

- The vehicle host uses HTTP POST to upload

## 2. Detailed explanation of the protocol

### 2.1 Signature

- File name + random number form a string to be signed
- Sign the string to be signed with HmacSHA1 to obtain the base64 signature string sign

example:

- The signing key is: rtqewrqer65erqewrq134

- Upload file file name: 20230211111111.txt
- Random number: 6985742

​ File name + random number form the string to be signed: 20230211111111.txt6985742

​ base64 sign string: 6QV/SFXBWXE5Zzvai1Hy+BQoQ6k=

### 2.2 Request parameters

- #### Header request parameters

| Parameter name | Parameter value (example) | Required or not | Parameter type | Description |
| :----: | :-------------------: | :------: | :------: | :------: |
| secret | rtqewrqer65erqewrq134 | Yes | Text | Signing Key |

- #### Body request parameters

| Parameter name | Parameter value (example) | Required or not | Parameter type | Description |
| :----: | :--------------------------: | :------: | :--------: | :------: |
|  file | [file path] | yes | [file type] | file   |
|  sign | 6QV/SFXBWXE5Zzvai1Hy+BQoQ6k= | Yes | Text | Signature   |
| nonce  |           6985742            |    Yes | Text | Random number  |

- #### Response example

 Success (200)

  ```json
  {
  	"retCode": 0,
  	"message": "success"
  }
  ```

  | Parameter name | Parameter value (example) | Required or not | Parameter type | Description       |
  | :-----: | :------------: | :------: | :------: | :-----------------: |
  | retCode |       0        |    Yes | Number | 0, success, others: failure |
  | message |    success     |    Yes    |  String  |                     |

  Fail (201)

  ```json
  {
  	"retCode": 101
  	"message": "Signature failure"
  }
  ```

  | Parameter name | Parameter value (example) | Required or not | Parameter type | Description      |
  | :-----: | :------------: | :------: | :------: | :-----------------: |
  | retCode |      101       |    Yes | Number | 0, success, others: failure |
  | message |    success     |    Yes    |  String  |                     |

### 2.3 Path

Depending on the platform, the device itself supports setting the path by itself.





