import { Outlet, Navigate } from "react-router-dom";

const PrivateRoutes = () => {
  let userDetails = localStorage.getItem("userDetails");
  //<Outlet />

  if (userDetails !== null) {
    let role = userDetails.role;
    return <Outlet />
  } else {
    return <Navigate to="/login" />;
  }
};

export default PrivateRoutes;
