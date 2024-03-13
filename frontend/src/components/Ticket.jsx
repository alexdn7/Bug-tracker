import { useParams } from "react-router-dom";
import { getTicketById } from "../services/TicketService";
import { useState, useEffect } from "react";

export default function Ticket() {
  const [ticket, setTicket] = useState(null);

  useEffect(() => {
    getAndSetTicket();
  }, []);

  const { ticketId } = useParams();

  function getAndSetTicket() {
    getTicketById(ticketId)
      .then((response) => {
        setTicket(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }
}
