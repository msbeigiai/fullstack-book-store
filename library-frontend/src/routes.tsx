import { createBrowserRouter } from "react-router-dom";
import Layout from "./pages/Layout";
import HomePage from "./pages/HomePage";
import SignupForm from "./pages/SignupForm";
import ErrorPage from "./pages/ErrorPage";
import LoginForm from "./pages/LoginForm";

const routes = createBrowserRouter([
  {
    path: "/",
    element: <Layout />,
    errorElement: <ErrorPage />,
    children: [
      { index: true, element: <HomePage /> },
      { path: "/signup", element: <SignupForm /> },
      { path: "/login", element: <LoginForm /> },
    ],
  },
]);

export default routes;
