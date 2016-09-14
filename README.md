# Foweb Framework

A multi-modules maven project base on Spring+SpringMVC+Mybatis.

一个基于 Spring+SpringMVC+Mybatis 的Maven多模块项目。

## 使用文档

### 将原型部署到本地Maven仓库

将项目目录下的`archetype.zip`下载下来，然后在本地解压；

进入到根目录下面，会看到`src`文件夹和`pom.xml`文件，然后在此处打开`cmd`，运行`mvn deploy`命令，然后`maven`会将其部署到本地仓库中。

注意，这里需要安装配置`nexus`（ Maven仓库管理器 ），如果已经有了`nexus`，则还需要在maven的配置文件（即`conf/settings.xml`）中配置访问nexus的权限。找到`settings.xml`中的`servers`元素，然后在元素中间添加以下代码：



	 <server>

	     <id>releases</id>

	     <username>admin</username>

	     <password>admin123</password>

	 </server>

	 <server>

	     <id>snapshots</id>

	     <username>admin</username>

	     <password>admin123</password>

	 </server>



`nexus`安装可以参考：
<a href="http://www.blogjava.net/fancydeepin/archive/2015/06/27/maven-nexus.html" target="_blank" title="Nexus安装">http://www.blogjava.net/fancydeepin/archive/2015/06/27/maven-nexus.html</a>

然后在重新使用`mvc deploy`命令执行就会提示`build success` 。

剩下的工作便是将这个`archetype`弄到你的`IDE`中，这里介绍`IDE`有两个`Eclipse`和`IDEA`，当然首先得肯定你的`IDE`需要把`maven`配置好。

### Eclipse配置Maven本地原型

对于`Eclipse`，打开配置界面，菜单栏`Windows`=&gt; `Preferences`=&gt; `Maven`=&gt; `Archetypes`=&gt; `Add Remote Catalog...`

在输入框中输入：

`Catalog File :  http://localhost:8081/nexus/content/groups/public/archetype-catalog.xml`

`Description :  Foweb Framework - a multi-modules maven project base on Spring+SpringMVC+Mybatis.`

注意：

`Catalog file`的地址和端口为你本地配置的`nexus`对应的地址和端口，根据具体情况修改，在添加之前可以去浏览器中输入此地址查看到的xml，看是否有 `groupId`为`studio.baxia`， `artifactId`为`foweb-archetype` 。不存在则可能是你`mvn deploy`失败了，重试一下。

`Description`则是你对该原型在本地仓库中的描述，可自定义。

操作演示如下：
(为防止图片在此加载不出来，附上图片地址：<a href="http://odhtjea8i.bkt.clouddn.com/foweb/Eclipse%E9%85%8D%E7%BD%AEmaven%E6%9C%AC%E5%9C%B0%E5%8E%9F%E5%9E%8B1.gif" target="_blank" >Eclipse配置maven本地原型1.gif</a>）

![](http://odhtjea8i.bkt.clouddn.com/foweb/Eclipse%E9%85%8D%E7%BD%AEmaven%E6%9C%AC%E5%9C%B0%E5%8E%9F%E5%9E%8B1.gif)

(为防止图片在此加载不出来，附上图片地址：<a href="http://odhtjea8i.bkt.clouddn.com/foweb/Eclipse%E9%85%8D%E7%BD%AEmaven%E6%9C%AC%E5%9C%B0%E5%8E%9F%E5%9E%8B2.gif" target="_blank" >Eclipse配置maven本地原型2.gif</a>）

![](http://odhtjea8i.bkt.clouddn.com/foweb/Eclipse%E9%85%8D%E7%BD%AEmaven%E6%9C%AC%E5%9C%B0%E5%8E%9F%E5%9E%8B2.gif)

新建原型项目测试演示如图：

注意：该框架是前后端分离的，这里的演示没有结合前端页面进行，只能通过api访问查看返回的数据。关于前端的演示则需要用到foweb.client进行。请查看：<a href="https://github.com/panhainan/foweb.client" target="_blank" title="foweb前端项目">https://github.com/panhainan/foweb.client</a>

(为防止图片在此加载不出来，附上图片地址：<a href="http://odhtjea8i.bkt.clouddn.com/foweb/Eclipse%E6%96%B0%E5%BB%BAmaven%E6%9C%AC%E5%9C%B0%E5%8E%9F%E5%9E%8B%E9%A1%B9%E7%9B%AE%E6%B5%8B%E8%AF%95.gif" target="_blank" >Eclipse新建maven本地原型项目测试.gif</a>）  

![](http://odhtjea8i.bkt.clouddn.com/foweb/Eclipse%E6%96%B0%E5%BB%BAmaven%E6%9C%AC%E5%9C%B0%E5%8E%9F%E5%9E%8B%E9%A1%B9%E7%9B%AE%E6%B5%8B%E8%AF%95.gif)


### IDEA配置Maven本地原型

对于`IDEA`，从启动选择项目界面（或者已经进入了项目的界面）进入：`Configure(or File)` =&gt;`Settings` =&gt; `Plugins`搜索`Maven Archetype Catalogs` 插件，安装该插件，然后重启，然后 `File`=&gt; `Settings`=&gt; `Build,Execution,Deployment` =&gt; `Build Tools` =&gt; `Maven  Archetype Catalogs` ，然后点击`+`进行添加`catalog`，即  `http://localhost:8081/nexus/content/groups/public/archetype-catalog.xml` 到输入框即可。

操作演示如图：

(为防止图片在此加载不出来，附上图片地址：<a href="http://odhtjea8i.bkt.clouddn.com/foweb/IDEA%E9%85%8D%E7%BD%AEmaven%E6%9C%AC%E5%9C%B0%E5%8E%9F%E5%9E%8B.gif" target="_blank" >IDEA配置maven本地原型.gif</a>） 
 
![](http://odhtjea8i.bkt.clouddn.com/foweb/IDEA%E9%85%8D%E7%BD%AEmaven%E6%9C%AC%E5%9C%B0%E5%8E%9F%E5%9E%8B.gif)

新建原型项目测试演示如图：

(为防止图片在此加载不出来，附上图片地址：<a href="http://odhtjea8i.bkt.clouddn.com/foweb/IDEA%E6%96%B0%E5%BB%BAmaven%E6%9C%AC%E5%9C%B0%E5%8E%9F%E5%9E%8B%E9%A1%B9%E7%9B%AE%E6%B5%8B%E8%AF%95.gif" target="_blank" >IDEA新建maven本地原型项目测试.gif</a>） 
 
![](http://odhtjea8i.bkt.clouddn.com/foweb/IDEA%E6%96%B0%E5%BB%BAmaven%E6%9C%AC%E5%9C%B0%E5%8E%9F%E5%9E%8B%E9%A1%B9%E7%9B%AE%E6%B5%8B%E8%AF%95.gif)


## 源码解释

正在制作中。。。敬请等待！


## 感谢

觉得好的希望能够star一下，给颗星星，谢谢！