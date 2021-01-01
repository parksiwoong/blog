<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<%--    <link rel="icon" type="image/png" href="http://example.com/myicon.png">--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <a class="navbar-brand" href="/blog">Blog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">

        <c:choose>
           <c:when test="${empty sessionScope.principal}"> <%-- 만약에 얘를 하고 // principal이 널이거나 비어있다면 --%>
               <ul class="navbar-nav">
                   <li class="nav-item"><a class="nav-link" href="/blog/user/loginForm">로그인</a></li>
                   <li class="nav-item"><a class="nav-link" href="/blog/user/joinForm">회원가입</a></li>
               </ul>
            </c:when>
            <c:otherwise> <%-- 이게 아니라면 얘를 하라 //만약 세션이 있다면 --%>

                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="/blog/board/writerForm">글쓰기</a></li>
                    <li class="nav-item"><a class="nav-link" href="/blog/user/userForm">회원장보</a></li>
                    <li class="nav-item"><a class="nav-link" href="/blog/user/logout">로그아웃</a></li>
                </ul>
            </c:otherwise>
        </c:choose>
    </div>
</nav>
<br/>
