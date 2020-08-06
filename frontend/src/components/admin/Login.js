import React, { useState } from "react";

export default function Login() {
    const [usernamePassword, setUsernamePassword] = useState({});
    const [hasLoginFailed, setHasLoginFailed] = useState(false);
    const [showSuccessMessage, setShowSuccessMessage] = useState(false);

    const handleLoginForm = e => {
        setUsernamePassword({
            ...usernamePassword,
            [e.target.name]: e.target.value
        });
    };

    const handleLogin = () => {
        if (
            usernamePassword.username === "admin" &&
            usernamePassword.password === "password"
        ) {
            setShowSuccessMessage(true);
            setHasLoginFailed(false);
            console.log("success");
        } else {
            console.log(
                "failed",
                usernamePassword.username,
                usernamePassword.password
            );
            setHasLoginFailed(true);
            setShowSuccessMessage(false);
        }
    };
    return (
        <div>
            <h1>Login</h1>
            <div className="container">
                {hasLoginFailed && (
                    <div className="alert alert-warning">
                        Invalid Credentials
                    </div>
                )}
                {showSuccessMessage && <div>Login Successful</div>}
                User Name:{" "}
                <input type="text" name="username" onChange={handleLoginForm} />
                Password:{" "}
                <input
                    type="password"
                    name="password"
                    onChange={handleLoginForm}
                />
                <button onClick={handleLogin}>Login</button>
            </div>
        </div>
    );
}
