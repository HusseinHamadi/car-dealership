import React from "react";
import { Link } from "react-router-dom";
import "./navbar.css";

function NavBar() {
  return (
    <>
      <nav className="nav">
        <div className="left-section">
          <img className="logo" src="images/logo.png" alt="logo" />
        </div>
        <ul className="right-section">
          <li>
            <Link to="/">home</Link>
          </li>
          <li>
            <Link to="/buy">buy car</Link>
          </li>
          <li>
            <Link to="/rent">rent car</Link>
          </li>
          <li>
            <Link to="/about">about</Link>
          </li>
        </ul>
      </nav>
    </>
  );
}

export default NavBar;
