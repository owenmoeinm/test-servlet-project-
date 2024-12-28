const loginForm = document.getElementById("login")
const signupForm = document.getElementById("signup")

let flag = true;

function signupAction() {
    if (flag === false){
        signupForm.classList.replace("hide" , "show")
        loginForm.classList.replace("show" , "hide")
        flag = true
    }
}

function loginAction() {
    if (flag === true){
        signupForm.classList.replace("show" , "hide")
        loginForm.classList.replace("hide" , "show")
        flag = false
    }
}