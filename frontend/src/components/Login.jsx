import React, { useState } from "react";
import { login } from "../services/AuthService";
import "../App.css";

export default function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  
  async function handleSubmit(e) {
    e.preventDefault();
    try {
      const response = await login({ email, password });
      localStorage.setItem("userDetails", JSON.stringify({
        userId: response.data.userId,
        fullName: response.data.fullName,
        role: response.data.role,
        email: response.data.email,
        token: response.data.token
      }));
      console.log("Logged succesfully");
    } catch (error) {
      console.error(error);
    }
  }

  return (
    <div className="d-flex align-items-center justify-content-center login-main-div">
      <form onSubmit={handleSubmit} className="form-group">
        <div className="mb-3">
          <label htmlFor="email">
            <input
              type="text"
              placeholder="Insert your email!"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              className="form-text"
            />
          </label>
        </div>
        <div className="mb-2">
          <label htmlFor="password">
            <input
              type="password"
              placeholder="Insert your password!"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </label>
        </div>
        <div className="text-end">
          <button
            type="submit"
            className="btn btn-primary"
            disabled={email === "" || password === "" ? true : false}
          >
            Login
          </button>
        </div>
        <div className="text-center">
          <p>
            New here?{" "}
          </p>
        </div>
      </form>
    </div>
  );
}
