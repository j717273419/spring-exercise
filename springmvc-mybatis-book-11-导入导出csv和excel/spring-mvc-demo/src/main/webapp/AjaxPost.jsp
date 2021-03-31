<%--
  Created by IntelliJ IDEA.
  User: wdj
  Date: 2021-03-30
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script>

        function commit(){
            $.ajax({
                type: 'POST',
                url: "${pageContext.request.contextPath}/jsonrequest",
                contentType: "application/json",
                data: JSON.stringify({"name":"lucas222","age":"183","id":21}),
                dataType: "json",//期待返回的数据类型
                success: function(data){
                    $("#commit-result").text(JSON.stringify(data))
                },
                error:function(data){
                    alert("error"+data);
                }
            });
        }

        function commitJson(){
            $.ajax({
                type: 'POST',
                url: "${pageContext.request.contextPath}/jsonobjPost",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                data: {"name":"lucas222888","age":"1883","id":2991},
                dataType: "json",//期待返回的数据类型
                success: function(data){
                    $("#commit-result").text(JSON.stringify(data))
                },
                error:function(data){
                    alert("error"+data);
                }
            });
        }

        $().ready(function (){
            $("#ajax").click(function(){
                $.ajax({
                    url:"/curd",
                    method:"post",
                    success:function(resp){
                        $("h5").text(resp)
                    }
                })
            })
        })
    </script>
</head>
<body>
<h1>Ajax Post demo</h1>
result:
<h5></h5>
<button id="ajax">提交</button>

<h1>ajax post 提交json格式数据</h1>
result:
<h7 id="commit-result"></h7>
<button id="commit" onclick="commit()">提交json字符串格式数据</button>
<button id="commitobj" onclick="commitJson()">提交json字符串格式数据，后台分参数接收</button>

<h1>Form Submit demo</h1>
<form action="/curd" method="post">
    <input name="params">
    <button type="submit">提交表单</button>
</form>
</body>
</html>
