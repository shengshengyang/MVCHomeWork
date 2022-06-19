# EEIT45 第一組 SpringMVC Project - 主題 : 素食網



# 組員名單 - 分工

- 組長 : 11楊竣盛 - 購物網
- 組員 : 02黃玉婷 - 食記
- 組員 : 07鄭翊苓 - 搜尋功能
- 組員 : 14徐英傑 - 登入登出會員
- 組員 : 20楊博宇 - 網誌
- 組員 : 11邱郁晏 - 訂單功能

### 說明

-  1.請先建立好 SQL 檔案 
-  2.請先建立好 Server content.xml

#### 目錄結構

## Server(Tomcat) Content.xml
```
 <Resource 
     name="connectSqlServerJdbc/SystemService"
	  type="javax.sql.DataSource" 
	  auth="Container" 
	  username="sa"
	  password="sa123456"
	  driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver"
	  url="jdbc:sqlserver://localhost:1433;databaseName=firstGroup" />
```


## T-SQL 
```
use firstGroup; 

create table reserve(
id int NOT NULL IDENTITY(1,1),  
reserveName nvarchar(50) not null,
reserveDate nvarchar(50) not null,
reserveRestuarant nvarchar(50) not null
);

```