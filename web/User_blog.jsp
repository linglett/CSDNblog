<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="pojo.Applicant" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link  href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">

    </script>
    <title>博客管理</title>
    <style>
        * {
            box-sizing: border-box;
        }
        body {
            font-family: Arial;
            padding: 10px;
            background: #f1f1f1;
        }
        /* 头部标题 */
        .header {
            padding: 30px;
            text-align: center;
            background: white;
        }

        .header h1 {
            font-size: 50px;
        }
        /* 导航条 */
        .topnav {
            overflow: hidden;
            background-color: #fff;
        }
        /* 导航条链接 */
        .topnav a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        /* 链接颜色修改 */
        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }
        /* 创建两列 */
        /* Left column */
        .leftcolumn {
            float: left;
            width: 75%;
        }

        /* 右侧栏 */
        .rightcolumn {
            float: left;
            width: 25%;
            background-color: #f1f1f1;
            padding-left: 20px;
        }
        /* 图像部分 */
        .fakeimg {
            background-color: #fff;
            width: 100%;
            padding: 20px;
        }
        .me_map{
            margin: 16px 143px 16px 143px;
        }
        /* 文章卡片效果 */
        .card {
            background-color: white;
            padding: 20px;
            margin-top: 20px;
        }
        /* 列后面清除浮动 */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        /* 底部 */
        .footer {
            padding: 20px;
            text-align: center;
            background: #ddd;
            margin-top: 20px;
        }
        /* 响应式布局 - 屏幕尺寸小于 800px 时，两列布局改为上下布局 */
        @media screen and (max-width: 800px) {
            .leftcolumn, .rightcolumn {
                width: 100%;
                padding: 0;
            }
        }

        /* 响应式布局 -屏幕尺寸小于 400px 时，导航等布局改为上下布局 */
        @media screen and (max-width: 400px) {
            .topnav a {
                float: none;
                width: 100%;
            }
        }
        .Id_box{
            float:right;
            margin-right: 450px;
            background-color: #fff;
            height: 104px;
            width: 300px;
        }
    </style>
</head>
<body>

<div class="shortcut">
    <a href="Head.jsp">
        <img src="image/logo.png" class="logo">
    </a>
    <div class="w">
        <ul class="fl">
            <li>欢迎进入本页面</li>
        </ul>
        <ul class="fr">
            <li>
                <%
                    Applicant sessionApplicant=(Applicant)session.getAttribute("SESSION_APPLICANT");
                    if(sessionApplicant==null)
                    {
                %>
                <a href="Login.html" target="_blank" >你好，请先登录</a>
                <a href="Register.html" class="f10" target="_blank">免费注册</a>
                <%
                } else{
                    System.out.println(sessionApplicant.getApplicantId()+"\n"+sessionApplicant.getapplicantemail()+"\n"
                            +sessionApplicant.getSex());
                %>
                <a href="PersonalHomepage.jsp" target="_blank" >
                    <%=sessionApplicant.getApplicantId() %>
                </a>
                <%
                    }
                %>

            </li>
            <li class="space"></li>
            <%
                if(sessionApplicant!=null)
                {
            %>
            <li>
                <a href="Writing_blog.jsp">写博客</a>
            </li>
            <li class="space"></li>·
            <li>
                <a href="article_extraction">我的博客</a>
            </li>
            <li class="space"></li>
            <li>
                <a href="PersonalHomepage.jsp">我的主页</a>
            </li>
            <%
                }
            %>
        </ul>
    </div>
</div>

<div class="me_map">
    <div class="row">
        <div class="leftcolumn">
            <div class="card">
                <img class="head" src="image/head.jpg">
                <div class="Id_box">
                    <%
                        Applicant sessionApplicant_personhomepage=(Applicant)session.getAttribute("SESSION_APPLICANT");
                        if(sessionApplicant_personhomepage!=null)
                        {
                    %>
                    <p><%=sessionApplicant_personhomepage.getApplicantId()%></p>
                    <%}%>
                </div>
            </div >
        <c:forEach var="article" items="${requestScope.article_Data}">
            <div class="card">
                <a href="ReturnArticleContent?article_id=${article["article_id"]}">${article["title"]}</a>
                <h5>xxxx 年 x 月 x日</h5>
                <h5>${article["article_id"]}</h5>
                <p>一些文本...</p>
            </div>
        </c:forEach>
        </div>
        <div class="rightcolumn">

            <div class="card">
                <h2>关于我</h2>
                <div class="fakeimg" style="height:100px;">图片</div>
                <p>关于我的一些信息..</p>
            </div>
            <div class="card">
                <h3>热门文章</h3>
                <div class="fakeimg"><p>图片</p></div>
                <div class="fakeimg"><p>图片</p></div>
                <div class="fakeimg"><p>图片</p></div>
            </div>
            <div class="card">
                <h3>关注我</h3>
                <p>一些文本...</p>
            </div>
        </div>
    </div>
</div>


<div class="footer">
    <div style="margin-top: 30px;border-bottom: 1px solid #e0e0e0;height: 174px;width: 100%">
        <iframe src="foot.html" width="100%" height="150" scrolling="no"
                frameborder="0"></iframe>
    </div>
</div>
</body>
</html>