import React, { useState, useEffect } from 'react';
import './tickets.css';

export default function TicketList() {
    const [tickets, setTickets] = useState([]);

    useEffect(()=>{
        fetch("http://localhost:8080/tickets/all")
        .then(res=>res.json())
        .then((result)=>{
          setTickets(result);
        }
      )
      },[])

    return (
        <div className='tickets-main-div'>
            <ul className='tickets-grid'>
                {tickets.map(ticket => (
                    <li className='tickets-card' key={ticket.ticketId}>
                        <h1> {ticket.title}</h1>
                        <h3> Ticket ID: {ticket.ticketId} </h3>
                        <h4> {ticket.description}</h4>
                        <h4> Created by: {ticket.createdBy} </h4>
                        <h4> Created at: {ticket.createdAt} </h4>
                        <h4> Updated by: {ticket.updatedBy}</h4>
                        <h4> Updated at: {ticket.updatedAt} </h4>
                        <h4> Current status: </h4>
                        <div className='button-container'>
                            <button>View more</button>
                            <button>Close ticket</button>
                            <button>Reopen ticket</button>
                        </div>
                        <h4> </h4>
                    </li>
                ))}
            </ul>
        </div>
    );
}
