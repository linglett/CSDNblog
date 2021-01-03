<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <title>CSDN博客</title>
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link  href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <link href="css/summernote.css" rel="stylesheet">
    <script src="js/summernote.min.js"></script>
    <script src="summernote-master/lang/summernote-zh-CN.js"></script>
    <script type="text/javascript">

        function Publish_Article() {
            var title=$(" input[ name='title_article' ] ").val();
            var article = $('#summernote').summernote('code');
            var keyword=$(" input[ name='keyword_article' ] ").val();
                $.ajax({
                    url:"blog_save",//请求路径
                    type:"POST",
                    dataType:"JSON",
                    data:{
                        "article":article,
                        "title": title,
                        "article_keyword":keyword
                    },
                    success:function (data) {
                        console.log(data);
                        if(data===true){
                            location.href="${pageContext.request.contextPath}/article_extraction";
                        }
                    }
                })
        }
    </script>
</head>
<body style="height: 100%">
<div class="shortcut">
    <div class="fl" style="margin-top: 15px;margin-left: 20px">
        <a href="#">
            文章管理
        </a>
    </div>
    <form>
    <div class="fl" style="width: 1000px;margin-top: 8px;margin-left: 40px;">
        <div style="float: left ;width: 450px">
            <input type="text" class="form-control" style="height: 37px;width: 100%" placeholder="文章标题" name="title_article"/>
        </div>
        <div style="float: left;width: 450px;margin-left: 40px">
            <input type="text" class="form-control" style="height: 37px;width:100%" placeholder="文章关键字" name="keyword_article"/>
        </div>
    </div>

        <div class="w fr"style="width: 330px;height: 30px;margin-top: 8px" >
            <button type="submit" class="btn btn-default" style="margin-right: 8px; width: 120px; background-color: #ca0c16;color: white" onclick="Publish_Article()">发布文章</button>

            <button type="submit" class="btn btn-default" style="width: 120px; background-color: white;color: black" onclick="validata()">取消</button>
        </div>
    </form>
</div>
<div style="width: 100%;height: 1000px">
    <div id="summernote"><p></p></div>
    <script>
        $(document).ready(function() {
            $('#summernote').summernote();
        });
    </script>
</div>
</body>
</html>