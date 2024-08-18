<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Employee | All</title>
</head>
<body>
    <div class="container-fluid pt-3 pb-3">
        <div class="head" style="display: flex; justify-content: space-between;">
            <div class="head1">
                <h2 style="color: darkgreen;" class="pb-5">Employee List</h2>
            </div>
            <div class="head2">
                <a href="Add.jsp" class="btn btn-outline-success">Add</a>
                <a href="Fetch.jsp" class="btn btn-outline-info">Search (Id)</a>
                <a href="Fetch.jsp" class="btn btn-outline-danger">Delete</a>
            </div>
        </div>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Contact</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        Integer count = (Integer) request.getAttribute("employeeCount");
                        if (count != null) {
                            for (int i = 0; i < count; i++) {
                                Integer id = (Integer) request.getAttribute("eId" + i);
                                String name = (String) request.getAttribute("eName" + i);
                                Long contact = (Long) request.getAttribute("eContact" + i);
                                if (id != null && name != null && contact != null) {
                    %>
                    <tr>
                        <td><%= id %></td>
                        <td><%= name %></td>
                        <td><%= contact %></td>
                        <td><a href="fetch?id=<%= id %>" class="btn btn-outline-warning">Edit</a></td>
                        <td><a href="getById?id=<%= id %>" class="btn btn-outline-danger">Delete</a></td>
                    </tr>
                    <% 
                                }
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="3">No employees found</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
