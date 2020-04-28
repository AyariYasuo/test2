<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<% List<Map<String,Object>> examineeInfoList = (List<Map<String,Object>>)request.getAttribute("ExamineeInfoList"); %>
<html>
<head>
<title>受験者一覧</title>
<style>
  .table1 {
    border-collapse: collapse;
    width: 700px;
  }
  .table1 th, .table1 td {
    border: 1px solid gray;
  }
</style>
</head>
<body>
<div class="container">
<div class="col-9 ml-7">
<h1>受験者一覧</h1>

<form action="ActionServlet" method="post">
    <table class="table1">
        <tr>
            <th></th>
            <th>タイムスタンプ</th>
            <th>受験者名</th>
            <th>性別</th>
            <th>誕生日</th>
            <th>最終学歴</th>
            <th>現在の状態</th>
        </tr>
        <% for (Map<String,Object> examineeInfo: examineeInfoList) {%>
        <tr>
        	<td><input type="radio" name="examineeId" value="<%=examineeInfo.get("examineeId")%>"></td>
            <td><label for="info"><%=examineeInfo.get("time")%></label></td>
            <td><label for="info"><%=examineeInfo.get("name")%></label></td>
            <td><label for="info"><%=examineeInfo.get("gender")%></label></td>
            <td><label for="info"><%=examineeInfo.get("birth")%></label></td>
            <td><label for="info"><%=examineeInfo.get("edu")%></label></td>
            <td><label for="info"><%=examineeInfo.get("status")%></label></td>
        </tr>
        <%} %>
    </table>

<button type="submit" class="btn btn-success" name="action" value="chart">診断表</button><br>
</form>
</div>
</div>
</body>
</html>