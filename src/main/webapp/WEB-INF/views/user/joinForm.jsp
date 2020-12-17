<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<%@ include file="../layout/header.jsp" %>
<div class="container">
    <form>
        <div class="form-group">
            <label for="username">username address:</label>
            <input type="text" class="form-control" placeholder="Enter username" id="username">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" placeholder="Enter password" id="password">
        </div>
        <div class="form-group">
            <label for="email">Email address:</label>
            <input type="email" class="form-control" placeholder="Enter email" id="email">
        </div>

        <button id="btn-save" class="btn btn-primary">회원가입</button>
    </form>
</div>

<script src="/blog/js/user.js"></script><%-- 경로안찾아질때 한번해보기 <script type=text/javascript> --%>
<%@ include file="../layout/footer.jsp" %>