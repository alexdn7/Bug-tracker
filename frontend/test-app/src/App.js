import React from 'react';
import TicketList from './Components/tickets'; 
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

function App() {
    return (
      <Router>
        <Routes>
        <Route path="/tickets/all" element={<TicketList />} />
        </Routes>
      </Router>
    );
}

export default App;