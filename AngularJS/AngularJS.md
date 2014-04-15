# 学习AngularJS #
----------
## AngularJS快速开始  ##
开始学习AngularJS的一个好方法是创建经典应用程序“Hello World!”：

1. 使用您喜爱的文本编辑器，创建一个HTML文件，例如：helloworld.html。

1. 将下面的源代码复制到您的HTML文件。

1. 在web浏览器中打开这个HTML文件。

源代码：

	<!doctype html>
	<html ng-app>
	    <head>
	        <script src="http://code.angularjs.org/angular-1.0.1.min.js"></script>
	    </head>
	    <body>
	        Hello {{'World'}}!
	    </body>
	</html>

请在您的浏览器中运行以上代码查看效果。

现在让我们仔细看看代码，看看到底怎么回事。 当加载该页时，标记ng-app告诉AngularJS处理整个HTML页并引导应用：

	<html ng-app>

这行载入AngularJS脚本：

	<script src="http://code.angularjs.org/angular-1.0.1.min.js"><script>

最后，标签中的正文是应用的模板，在UI中显示我们的问候语：

	Hello {{'World'}}!

注意，使用双大括号标记{{}}的内容是问候语中绑定的表达式，这个表达式是一个简单的字符串‘World’。

下面，让我们看一个更有趣的例子：使用AngularJS对我们的问候语文本绑定一个动态表达式。

### Hello AngularJS World! ###

本示例演示AngularJS的双向数据绑定（bi-directional data binding）：
 1.编辑前面创建的helloworld.html文档。
 2.将下面的源代码复制到您的HTML文件。
 3.刷新浏览器窗口。

源代码:

	<!doctype html>
	<html ng-app>
	    <head>
	        <script src="http://code.angularjs.org/angular-1.0.1.min.js"></script>
	    </head>
	    <body>
	        Your name: <input type="text" ng-model="yourname" placeholder="World">
	        <hr>
	        Hello {{yourname || 'World'}}!
	    </body>
	</html>


请在您的浏览器中运行以上代码查看效果。

该示例有一下几点重要的注意事项：


- 文本输入指令
`<input ng-model="yourname" />`绑定到一个叫`yourname`的模型变量。


- 双大括号标记将`yourname`模型变量添加到问候语文本。


- 你不需要为该应用另外注册一个事件侦听器或添加事件处理程序！
 
现在试着在输入框中键入您的名称，您键入的名称将立即更新显示在问候语中。 这就是AngularJS双向数据绑定的概念。 输入框的任何更改会立即反映到模型变量（一个方向），模型变量的任何更改都会立即反映到问候语文本中（另一方向）。


###AngularJS应用的解析###

本节描述AngularJS应用程序的三个组成部分，并解释它们如何映射到模型-视图-控制器设计模式：

####模板（Templates）####

模板是您用HTML和CSS编写的文件，展现应用的视图。 您可给HTML添加新的元素、属性标记，作为AngularJS编译器的指令。 AngularJS编译器是完全可扩展的，这意味着通过AngularJS您可以在HTML中构建您自己的HTML标记！

####应用程序逻辑（Logic）和行为（Behavior）####

应用程序逻辑和行为是您用JavaScript定义的控制器。AngularJS与标准AJAX应用程序不同，您不需要另外编写侦听器或DOM控制器，因为它们已经内置到AngularJS中了。这些功能使您的应用程序逻辑很容易编写、测试、维护和理解。

####模型数据（Data）####

模型是从AngularJS作用域对象的属性引申的。模型中的数据可能是Javascript对象、数组或基本类型，这都不重要，重要的是，他们都属于AngularJS作用域对象。

AngularJS通过作用域来保持数据模型与视图界面UI的双向同步。一旦模型状态发生改变，AngularJS会立即刷新反映在视图界面中，反之亦然。

**此外，AngularJS还提供了一些非常有用的服务特性：**

1. 底层服务包括依赖注入，XHR、缓存、URL路由和浏览器抽象服务。

1. 您还可以扩展和添加自己特定的应用服务。

1. 这些服务可以让您非常方便的编写WEB应用。



## 1.搭建学习环境 ##
1.您需要安装Node.js和Testacular来运行本项目，请到Node.js官方网站下载并安装最新版，然后把node可执行程序路径添加到系统环境变量PATH中，完成后在命令行中运行一下命令可以查看是否安装成功：

	node -version

然后安装karma单元测试程序，请运行如下命令：

	npm install -g karma

2.安装Git工具，然后用以下命令从Github复制本教程项目的源代码文件:

	git clone git://github.com/angular/angular-phonecat.git

您也可以直接从网上下载本教程项目源代码的镜像归档压缩包。这个命令会在您当前文件夹中建立新文件夹angular-phonecat。

3.最后一件事要做的就是确保您的计算机安装了web浏览器和文本编辑器。

4.进入教程源代码文件包angular-phonecat，运行服务器后台程序，开始学习AngularJS！

	cd angular-phonecat
	node scripts/web-server.js

