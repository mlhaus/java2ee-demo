<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String num1 = (String)request.getAttribute("num1");
    num1 = num1 == null ? "" : num1;
    String num2 = (String)request.getAttribute("num2");
    num2 = num2 == null ? "" : num2;

    String result = (String)request.getAttribute("result");
    result = result == null ? "" : result;

    String num1Error = (String)request.getAttribute("num1Error");
    num1Error = num1Error == null ? "" : num1Error;
    String num2Error = (String)request.getAttribute("num2Error");
    num2Error = num2Error == null ? "" : num2Error;
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>My Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<div class="container my-4">
    <div class="row">
        <div class="col-6">
            <h1>My Calculator</h1>
            <p class="lead">Enter two numbers and press submit to calculate the result.</p>
            <form method="post" action="my-calculator">
                <div class="form-group mb-2">
                    <label for="num1">Number 1:</label>
                    <input type="text" class="form-control" id="num1" name="num1" value="<%= num1 %>">
                    <div style="color: red;"><%= num1Error %></div>
                </div>
                <div class="form-group mb-2">
                    <label for="num2">Number 2:</label>
                    <input type="text" class="form-control" id="num2" name="num2" value="<%= num2 %>">
                    <div style="color: red;"><%= num2Error %></div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <div style="color: green;"><%= result %></div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>