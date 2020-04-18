#旅游管理系统
##将用到的技术
- spring boot
> 框架
- H2 database
> 数据库，小型轻便
- mybatis
> 插件用于实时更新数据库文件和查询条件
- thymeleaf
> 可以使用th:if 等直接从服务器上获得数据 
- flyway
> 管理数据库，可以直接生成数据库文件
##所要面对的方向
> 这个管理系统是单独对于某一个大的景区所创作的系统，可以有当地的酒店和景点，对于来的游客可以更好的居住和旅游，以及当地的一些信息数据的展示和浏览
>
>一个管理员可以针对一个区域做出发布新的旅游信息和接受到游客的评论。
>
>游客可以浏览信息和提出问题以及评论
>
>这是第一个版本，做一些基本的功能和使用基础的技术实现，后面会持续更新这个系统，利用自己已学到的技术和知识。
##技术文档和相关工具的下载
[spring学习区---文档](https://spring.io/guides)  
[BootStrap文档](https://v3.bootcss.com/getting-started/#download)
[spring MVC](https://docs.spring.io/spring/docs/5.0.3.RELEASE/spring-framework-reference/web.html#spring-web)

[maven](https://maven.apache.org)    
[github](https://github.com/liuhaili1997)     
[git](https://git-scm.com)
[flywaydb](https://flywaydb.org/getstarted/firststeps/maven)

##flyway的修改数据库可以保持不变
mvn flyway:migrate
##生成对应的文件
执行mybatis，使用maven方式执行：overwrite覆盖
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate