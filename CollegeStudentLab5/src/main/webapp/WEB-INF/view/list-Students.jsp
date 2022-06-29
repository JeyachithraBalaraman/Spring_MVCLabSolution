<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Students Directory</title>
</head>

<body>

	<div class="container">

		<h3>List Of Students enrolled for Debate Event</h3>
		<hr>

		<!-- Add a search form -->

		<form action="/CollegeStudentLab5/collegeStudent/listStudent"
			class="form-inline">

			<!-- Add a button -->
			<a href="/CollegeStudentLab5/collegeStudent/formForAdd"
				class="btn btn-primary btn-sm mb-3"> Add Student </a>


		</form>

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Department</th>
					<th>Country</th>
					<th>Action</th>

				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Student}" var="tempStudent">
					<tr>
						<td><c:out value="${tempStudent.id}" /></td>
						<td><c:out value="${tempStudent.studName}" /></td>
						<td><c:out value="${tempStudent.studDept}" /></td>
						<td><c:out value="${tempStudent.studCountry}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/CollegeStudentLab5/collegeStudent/formForUpdate?id=${tempStudent.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a
							href="/CollegeStudentLab5/collegeStudent/delete?id=${tempStudent.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>
		<form action="/CollegeStudentLab5/collegeStudent/logout"
			class="form-inline">

			<!-- Add a button -->
			<a href="/CollegeStudentLab5/collegeStudent/logout"
				class="btn btn-primary btn-sm mb-3"
				onclick="if (!(confirm('Are you sure you want to exit?'))) return false">
				logout </a>


		</form>
	</div>

</body>
</html>



