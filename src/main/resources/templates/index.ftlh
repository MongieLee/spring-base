<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>排行榜</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>排名</th>
        <th>名字</th>
        <th>分数</th>
    </tr>
    </thead>
    <tbody>
    <#list items as item>
        <tr>
        <td>${item?index +1}</td>
        <td>${item.user.username}</td>
        <td>${item.score}</td>
        </tr>
    </#list>
    <tr>

    </tr>
    </tbody>
</table>
</body>
</html>