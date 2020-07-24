<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
Created by IntelliJ IDEA.
User: lauraluca
Date: 2020-04-21
Time: 17:06
To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <title>COVID-19</title>
<%--    <link rel="stylesheet" type="text/css" href="../CSS/Home.css">--%>
<%--    <script type="text/javascript" src="../JS/Home.js"></script>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>

    <body>

    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-4">COVID-19 TRACKER</h1>
            <p class="lead">Welcome to COVID-19 tracker, here you can check all the positive, negative and recovered
            cases for the current day.</p>
            <hr class="my-4">
            <p class="lead">Total cases today : ${totalCases}</p>
        </div>
    </div>

        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">State</th>
                <th scope="col">Positive cases</th>
                <th scope="col">Negative cases</th>
                <th scope="col">Recovered</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="State" items="${States}">
            <tr>
                <td>${State.state}</td>
                <td>${State.positive}</td>
                <td>${State.negative}</td>
                <td>${State.recovered}</td>
            </tr>
                </c:forEach>
            </tbody>

        </table>

    </body>

</html>