import axios from "axios";

const BASE_URL = "http://localhost:8080/api/project";
const token = JSON.parse(localStorage.getItem("userDetails")).token;
const TOKEN_HEADER = {
  headers: {
    Authorization: `Bearer ${token}`,
  },
};

export const createProject = (project) =>
  axios.post(BASE_URL + "/add", project, TOKEN_HEADER);

export const getProjectById = (projectId) =>
  axios.get(BASE_URL + "/view/" + projectId, TOKEN_HEADER);
