<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="pojo.Applicant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人主页</title>
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <style>
        body{
            background-color: #f5f6f7;
        }
        * {
            box-sizing: border-box;
        }
        .container{
            width: 1200px;
            height: 520px;
            margin: 16px auto 0;
        }
        .leftbox{
            height: 470px;
            width: 199px;
            float: left;
            box-shadow: 0 2px 4px 0 rgba(0,0,0,.05);
        }
        .aside{
            background-color: #fff;
            border-bottom:1px solid #e9eaeb;
        }
        .li-active{
            height: 35px;
            background-color: white;
            color: white;
            text-align: center;
            font-size: 16px;
        }
        a{
            text-decoration: none;
            font-size: 16px;
            color: #999;
        }
        li:hover{
            background-color: #fde3e4;
        }
        ul{
            list-style: none;
            padding: 0;
        }
        body{
            margin: 0px;
            background-color: #ffffff;
        }
        .z1{
            font-size: 14px;
            color: #4d4d4d;
            display: inline-block;
            height: 35px;
            line-height: 35px;
            width: 100%;
        }
        /*个人主页显示界面*/
        .view-container{
            margin: 0 200px 0;
            width: 1000px;
            height: 537px;
            padding-left: 30px;
            padding-right: 30px;
            box-shadow: 0 2px 4px 0 rgba(0,0,0,.05);
        }
        .title{
            font-size: 20px;
            color: #3d3d3d;
            height: 90px;
            line-height: 90px;
            border-bottom: 1px solid #e0e0e0;
        }

        .head{
            width: 100px;
            height: 100px;
            float:left;
        }
        .header{
            width: 100px;
            height: 144px;
            text-align: center;
            font-size: 14px;
            cursor: pointer;
            float: left;
            margin:10px 10px 0 0;
        }
        .right{
            width: 820px;
            height: 373px;
            float: left;
            background-color: white;
        }
        .ID-PersonalPage{
            width:820px;
            height:23px;
            margin-top: 16px;
        }
        .personalized-signature{
            overflow: hidden;
            margin-bottom: 9px;
            line-height: 32px;
        }
        .line{
            height: 1px;
            background: #e0e0e0;
        }
        .comon{
            height: 32px;
            line-height: 32px;
            font-size: 14px;
            color: #4d4d4d;
        }
        .change-data{
            float: right;
            font-size: 14px;
            color: #3399ea;
            cursor: pointer;
        }
    </style>
</head>
<body style="margin: 0">
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
<div class="container view" style="background-color: #ffffff">
    <div class="leftbox">
        <ul class="aside">
            <li class="li-active">
                <a href="#" class="z1">个人资料</a>
            </li>
            <li class="li-active">
                <a href="#" class="z1">我的博客</a>
            </li>
            <li class="li-active">
                <a href="#" class="z1">我的收藏</a>
            </li>
        </ul>
    </div>
    <div class="view-container">
        <h3 class="title">个人资料</h3>
        <div class="header">
            <img class="head" src="image/head.jpg" >
            <p style="margin-top: 5px ;color: #2aabd2">修改头像</p>
        </div>
        <div class="right">
            <%
                sessionApplicant=(Applicant)session.getAttribute("SESSION_APPLICANT");
                if(sessionApplicant==null){
            %>
            <div class="ID-PersonalPage" style="color: #999999">ID：xxx</div>
            <div class="ID-PersonalPage" style="margin: 8px 0 16px"> 博客数量：</div>
            <div class="personalized-signature">个人签名：</div>
            <div class="line"></div>
            <div style="height: 32px; width: 820px;">
                <span style="height: 20px;width: 89px;float: left;font-size: 14px;margin-top: 10px">
                    昵称：未填写
                </span>
                <a href="Personal_DataAdd.html" class="change-data" style="margin-top: 10px" >修改资料</a>
            </div>
            <ul>
                <li class="comon">性别：未填写</li>
                <li class="comon">地区：未填写</li>
                <li class="comon">行业：未填写</li>
                <li class="comon">职业：未填写</li>
            </ul>
            <%
                }else{
            %>
            <div class="ID-PersonalPage" style="color: #999999">ID：xxx</div>
            <div class="ID-PersonalPage" style="margin: 8px 0 16px"> 博客数量：3</div>
            <div class="personalized-signature">个人签名：that 's good</div>
            <div class="line"></div>
            <div style="height: 32px; width: 820px;">
            <span style="height: 20px;width: 89px;float: left;font-size: 14px;margin-top: 10px">
                    昵称：<%=sessionApplicant.getApplicantId()%>
            </span>
                <a href="Personal_DataAdd.html" class="change-data" style="margin-top: 10px" >修改资料</a>
            </div>
            <ul>
                <li class="comon">性别：<%=sessionApplicant.getSex()%></li>
                <li class="comon">地区：<%=sessionApplicant.getLocation()%></li>
                <li class="comon">行业：<%=sessionApplicant.getBusiness()%></li>
                <li class="comon">职业：<%=sessionApplicant.getJob()%></li>
            </ul>
            <%
                }
            %>
        </div>
        </div>
    </div>
</div>
<div style="margin-top: 30px;border-bottom: 1px solid #e0e0e0;height: 174px;width: 100%">
    <iframe src="foot.html" width="100%" height="150" scrolling="no"
            frameborder="0"></iframe>
</div>

</body>
</html>