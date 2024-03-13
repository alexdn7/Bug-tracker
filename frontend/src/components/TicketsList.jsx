import React, { useEffect, useState } from "react";
import { getAllTickets, getTicketById } from "../services/TicketService";
import Sidebar from "./Sidebar";

export default function TicketsList () {
  const [tickets, setTickets] = useState([]);

  useEffect(() => {
    getAndSetTickets();
  }, []);

  function getAndSetTickets() {
    getAllTickets()
      .then((response) => {
        setTickets(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.error(error);
      });


      getTicketById(1)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  return (
    <div className="container-fluid">
      <div className="row">
        <div className="col-md-1 bg">
          <Sidebar />
        </div>
        <div className="col-md-3">
          <h2 className="text-center">Available tickets</h2>
          {tickets.map((ticket) => (
            <div key={ticket.ticketId}>
              <h2>{ticket.title}</h2>
              <span>{ticket.ticketId}</span>
              <span>{ticket.description}</span>
              <span>{ticket.priority}</span>
              <span>{ticket.projectId}</span>
              <span>{ticket.assignedTo}</span>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}
