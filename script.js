document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault();
    var params = new URLSearchParams(window.location.search);
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    if (username === "weber75614433" && password === "Hd83714433") {
        window.location.href = "welcome.html";
    } else {
        alert("Login failed, please check the account and password");
    }
});
