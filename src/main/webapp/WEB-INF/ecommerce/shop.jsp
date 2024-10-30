<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="en-US" />
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Shop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@ include file="../../main-nav.jsp" %>
    <div class="container py-4">
        <div class="row g-4">
            <c:forEach items="${products}" var="product">
            <%-- 12 means full-width, 6 means half-width, 4 means one-third width, 3 means one-forth width   --%>
            <div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
                <div class="card shadow-sm">
                    <div class="card-header py-2">
                        <h4 class="my-0 text-center">${product.name}</h4>
                    </div>
                    <div class="card-body">
                        <p class="card-text">${product.description}</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <small class="fw-bold"><fmt:formatNumber value="${product.price}" type="currency" /></small>
                            <a href="add-to-cart?prod_id=${product.id}" class="btn btn-secondary">Add to Cart</a>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
