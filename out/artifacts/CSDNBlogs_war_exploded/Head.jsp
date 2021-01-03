<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pojo.Applicant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <title>CSDN博客</title>
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link  href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script src="js/jquery-3.4.1.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
    <style>
        .img1{
            display: block;
            width: 508px;
            height: 206px;
        }

        .img2{
            display: none;
            width: 508px;
            height: 206px;
        }

        .img3{
            display: none;
            width: 508px;
            height: 206px;
        }
        .img4{
            width: 230px;
            height: 103px;
        }
        .ulleft{
            padding: 0px;
            width: 96px;
        }
        .card {
            background-color: white;
            padding: 20px;
            margin-top: 20px;
        }
        .rightcard{
            background-color: white;
            padding: 20px;
        }
        .foot{
            height: 174px;
            width: 1360px;
            box-shadow: 0 2px 4px 0 rgba(0,0,0,.05);
            margin-top: 10px;
        }
        .foot-1{
            text-align: center;
            font-size: 12px;
            color: #999999;
        }
        a{
            text-decoration: none;
            font-size: 16px;
            color: #999;

        }
        .navli{
            margin-bottom: 25px;
        }
        a:hover{
            color: #c81623;
            text-decoration: none;
        }
    </style>
    <script type="text/javascript">
        function judge() {
            var contend=document.getElementsByName("search_content");
            if(account.value==""){
                alert("搜索内容不能为空");
                account.focus();
                return false;
            }
        }
    </script>
</head>
<body style="background-color: #f5f6f7;width: 1500px;">
<div id="nav" class="shortcut">
    <a href="index.html">
        <img src="image/logo.png" class="logo">
    </a>
    <div class="w">
        <ul class="fl">
            <li>欢迎进入本页面</li>
        </ul>
        <div style="width:330px;float: left;">
            <form action="Search">
                <input type="text" name="search_content" style="width: 250px;height: 25px;margin-top: 12px; margin-left: 20px;" type="text" />
                <button type="submit" style="height: 30px;width: 45px;" onclick="judge()">
                    <font size="2">查找</font>
                </button>
            </form>
        </div>
        <ul class="fr">
            <li>
                <%
                    Applicant sessionApplicant=(Applicant)session.getAttribute("SESSION_APPLICANT");
                    if(sessionApplicant==null)
                    {
                %>
                <a href="Login.html" target="_blank">你好，请先登录 </a>
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
            <li class="space"></li>
            <li class="userinformation">
                <a href="Writing_blog.jsp">我的</a>
                <div class="dropdown-content">
                    <a href="article_extraction">我的博客</a><br>
                    <a href="PersonalHomepage.jsp">我的主页</a><br>
                    <a href="#">我的关注</a><br>
                </div>
            </li>
            <li class="space"></li>
            <%
                }
            %>
        </ul>
    </div>
</div>




<div style="height: 1000px ;width:80%; color: #0f0f0f;margin-left: 152px;margin-left: 152px">
    <div style="background-color: white;float: left; padding-left: 0px;">
        <nav style="">
            <ul class="ulleft">
                <li style="margin-bottom: 10px;"><a style=" display: block; text-align: center;" class="f10" href="">推荐</a></li>
                <li style="margin-bottom: 10px;"><a style="display: block; text-align: center;" href="">推荐</a></li>
                <li style="margin-bottom: 10px;"><a style="display: block; text-align: center;" href="">动态</a></li>
                <li style="margin-bottom: 10px;"><a style="display: block; text-align: center;" href="">程序人生</a></li>
                <li style="margin-bottom: 10px;"><a style="display: block; text-align: center;" href="">Java架构师</a></li>
                <li style="margin-bottom: 10px;"><a style="display: block; text-align: center;" href="">前端</a></li>
                <li style="margin-bottom: 10px;"><a style="display: block; text-align: center;" href="">后端</a></li>
                <li style="margin-bottom: 10px;"><a style="display: block; text-align: center;" href="">数据库</a></li>
                <li style="margin-bottom: 10px;"><a style="display: block; text-align: center;" href="">区块链</a></li>
                <li style="margin-bottom: 10px;"><a style="display: block; text-align: center;" href="">5G</a></li>
                <li style="margin-bottom: 10px;"><a style="display: block; text-align: center;" href="">游戏开发</a></li>
                <li style="margin-bottom: 10px;"><a style="display: block; text-align: center;" href="">云计算</a></li>
            </ul>
        </nav>
    </div>



    <div style="width: 300px; float:right;">
        <div class="rightcard">
            <a><img style="width: 260px; height: 120px;" src="image/广告2.jpg"></a>
        </div>
        <div class="rightcard">
            <a><img style="width: 260px; height: 120px;" src="image/广告8.png"></a>
        </div>
    </div>

    <div style="width: 780px; margin-left: 9%;">

        <div class="card">
            <div align="left" style="width: 60%;">
                <a><img style="width: 740px; height: 120px;" src="image/广告1.png"></a>

            </div>

            <div style="width: 20%; height: 100%; float: right;">

            </div>
        </div>

        <div class="card">
            <div style="float: right; width:230px">
                <img src="image/广告6.png" class="img4">
                <img src="image/广告7.jpg" class="img4">

            </div>

            <div>
                <img src="image/广告3.png" class="img-slide img1" alt="1">
                <img src="image/广告4.png" class="img-slide img2" alt="2">
                <img src="image/广告5.png" class="img-slide img3" alt="3">
            </div>


        </div>


        <c:forEach begin="0" end="4" var="article" items="${requestScope.article_Recommend}">
            <div class="card">
                <a href="ReturnArticleContent?article_id=${article["article_id"]}">
                    <h3>${article["title"]}</h3>
                </a>
                <p>一些文本...</p>
            </div>
        </c:forEach>
    </div>




    <div class="foot">
        <div class="foot-1" style="margin-top: 30px;">
            <a href onclick="">关于我们</a>
            <span>|</span>
            <a href onclick="">联系我们</a>
            <span>|</span>
            <a href onclick="">招聘人才</a>
            <span>|</span>
            <a href onclick="">友情链接</a>
            <span>|</span>
        </div>
        <div class="foot-1" style="margin-top: 10px">
            CopyRight © 2016 杰哥项目 All Rights Reserved
        </div>
        <div class="foot-1" style="margin-top: 10px">
            电话：010-****888 京ICP备*******8号
        </div>
    </div>



</div>
</body>

<script type="text/javascript">
    var index = 0;
    //改变图片
    function ChangeImg() {
        index++;
        var a = document.getElementsByClassName("img-slide");
        if (index >= a.length) index = 0;
        for (var i = 0; i < a.length; i++) {
            a[i].style.display = 'none';
        }
        a[index].style.display = 'block';
    }
    setInterval(ChangeImg, 3000);
</script>
</html>
