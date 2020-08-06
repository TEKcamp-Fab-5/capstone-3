import React, { useState } from "react";
import Paper from "@material-ui/core/Paper";
import { TextField, Button } from "@material-ui/core";

import "../../styles/Login.css";

export default function Login(props) {
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
            props.history.push("/inventory");
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
        <div className="loginMain">
            <div className="loginContainer">
                <Paper className="loginPaper">
                    {hasLoginFailed && <div>Invalid Credentials</div>}
                    {showSuccessMessage && <div>Login Successful</div>}
                    <div className="loginForm">
                        <TextField
                            type="text"
                            name="username"
                            label="username"
                            onChange={handleLoginForm}
                        />
                        <TextField
                            type="password"
                            name="password"
                            label="password"
                            onChange={handleLoginForm}
                        />
                    </div>
                    <Button
                        variant="contained"
                        color="primary"
                        style={{ marginTop: "2rem" }}
                        onClick={handleLogin}
                    >
                        Login
                    </Button>
                </Paper>
            </div>
        </div>
    );
}
