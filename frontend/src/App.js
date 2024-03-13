import Header from "./components/Header";
import Footer from "./components/Footer";
import TicketsList from "./components/TicketsList";
import Login from "./components/Login";
import Register from "./components/Register";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import PrivateRoutes from "./utils/PrivateRoutes";
import Ticket from "./components/Ticket";
import Project from "./components/Project";

function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route element={<Login />} path="/login"></Route>
          <Route element={<Register />} path="/register"></Route>
          <Route element={<PrivateRoutes />}>
            <Route element={<TicketsList />} path="/tickets/view" />
            <Route element={<Ticket />} path="/tickets/view/:ticketId" />
            <Route element={<Project />} path="/projects/view/:projectId" />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
