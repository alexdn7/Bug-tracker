import axios from "axios";

const BASE_URL = "http://localhost:8080/api/ticket";
const token = JSON.parse(localStorage.getItem("userDetails")).token;
const TOKEN_HEADER = {
  headers: {
    Authorization: `Bearer ${token}`,
  },
};

export const createTicket = (ticket) =>
  axios.post(BASE_URL + "/add", ticket, TOKEN_HEADER);

export const getTicketById = (ticketId) =>
  axios.get(BASE_URL + "/view/" + ticketId, TOKEN_HEADER);

export const getAllTickets = () => axios.get(BASE_URL + "/view", TOKEN_HEADER);

export const updateTicket = (ticketId, ticket) =>
  axios.put(BASE_URL + "/update" + ticketId, ticket, TOKEN_HEADER);

export const deleteTicket = (ticketId) =>
  axios.delete(BASE_URL + "/delete" + ticketId, TOKEN_HEADER);
