<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<h2>Hello World!</h2>
<h3>文件上传页面</h3>
<br>
<form name="form" action="uploadfile" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td><label>文件信息：</label></td>
            <td><input type="text" name="information"></td>
        </tr>
        <tr>
            <td><label>选择文件：</label></td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td><input type="submit" id="submit" value="上传"></td>
        </tr>
    </table>
</form>
<h3>文件上传页面2</h3>
<br>
<form name="form2" action="upload1" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td><label>文件信息：</label></td>
            <td><input type="text" name="information"></td>
        </tr>
        <tr>
            <td><label>选择文件：</label></td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td><input type="submit" id="submit2" value="上传"></td>
        </tr>
    </table>
</form>
<h3>文件上传页面</h3>
<br>
<form name="form3" action="upload2" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td><label>文件信息：</label></td>
            <td><input type="text" name="information"></td>
        </tr>
        <tr>
            <td><label>选择文件：</label></td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td><input type="submit" id="submit3" value="上传"></td>
        </tr>
    </table>
</form>
</body>
</html>