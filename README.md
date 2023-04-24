# codex-framework-boot

Codex的基础脚手架

## 运行环境
| 模块                        | 说明     | 端口     |
|---------------------------|--------|--------|
| codex-server-gateway      | 基础网关服务 | 8000 |
| codex-server-oauth-center | 基础鉴权服务 | 8100 |
| codex-server-user-center  | 基础用户服务 | 8200 |

**以下内容是协作中的简单约定，不会花费太多时间。这不是一篇长篇大论的文章，建议在项目开始前浏览一遍**

## 运行环境
| 软件          | 版本要求   |
|-------------|--------|
| JDK         | 17+    |
| MySQL       | 8+     |
| Gradle      | 7.4+   |
| Spring boot | 3.0+   |
| Nacos       | 2.2.x+ |


## 表约定（重要）

1、数据库主键 `id` varchar(128)
4、必须拥有"逻辑删除"字段，请使用固定字段名称 `deleted` 字段类型 `datetime(-1)`  
5、必须拥有"创建时间"字段，请使用固定字段名称 `create_time` 字段类型 `datetime(-1)`  
6、必须拥有"修改时间"字段，请使用固定字段名称 `update_time` 字段类型 `datetime(-1)`  
7、必须拥有"创建人"字段，请使用固定字段名称 `create_by` 字段类型 `varchar(256)`  
8、必须拥有"修改人"字段，请使用固定字段名称 `update_by` 字段类型 `varchar(256)`

上述字段，除非业务真不需要，可以考虑不拥有

**数据库默认值
项目会自动检测是否包含上述字段，如果存在，会自动填充，研发人员不需要有刻意想法去改变或设定其值，可以专注定制化的业务开发**

## Controller约定
1、api的接口请使用codex文档工具暴露api文档，具体使用方式，类似swagger，项目中已经集成  
2、请使用validate验证注解维护入参内容的正确性  
3、Controller中的RequestParams和RequestBody，不建议使用`Map对象`接入参数，会造成入参内容不明确，除了开发人自己，谁也不明白约定了啥  
3、Controller中的ResponseBody，不建议使用`Map对象`、或者`非包装类`出参数，会造成出参内容不明确、或出参结构不统一引发与上游研发人员因为接口不统一的愿意打架


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





