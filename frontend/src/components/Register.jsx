import React, { useState } from "react";
import { register } from "../services/AuthService";

export default function Register() {
  const [userDetails, setUserDetails] = useState({
    firstName: "",
    lastName: "",
    role: "",
    email: "",
    password: "",
  });

  async function handleSubmit(e) {
    e.preventDefault();
    try {
      const response = await register({
        firstName: userDetails.firstName,
        lastName: userDetails.lastName,
        role: "Tester",
        email: userDetails.email,
        password: userDetails.password
      });
      localStorage.setItem("token", response.data.token);
      console.log("Registered succesfully");
    } catch (error) {
      console.error(error);
    }
  }

  return (
    <div className="container">
      <form onSubmit={handleSubmit}>
        <label htmlFor="firstName">
          <input
            type="text"
            placeholder="Insert your first name!"
            value={userDetails.firstName}
            onChange={(e) =>
              setUserDetails({ ...userDetails, firstName: e.target.value })
            }
            className="form-text"
          />
        </label>
        <label htmlFor="lastName">
          <input
            type="text"
            placeholder="Insert your last name!"
            value={userDetails.lastName}
            onChange={(e) =>
              setUserDetails({ ...userDetails, lastName: e.target.value })
            }
          ></input>
        </label>
        <label htmlFor="role">
          <input
            type="text"
            placeholder="Insert your role!"
            value={userDetails.role}
            onChange={(e) =>
              setUserDetails({ ...userDetails, role: e.target.value })
            }
          ></input>
        </label>
        <label htmlFor="email">
          <input
            type="email"
            placeholder="Insert your email!"
            value={userDetails.email}
            onChange={(e) =>
              setUserDetails({ ...userDetails, email: e.target.value })
            }
          ></input>
        </label>
        <label htmlFor="password">
          <input
            type="password"
            placeholder="Insert your password!"
            value={userDetails.password}
            onChange={(e) =>
              setUserDetails({ ...userDetails, password: e.target.value })
            }
          ></input>
        </label>
        <button type="submit" className="btn btn-primary">
        Register
      </button>
      </form>
    </div>
  );
}
