<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>欢迎登陆csdn博客</title>
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link  href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script src="js/jquery-3.4.1.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
    <link rel="stylesheet" href>
    <script type="text/javascript">
      function myFunction() {
        location.href="Recommend";
      }
    </script>
  </head>
  <body onpageshow="myFunction()">
       <jsp:include page="Head.jsp"></jsp:include>
  </body>
</html>
