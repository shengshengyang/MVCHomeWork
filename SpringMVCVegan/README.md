# EEIT45 第一組 SpringMVC Project - 主題 : 素食網



# 組員名單 - 分工

- 組長 : 11楊竣盛 - 購物網
- 組員 : 02黃郁婷 - 食記
- 組員 : 07鄭翊苓 - 搜尋功能
- 組員 : 14徐英傑 - 登入登出會員
- 組員 : 20楊博宇 - 網誌
- 組員 : 11邱郁晏 - 訂單功能

### 說明

-  1.請先建立好 SQL 檔案 
-  2.請先建立好 Server content.xml
-  3.食記 預設兩筆食記文章，可以直接進行新增、刪除、修改
-  4.會員CRUD頁面有引入CDN,請在有網路連線的環境下執行

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

drop table if exists reserve;

create table reserve(
id int NOT NULL IDENTITY(1,1),  
reserveName nvarchar(50) not null,
reserveDate nvarchar(50) not null,
reserveRestuarant nvarchar(50) not null
);

```

```
use firstGroup; 

create table product(
id int NOT NULL IDENTITY(1,1),  
name nvarchar(50) not null,
price float not null,
image nvarchar(50)  null
);
```

```
use firstGroup;
DROP TABLE IF EXISTS post;

CREATE TABLE post(
    postId INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    title NVARCHAR(255) NOT NULL,
    postedDate DATETIME NOT NULL,
    postedText NVARCHAR(MAX) NOT NULL,
    imgurl NVARCHAR(255)
   
);
INSERT INTO post (title, postedDate, postedText, imgurl) VALUES ('【新莊聚餐推薦】廣泰樓小館，港式小點、香酥芋頭鴨、蒜香脆皮雞必點','2022-05-13 09:14:36','【廣泰樓小館】是提供粵式+港式小點的中餐廳，位在新莊區幸福路

特色餐點有 香酥芋頭鴨、蒜香脆皮雞、港式小點等人氣美食

開業大約一年多，裝潢很有質感，打破印象中傳統中餐廳的油膩、老舊感

有方桌和圓桌，適合2-14人的座位區，相當適合家庭、朋友聚餐

不想在店內用餐、也能外帶餐點回家喔~','images\PostsPhoto\1655871971307.jpg');

INSERT INTO post (title, postedDate, postedText, imgurl) VALUES ('【台北東區美食】熟菜豚屋 復興本店 超好吃韓式烤肉餐廳推薦！生菜免費續加吃到飽','2022-05-18 09:14:36', '   台北東區、捷運忠孝復興站這家《熟・菜豚屋》，絕對是我目前在台北吃過，最喜歡的高級韓式燒肉餐廳

將韓國烤肉結合創意料理，從前菜到溫菜、冷菜、海鮮、燒肉，甚至是甜點都非常夠水準，還有專人座上烤肉服務，不用自己動手烤

我們吃完《熟・菜豚屋》後，已經是逢人就推薦的喜歡，完全顛覆對韓式燒肉的想像，《熟・菜豚屋》怎麼可以這麼好吃啊！

熟・菜豚屋 復興本店

推薦指數：★★★★★　5顆星

一句短評：台北好吃高級韓式燒肉推薦！生菜可以無限續點吃到飽

 

《熟・菜豚屋》地址位在台北東區、復興南路巷弄內，較靠近市民大道那側

從捷運忠孝復興站出口出來，約步行400公尺，約5分鐘左右即可抵達；若是開車騎車前往的人，可以先在附近找找路邊停車位，亦有幾家收費停車場可停車

《熟・菜豚屋》是《菜豚屋》的新品牌，我以前吃過《菜豚屋》後就很喜歡

而《熟・菜豚屋》是主打個人套餐的高級韓式燒肉，從食材到服務、用餐環境全部大升級

裝潢空間非常有私人招待所的感覺，低調奢華氣氛營造相當好，無論情侶約會、節日慶生、商務聚餐都很適合

我們毫無疑問地一致給予《熟・菜豚屋》五星推薦，真的是讓人驚艷的好吃

沒有一道菜是不喜歡的，搭配專業又親切的服務、低調奢華的用餐空間，都加深了《熟・菜豚屋》的推薦指數

喜歡吃韓式燒肉、日本料理的人，拜託你一定要收藏《熟・菜豚屋》，找一天犒賞自己一下來吃吧！','images\PostsPhoto\1655871979555.jpg');
```
```
DROP TABLE IF EXISTS forum
use veganDB
create table forum(
   id int not null primary key identity(1,1),
   forumTitle nvarchar(50) not null,
   forumContent nvarchar(50) not null,
   forumDate  datetime NOT NULL
);

insert into forum(forumTitle,forumContent,forumDate) values('我是標題','嗨,您好','2022-06-10 07:02')
insert into forum(forumTitle,forumContent,forumDate) values('我是標題1','嗨,您好1','2022-06-11 07:02')
```
```
use firstGroup;

drop table if exists users;
create table users(
   uid int not null primary key identity(1,1),
   email nvarchar(60) not null,
   password nvarchar(30) not null,
   username nvarchar(50) not null
);

insert into users(email, password, username) values('jason123@mail.com','Test1234', '一二三');
insert into users(email, password, username) values('jason456@mail.com','1234tesT', 'ONE2three');

select * from users;

```

```
use firstGroup; 

create table restaurant(
	restaurantNumber int IDENTITY(1,1) PRIMARY KEY,
	restaurantName nvarchar(20) NOT NULL,
	restaurantTel nvarchar(15),
	restaurantAddress nvarchar(50) NOT NULL,
	restaurantCategory nvarchar(20),
	restaurantType nvarchar(20),
	restaurantBusinessHours nvarchar(200),
	restaurantScore nvarchar(10),
	restaurantMap nvarchar(MAX)
);
```