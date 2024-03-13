import axios from "axios";

const BASE_URL = "http://localhost:8080/api/auth";

export const login = (userDetails) => axios.post(BASE_URL + "/login", userDetails);

export const register = (userDetails) => axios.post(BASE_URL + "/register", userDetails);