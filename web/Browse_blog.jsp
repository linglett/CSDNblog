<%@ page import="pojo.Applicant" %>
<%@ page import="pojo.article" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>xxx博客</title>

    <link rel="stylesheet" type="text/css" href="css/index2.css" />
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/jquery-3.4.1.min.js"></script>
    <script>
        function comments() {
            var body=$(" textarea[ id='comment_content' ] ").val();
            var article_id=${requestScope.article_Body["article_id"]};
            if(body==='')
                alert("评论不能为空");
            $.ajax({
                url:"save_comments",//请求路径
                type:"POST",
                dataType:"JSON",
                data:{
                    "article_id":article_id,
                    "body":body
                },
                success:function (data) {
                    console.log(data);
                    if(data===true){
                        location.reload();
                    }
                }
            })
        }
            function praise() {
            var praise=${requestScope.article_Body["praise"]};
            var articleid=${requestScope.article_Body["article_id"]};
            $.ajax({
                url:"praise_comment",//请求路径
                type:"POST",
                dataType:"JSON",
                data:{
                    "praise":praise,
                    "article_id":articleid
                },
                success:function (data) {
                    console.log(data);
                    if(data===true){
                        location.reload();
                    }
                }
            })
        }
        function judge() {
            var contend=document.getElementsByName("search_content");
            if(account.value==""){
                alert("搜索内容不能为空");
                account.focus();
                return false;
            }
        }
        function trample() {
            var trample=${requestScope.article_Body["trample"]};
            var articleid=${requestScope.article_Body["article_id"]};
            $.ajax({
                url:"trample_comment",//请求路径
                type:"POST",
                dataType:"JSON",
                data:{
                    "trample":trample,
                    "article_id":articleid
                },
                success:function (data) {
                    console.log(data);
                    if(data===true){
                        location.reload();
                    }
                }
            })
        }
        function delete_comment_js(comment_id) {
            console.log(comment_id);
            $.ajax({
                url:"delete_comments",//请求路径
                type:"POST",
                dataType:"JSON",
                data:{
                    "comment_id":comment_id
                },
                success:function (data) {
                    console.log(data);
                    if(data===true){
                        location.reload();
                    }
                }
            })
        }
    </script>
</head>

<body>
<div class="header-area">
    <div class="header-top">
        <div class="container">
            <a href="index.html">
                <img src="image/logo.png" class="logo">
            </a>

            <div class="nav">
                <ul class="menu-list">
                    <li>欢迎进入本页面</li>
                </ul>

                <div style="width:330px;float: left;">



                    <form action="Search">
                        <input style="border-radius: 4px; width: 250px;height: 25px;margin-top: 12px; margin-left: 20px; background: url(./image/search.png) no-repeat scroll right transparent;"
                               type="text">
                        <button type="submit" onclick="judge()"  style="height: 30px;width: 45px; ">
                            <font size="2">查找</font>
                        </button>
                    </form>
                </div>
                <ul class="menu-list" id="menu2">
                    <li>
                        <%
                            Applicant sessionApplicant=(Applicant)session.getAttribute("SESSION_APPLICANT");
                            if(sessionApplicant==null)
                            {
                        %>
                        <a href="Login.html" target="_blank">你好，请先登录 </a>
                        <a href="Register.html" id="free-register" target="_blank">免费注册</a>
                        <%
                        } else{
                            System.out.println(sessionApplicant.getApplicantId()+"\n"+sessionApplicant.getapplicantemail()+"\n"
                                    +sessionApplicant.getSex());
                        %>
                        <a href="PersonalHomepage.jsp" target="_blank">
                            <%=sessionApplicant.getApplicantId() %>
                        </a>
                        <%
                            }
                        %>
                    </li>
                    <li class="space"></li>
                    <li>
                        <%
                            if(sessionApplicant!=null)
                            {
                        %>
                        <a href="#">写博客</a>
                    </li>
                    <li class="space"></li>
                    <li class="userinformation">
                        <a href="#">我的</a>
                        <div class="dropdown-content">
                            <a href="#">我的博客</a><br>
                            <a href="#">我的主页</a><br>
                            <a href="#">我的关注</a><br>
                        </div>
                    </li>
                    <li class="space"></li>
                    <li>
                        <a href="#">写博客</a>
                    </li>
                    <%
                        }
                    %>
                </ul>
            </div>
        </div>
    </div>
</div>

<div class="central-area">
    <div class="central-left">
        <div class="container1">
            <div class="card">
                <div class="card-top">
                    <div class="user-imgbox">
                        <a href="">
                            <img class="user-img" src="image/head.jpg">
                        </a>
                    </div>

                    <div class="user-namebox">
                        <div class="user-namebox-top">
                            <%
                                Applicant sessionApplicant_browse=(Applicant)session.getAttribute("SESSION_APPLICANT");
                                if(sessionApplicant_browse!=null)
                                {
                            %>
                            <p>
                                <%=sessionApplicant_browse.getApplicantId()%>
                            </p>
                            <%}%>
                        </div>
                        <div class="user-namebox-buttom">
                            <h6>码龄一年</h6>
                        </div>
                    </div>
                </div>
                <div class="card-central1">
                    <dl><a href="">
                        <dt><span>627</span></dt>
                        <dd>原创</dd>
                    </a></dl>
                    <dl class="dl"><a href="">
                        <dt><span>127</span></dt>
                        <dd>周排名</dd>
                    </a></dl>
                    <dl class="dl"><a href="">
                        <dt><span>2027</span></dt>
                        <dd>总排名</dd>
                    </a></dl>
                    <dl class="dl"><a href="">
                        <dt><span>101万</span></dt>
                        <dd>访问</dd>
                    </a></dl>
                    <dl class="dl"><a href="">
                        <dt><span>5</span></dt>
                        <dd>等级</dd>
                    </a></dl>
                </div>
                <div class="item-rank"></div>

                <div class="card-central2">
                    <dl><a href="">
                        <dt><span>1万</span></dt>
                        <dd>积分</dd>
                    </a></dl>
                    <dl class="dl"><a href="">
                        <dt><span>4646</span></dt>
                        <dd>粉丝</dd>
                    </a></dl>
                    <dl class="dl"><a href="">
                        <dt><span>${requestScope.article_Body["praise"]}</span></dt>
                        <dd>获赞</dd>
                    </a></dl>
                    <dl class="dl"><a href="">
                        <dt><span>1220</span></dt>
                        <dd>评论</dd>
                    </a></dl>
                    <dl class="dl"><a href="">
                        <dt><span>1万</span></dt>
                        <dd>收藏</dd>
                    </a></dl>
                </div>
                <div class="card-bottom">
                    <a href="">
                        <button class="button" type="submit"><span>他的主页</span></button>
                    </a>
                    <a href="">
                        <button class="button" type="submit">关注</button>
                    </a>
                    <a href="">
                        <button class="button2" type="submit">私信</button>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <div class="central-right">
        <div class="container1">
            <div class="central-right-article">
                <div class="card">
                    <h2>${requestScope.article_Body["title"]}</h2>
                    <div class="item-rank"></div>
                    <div id="card-right-articalbody">
                        ${requestScope.article_Body["body"]}
                    </div>
                    <div class="article-evaluate">
                        <ul class="menu-list">
                            <li><a href=""><span>点赞</span><span>${requestScope.article_Body["praise"]}</span></a></li>
                            <li><a href=""><span>不喜欢</span></a></li>
                            <li><a href=""><span>收藏</span><span>10</span></a></li>
                        </ul>
                    </div>

                </div>

            </div>
            <div class="central-right-comment">
                <div class="card">
                    <textarea class="comment_contend" name="comment_content" id="comment_content"></textarea>
                    <input onclick="comments()" type="submit" value="发表评论">
                </div>

            </div>





            <div class="central-right-recommend">


                <c:forEach var="comments" items="${requestScope.article_comments}">

                    <div class="card">
                        <div class="user-imgbox"><a><img class="user-img" src="image/head.jpg" onclick=""></a></div>
                        <div class="user-comment">
                            <a onclick=""><span>${comments["source"]}</span></a>
                            <span>: ${comments["body"]}</span>
                        </div>
                        <%
                            article a= (article)session.getAttribute("ARTICLE");
                            if(sessionApplicant_browse!=null&&a.getAuthor().equals(sessionApplicant_browse.getapplicantemail())){
                        %>
                        <a class="date" onclick="delete_comment_js(${comments[" comment_id"]})" style="float: right;">删除评论</a>
                        <%
                            }
                        %>
                    </div>
                </c:forEach>

                <div class="item-rank"></div>
            </div>
        </div>

    </div>


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
</body>
</html>