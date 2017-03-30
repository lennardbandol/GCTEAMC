<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*, com.example.business.Task" %>



	
<table>
  <c:forEach items="${tasks}" var="task">
    <tr>
      <td><c:out value="${task.getTaskName()}" /></td>
      <td><c:out value="${task.getWeight()}" /></td>
      <td><c:out value="${task.getDate()}" /></td>
    </tr>
  </c:forEach>
</table>
	

