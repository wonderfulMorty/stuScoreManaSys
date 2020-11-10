# stuScoreManaSys
学生成绩管理系统（springboot+layui+thymeleaf）


一、	系统运行环境
1.	操作系统：windows7 64位
2.	代码编辑器：eclipse 
3.	Java版本：1.8 ，64位
4.	编译工具：maven
5.	Mysql:5.7.18

二、	系统使用说明
1.	数据导入：
新建数据库myscoremanage，设置数据库编码为utf-8。将项目文件下的myscoremanage.sql导入数据库。

2.	将项目导入到eclipse:
打开eclipse，选择file->import->existing maven project->选择项目所在的路径->finish，即可完成项目导入

3.	修改项目数据库:
修改项目下的：\src\main\resources\application.properties的数据库配置。主要是填写好用户名和密码。
 

4.	使用maven重新编译项目：
右键项目->run as ->maven install。
完成后，在更新项目：
右键项目->maven->update project……
以上编译过程无报错后，选择src/main/java/TestSpboot2Application.java，run as->java application,即可运行。
首先进入登陆主页：http://localhost:8080/Sys/loginView，进行登陆

5.	登陆系统的用户名和密码：
系统所有密码，均已经采用MD5加密。系统admin账号的用户名和密码都是admin。以管理员身份进入管理员界面后，可以更改学生和教师的密码。更改后的密码在后台的控制台内可以查看到。


三、登陆界面

1.登陆界面
![登陆界面](https://github.com/wonderfulMorty/stuScoreManaSys/blob/master/run_img/Snipaste_2019-05-27_13-50-27.png?raw=true)

2.管理员管理界面：
![1](https://github.com/wonderfulMorty/stuScoreManaSys/blob/master/run_img/Snipaste_2019-05-27_13-51-46.png?raw=true)

![2](https://github.com/wonderfulMorty/stuScoreManaSys/blob/master/run_img/Snipaste_2019-05-27_13-52-01.png?raw=true)

![3](https://github.com/wonderfulMorty/stuScoreManaSys/blob/master/run_img/Snipaste_2019-05-27_13-52-17.png?raw=true)

![4](https://github.com/wonderfulMorty/stuScoreManaSys/blob/master/run_img/Snipaste_2019-05-27_13-52-35.png?raw=true)

2.教师管理界面：
![5](https://github.com/wonderfulMorty/stuScoreManaSys/blob/master/run_img/Snipaste_2019-05-27_13-53-04.png?raw=true)

![6](https://github.com/wonderfulMorty/stuScoreManaSys/blob/master/run_img/Snipaste_2019-05-27_13-53-15.png?raw=true)


近期将使用shiro+redis+activiti+easypoi+mybatisplus等技术重构项目，敬请期待。

