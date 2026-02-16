import React, { useState, useEffect } from "react";
import Header from "../components/Header";
import "./home.css";
import axios from "axios";

function HomePage() {
  const [newCars, setNewCars] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/newcars").then((response) => {
      setNewCars(response.data);
    });
  }, []);

  console.log(newCars);
  return (
    <>
      <div className="container">
        <div className="header">
          <Header></Header>
        </div>
        <div className="cover">
          <img src="images/hero.jpg" alt="hero.jpg" />
        </div>
      </div>
    </>
  );
}

export default HomePage;
