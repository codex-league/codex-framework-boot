# codex-user-center


# codex-auth-center
## 模式类型




### 客户端模式

请求示例：

```shell
curl --location --request POST 'http://127.0.0.1:8000/oauth2/token?grant_type=client_credentials' \
--header 'Authorization: Basic Y29kZXg6Y29kZXg=' \
--header 'Cookie: JSESSIONID=6CD62AFD8914FB82D48D9534E17DA746' \
--data ''
```

### 密码模式

请求示例：
**虽然Oauth2.1中不推荐使用，且Spring authorization server中已经把密码模式排除了，但为了兼容项目，考虑又在本项目中加会来了，如不需要的话，可以自行删除**
```shell
curl --location --request POST 'http://127.0.0.1:8000/oauth2/token?grant_type=password&username=codex&password=123456' \
--header 'Authorization: Basic Y29kZXg6Y29kZXg=' \
--header 'Cookie: JSESSIONID=6CD62AFD8914FB82D48D9534E17DA746' \
--data ''
```





