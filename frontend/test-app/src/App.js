import React from 'react';
import TicketList from './Components/getTickets/tickets'; 
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ViewTicket from './Components/viewTicket/viewTicket';
import Sidebar from './Components/sidebar/sidebar';
import TicketForm from './Components/createTicket/ticketForm';
import Login from './Components/login/login';

function App() {
    return (
      <Router>
        <Sidebar />
        <Routes>
          <Route path="/tickets/all" element={<TicketList />} />
          <Route path="/tickets/viewTicket/:ticketId" element={<ViewTicket />} />
          <Route path='tickets/add' element={<TicketForm/>}/>
          <Route path="login" element={<Login />}/>
        </Routes>
      </Router>
    );
}

export default App;