# ๐ชง Project Board


##  ํ๋ก์ ํธ ๋ชฉ์  
* Spring Data Jpa ํ์ฉ
* MockMvc๋ฅผ ์ด์ฉํ API ํ์คํธ
* Rest-Docs๋ฅผ ์ด์ฉํ API ๋ฌธ์ํ 


## โ๏ธ ๊ธฐ์  ์คํ
* Spring Data Jpa
* H2 database
* RestDocs

<br>

### โ๏ธ ํจํค์ง ๊ตฌ์ฑ
* common
* controller
* converter
* domain
  * post
    * vo
  * user
    * vo
* dto
  * post
  * user
* exception - (๋ฏธ์์ฑ)
* repository
* service

<br>

### โ๏ธ API ๊ตฌํ

- ๊ฒ์๊ธ ์กฐํ
    - ํ์ด์ง ์กฐํ (GET "/api/v1/posts")
    - ๋จ๊ฑด ์กฐํ (GET "/api/v1/posts/{id}")
    - ์ ์  ๊ฒ์๊ธ ์กฐํ(GET "/api/v1/posts/user/{id}")
- ๊ฒ์๊ธ ์์ฑ (POST "/api/v1/posts")
- ๊ฒ์๊ธ ์์  (PUT "/api/v1/posts")
- ๊ฒ์๊ธ ์ญ์  (DELETE "/api/v1/posts/{id}")


- ์ ์  ์กฐํ
  - ํ์ด์ง ์กฐํ (GET "/api/v1/users")
  - ๋จ๊ฑด ์กฐํ (GET "/api/v1/users/{id}")
- ์ ์  ๋ฑ๋ก (POST "/api/v1/users")
- ์ ์  ์์  (PUT "/api/v1/users)
- ์ ์  ์ญ์  (DELETE "/api/v1/users/{id})

<br>

### โ๏ธ REST-DOCS๋ฅผ ์ด์ฉํ API ๋ฌธ์ํ
* ์์น : /src/main/resources/documentation/index.html
