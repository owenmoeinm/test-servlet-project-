<jsp:include page="/view/header.jsp"/>

<div class="container-fluid h-100 bg-dark d-flex align-content-center justify-content-center flex-wrap">
    <div class=" card bg-white">
        <div class="card-header">
            Featured
        </div>
        <div class="card-body">
            <h5 class="card-title">ERROR FOR USER OR PASS</h5>
            <%
                String alertError = (String) request.getAttribute("alertError");
            %>
            <p class="card-text">
                <%= alertError%>
            </p>
            <a href="../auth" class="btn btn-primary">OK</a>
        </div>
    </div>
</div>

<jsp:include page="/view/footer.jsp"/>