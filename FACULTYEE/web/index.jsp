<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<html>--%>
<%--<head><title>Index</title></head>--%>
<%--<body>--%>
<%--<jsp:forward page="/jsp/login.jsp"/>--%>
<%--</body></html>--%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Traning.by</title>
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
            <a class="navbar-brand" href="#">Traning.by</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Искать">
                </div>
                <button type="submit" class="btn btn-default"><span class = "glyphicon glyphicon-search"></span> Искать</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="controller?command=loginpage">Вход</a></li>
                <li><a href="controller?command=registrationpage">Регистрация</a></li>
            </ul>
        </div>
    </div>
</nav>
<h2 style="color: #843534; margin-left: 4%;">Приветствуем на Training.by</h2>
<p style="margin-left: 1%;"> рады приветствовать Вас на официальном портале тренинг-центра Рога и Копыта.
    Миссия нашего тренинг-центра – эффективная подготовка начинающих специалистов для дальнейшего трудоустройства в компании Рога и Копыта.
    Тренинги проводятся сплоченной командой профессиональных тренеров, имеющих богатый опыт работы и проведения тренингов по соответствующим направлениям.
    Мы предоставляем нашим слушателям полноценные учебные материалы, творческие задания для проявления потенциала при одновременной возможности получения новых знаний и закрепления изученного материала на практике.</p>


<h3 style="color: #afd9ee; margin-left: 4%;">КОГО МЫ ХОТИМ ВИДЕТЬ НА НАШИХ ТРЕНИНГАХ?</h3>

<p style="margin-left: 1%;">Инициативных, коммуникабельных, технически образованных студентов и выпускников, нацеленных на работу по выбранной специальности в компании Рога и Копыта.
Ежегодно наш тренинг-центр готовит десятки начинающих специалистов, успешно продолжающих свою карьеру в команде профессионалов.
Все проводимые нашим тренинг-центром мероприятия являются бесплатными для их участников.</p>



</body>
</html>