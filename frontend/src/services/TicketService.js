import axios from "axios";

const baseUrl = "http://localhost:8080/api/ticket";

export const createTicket = (ticket) => axios.post(baseUrl + "/add", ticket);

export const getTicketById = (ticketId) =>
  axios.get(baseUrl + "\view" + ticketId);

export const getAllTickets = () => axios.get(baseUrl + "/view");

export const updateTicket = (ticketId, ticket) =>
  axios.put(baseUrl + "/update" + ticketId, ticket);

export const deleteTicket = (ticketId) =>
  axios.delete(baseUrl + "/delete" + ticketId);
