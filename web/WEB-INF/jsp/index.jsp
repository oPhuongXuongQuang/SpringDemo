<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <h1>Demo Baby!</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Student ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${STUDENTS}" var="student">
            <form action="./action" method="POST">
                <tr>
                    <td>${student.id}</td>
                    <td>
                        <input type="text" name="txtName" value="${student.name}" required/>

                    </td>
                    <td>
                        <input type="text" name="txtAddr" value="${student.addr}" required/>

                    </td>
                    <td>

                        <input type="hidden" name="txtId" value="${student.id}" />

                        <input type="submit" name="btnAction" value="Update" />
                        <input type="submit" name="btnAction" value="Delete" />
                    </td>
            </form>
        </tr>

    </c:forEach>
</tbody>
</table>

<h1>Add more student</h1>

<form action="./add" method="POST">
    Student Name: <input type="text" name="txtName" value="" required/> <br/>
    Student Address: <input type="text" name="txtAddr" value="" required/> <br/>
    <input type="submit" name="btnAction" value="Add" />
    <input type="reset" value="Reset"/>
</form>
</html>
