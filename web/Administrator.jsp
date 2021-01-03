<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pojo.Applicant" %>
<%@ page import="pojo.article" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>菜鸟教程(runoob.com)</title>
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
            background-color: #999999;
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
            background-color: #d92e2e;
            color: black;
        }

        /* 创建两列 */
        /* Left column */
        .leftcolumn {
            margin-left: 0px;
        }

        /* 右侧栏 */
        .rightcolumn {
            float: left;
            width: 25%;
            background-color: #f1f1f1;
            padding-left: 20px;
        }

        /* 图像部分 */z
        .fakeimg {
            background-color: #aaa;
            width: 100%;
            padding: 20px;
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
    </style>
</head>
<body>

<div class="header">
    <h1>管理员页面</h1>
    <p></p>
</div>

<div class="topnav">
    <a href="finduser">用户</a>
    <a href="findblogs">博客</a>
    <div>
        <form action="" style="margin-top: 9px; margin-left: 200px">
            <input style="width: 200px;height: 30px" type="text" name="search_administrator"/>
            <button type="submit" style="height: 30px;width: 60px" onclick="">查找</button>
        </form>
    </div>
</div>


<div class="row">
    <div class="leftcolumn">


        <c:forEach var="applicant" items="${requestScope.pojo}">
            <c:if test="${requestScope.now==1}">
                <div class="card">
                    <a href="">用户邮箱: ${applicant["applicantEmail"]}</a>
            <c:if test="${applicant['job']!=null}">
                <h5>用户电话: ${applicant["job"]}</h5>
            </c:if>
                    <c:if test="${applicant['job']==null}">
                        <h5>用户电话: 用户未填写</h5>
                    </c:if>

                    <a href="deleteUserOrBlog?user_email=${applicant["applicantEmail"]}">删除</a>
                </div>
            </c:if>
            <c:if test="${requestScope.now>1}">
                <div class="card">
                    <a href="ReturnArticleContent?article_id=${applicant["article_id"]}">博客标题: ${applicant["title"]}</a>
                    <h5>博客作者: ${applicant["author"]}</h5>
                    <a href="deleteUserOrBlog?blogs_id=${applicant["article_id"]}">删除</a>
                </div>
            </c:if>
        </c:forEach>
    </div>
    <div class="rightcolumn">

    </div>
</div>
<div class="footer">
    <h2>2019-11-24</h2>
</div>
</body>
</html>