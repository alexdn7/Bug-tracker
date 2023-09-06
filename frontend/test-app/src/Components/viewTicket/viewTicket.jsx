import React, { useState, useEffect } from 'react';
import './viewTicket.css';
import { useParams } from "react-router-dom";

export default function ViewTicket() {
    const [ticket, setTicket] = useState({});
    const { ticketId } = useParams();

    useEffect(() => {
        fetch(`http://localhost:8080/tickets/viewTicket/${ticketId}`)
            .then(res => res.json())
            .then(result => {
                setTicket(result);
            });
    }, [ticketId]);

    return (
        <div className='ticket-card'>
        <ul className='ticket-card-list'>
            <li>
                <h1>{ticket.title}</h1>
            </li>
            <li>
                <h3>Ticket ID: {ticket.ticketId}</h3> 
            </li>
            <li>
                <h4>{ticket.description}</h4>
            </li>
            <li>
                <h4>Created by: {ticket.createdBy}</h4>
            </li>
            <li>
                <h4>Created at: {ticket.createdAt}</h4>
            </li>
            <li>
                <h4>Updated by: {ticket.updatedBy}</h4>
            </li>
            <li>
                <h4>Updated at: {ticket.updatedAt}</h4>
            </li>
            <li>
                <h4>Current status: {ticket.status}</h4>
            </li>
            <li>
                <div className='button-container'>
                    <button>Close ticket</button>
                    <button>Reopen ticket</button>
                </div>
            </li>
        </ul>
    </div>
    );
}
