<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Training.by</title>
    <link href="js/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="js/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
    <script src="js/jquery-validation/dist/jquery.validate.min.js"></script>
</head>
<body>
<nav class="navbar navbar-my" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Training.by</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Искать">
                </div>
                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span> Искать
                </button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" class="glyphicon glyphicon-user" data-toggle="dropdown"> ${user}<span
                            class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="controller?command=edit_page_admin">Редактировать</a></li>
                        <c:if test="${userType == 'ADMIN'}">
                            <li><a href="controller?command=show_stud">Студенты</a></li>
                            <li><a href="controller?command=show_sheet_student">Записи на курс</a></li>
                            <li><a href="controller?command=add_course">Добавить курс</a></li>
                        </c:if>
                        <li class="divider"></li>
                        <li><a href="controller?command=logout">Выйти</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>


<table class="table table-hover">
    <thead>
    <tr>

        <th>Название</th>
        <th>айдишник препода</th>
        <th>описание</th>
        <th>статус</th>

    </tr>
    </thead>
    <tbody>
    <form name="test" method="post" action="controller?command=add_course">
        <c:forEach var = "course" items="${courseList}" varStatus="i">
            <tr>
                <td>

                    <p><b>Название:</b><br>
                        <input name="name" type="text" size="15"></p>
                    <td>
                    <p><b>Учитель:</b><br>
                        <input name="id_teacher" type="text" size="15" value="${ course.teacher }></p>
                <td><c:out value="${ course.teacher }" /></td>
            </td>
                    <p><b>Описание:</b><br>
                        <input name="description" type="text" size="15"></p>
                    <p><b>Статус:</b><br>
                        <input name="status" type="text" size="15"></p>
                </td>x

            </tr>
            <input type="hidden" name="id_course" value="${course.idCourse}" />
        </c:forEach>
        <p>
            <input type="hidden" name="id_course" value="<%= request.getAttribute("idCourse") %>">
            <input type="submit" value="Добавить"></p>
    </form>
    </tbody>


</table>



</div>
</body>
</html>