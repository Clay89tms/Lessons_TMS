<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.01.2023
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

<body>
<div class="row justify-content-md-center">
    <h1>
        <div class="text-center"><p style="background-color:aquamarine">Menu Cars</p></div>
    </h1>
</div>
<!-- header -->

<div class="row justify-content-md-center">       <!-- content -->
    <div class="col-2">
        <form method="get" action="idcarsAdd">
            <button style="width: 150px">Add/Search Car</button>
        </form>
        <form method="get" action="idcarsList">
            <button style="width: 150px">List</button>
        </form>

    </div>
    <br>
    <hr>
</div>


</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</html>
