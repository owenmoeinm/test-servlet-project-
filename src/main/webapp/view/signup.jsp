<jsp:include page="header.jsp"/>

<section class="vh-100">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-6 text-black d-flex align-content-center flex-wrap">

                <div class="px-5 ms-xl-4">
                    <i class="fas fa-crow fa-2x me-3 pt-5 mt-xl-4" style="color: #709085;"></i>
                </div>

                <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">

                    <form action="../auth/signup" method="post" style="width: 23rem;">

                        <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign Up</h3>

                        <div class="form-outline mb-4">
                            <input type="text" id="username" name="username" class="form-control form-control-lg" />
                            <label class="form-label" for="username">User Name</label>
                        </div>

                        <div class="form-outline mb-4">
                            <input type="text" id="password" name="password" class="form-control form-control-lg" />
                            <label class="form-label" for="password">Password</label>
                        </div>

                        <div class="form-outline mb-4">
                            <input type="email" name="email" id="email2" class="form-control form-control-lg" />
                            <label class="form-label" for="email2">Email</label>
                        </div>

                        <div class="pt-1 mb-4">
                            <input class="btn btn-info btn-lg btn-block" type="submit" value="Submit">
                        </div>

                        <p>do you have an account? <a href="/demo2_war_exploded/view/login.jsp" class="link-info">Click here</a></p>

                    </form>

                </div>

            </div>
            <div class="col-sm-6 px-0 d-none d-sm-block">
                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img3.webp"
                     alt="Login image" class="w-100 vh-100" style="object-fit: cover; object-position: left;">
            </div>
        </div>
    </div>
</section>

<jsp:include page="footer.jsp"/>
