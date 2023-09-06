import React, { useState, useEffect } from 'react';
import {Link} from 'react-router-dom';
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

    function getColorByPriority(priority) {
        if (priority === 'LOW') {
            return 'low-priority';
        } else if (priority === 'MEDIUM') {
            return 'medium-priority';
        } else if (priority === 'HIGH') {
            return 'high-priority';
        }
    };

    return (
        <div className='tickets-main-div'>
            <ul className='tickets-grid'>
                {tickets.map(ticket => (
                    <li className='tickets-card' key={ticket.ticketId}>
                        <h1> {ticket.title}</h1>
                        <h3> Ticket ID: {ticket.ticketId} </h3>
                        <h2> {ticket.description}</h2>
                        <h4> Created by: {ticket.createdBy} </h4>
                        <h4> Created at: {ticket.createdAt} </h4>
                        <h4> Updated by: {ticket.updatedBy}</h4>
                        <h4> Updated at: {ticket.updatedAt} </h4>
                        <h4> Priority: <span className={`${getColorByPriority(ticket.priority.toString())}`}>  {ticket.priority}</span></h4>
                        <h4> Current status: </h4>
                        <div className='button-container'>
                            <Link to={`/tickets/viewTicket/${ticket.ticketId}`}>
                                <button>View more</button>
                            </Link>
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
