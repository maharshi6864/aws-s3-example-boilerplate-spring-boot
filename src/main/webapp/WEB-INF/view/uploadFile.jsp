<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Your Files here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="4"><h1>Upload Files</h1></td>
		</tr>
		<tr>
			<td colspan="4"><form action="uploadFile" method="post"
					enctype="multipart/form-data">
					<input type="file" name="fileToBeUploaded">
					<button type="submit">Upload</button>
				</form></td>
		</tr>
		<tr>
			<td colspan="4"><h2>File Details</h2></td>
		</tr>

		<tr>
			<th>Sr.no</th>
			<th>File Name</th>
			<th>File Size</th>
			<th>Action</th>
		</tr>
		<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
		<c:forEach items="${fileVoList}" var="i" varStatus="j">
			<tr>
				<td>${j.count}</td>
				<td>${i.fileName}</td>
				<td>${i.size}</td>
				<td><a href="delete?file_id=${i.id}"><button>Delete</button></a></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>