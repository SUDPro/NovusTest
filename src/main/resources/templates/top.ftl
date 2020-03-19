<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<h3>Самые оцениваемые котики</h3>
<h5><a href="/vote">Оценить ещё</a></h5>
<#--<ul>-->
<#--    <#list cats as cat>-->
<#--        <li>${cat.getName()} - ${cat.getRate()}</li>-->
<#--    </#list>-->
<#--</ul>-->

<table class="table table-striped">
    <thead>
    <tr>
        <th>Mесто</th>
        <th>Котик</th>
    </tr>
    </thead>
    <tbody>
    <#list cats as cat>
    <tr>
        <td>${cat?index + 1}</td>
        <td>
            <img width="770" height="430" src="${cat.photoPath}">
            <h5>${cat.name}</h5>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
</div>
</body>
</html>