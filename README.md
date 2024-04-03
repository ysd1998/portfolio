# 書店商品管理システム
## 使用した環境
<a href="https://www.w3schools.com/css/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original-wordmark.svg" alt="css3" width="40" height="40"/> </a>  <a href="https://www.w3.org/html/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original-wordmark.svg" alt="html5" width="40" height="40"/> </a> <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> <a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a>

## 概要
　○○書店では更なる事業拡大のために、Web上で本を検索するシステムを作成しようと構想している。  
　システムの開発に伴い、Web販売担当という新しい部署を作る予定している。  
　Webサイトにてログインしたユーザーが本を検索し、○○書店が販売している商品の情報を見れるシステムを作成する。  
　尚、商品を検索する際の情報はタイトル、著者、種類、出版社で該当するデータ(タイトル、著者、価格)を画面に表示する。  
　そして一つの商品情報に対して詳細な情報(商品番号(自動割り当て)、タイトル、著者、価格、種類、出版社、発行日、説明)が他のページで表示されるようにする。  
　管理者とWeb販売担当の一般社員が商品情報(タイトル、著者、価格、種類、出版社、発行日、説明)を追加、更新、削除できるように商品管理画面も実装する。  
　管理者にはWeb販売担当の一般社員が所属・異動した場合、商品データを管理する権限を登録・削除できるようにする。  

### ・社員管理データベース
　社員情報(外部から複製されているもの)を登録するデータベース。

### ・ユーザー管理データベース
　ユーザー情報を管理するデータベース。

### ・商品管理データベース
　商品情報を管理するデータベース。

### ・ユーザー側検索システム
　ユーザー側で商品を検索するシステム。
　ユーザーが商品情報を見ることができる。

### ・社員側商品管理システム
　社員側で商品を設定するシステム。
　社員が商品情報を検索・追加・更新・削除することができる。  
　尚、管理者側でWeb担当社員を設定することができる。  
　管理者が担当権限を付与・削除することができる。  

## 環境バージョン説明
　言語:java SE17  
　フレームワーク:SpringBoot 3.2.1  
　DB:MySQL 8.0.35  
　サーバー：Tomcat 11  
　OS:Windows11  
