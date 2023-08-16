import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import './home.css';


function Home() {
  const [players, setPlayers] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/players')
      .then(response => response.json())
      .then(data => setPlayers(data));
  }, []);

  return (
    <div className="container">
      <h1 className="title">Player Tracker</h1>
      <p className="description">Welcome to the Player Tracker app!</p>
      <p className="description">Here's a list of players:</p>
      <ul>
        {players.map(player => (
          <li key={player.id}>
            <Link to={`/player/${player.id}`}>{player.name}</Link>
          </li>
        ))}
      </ul>
      <p><Link className="link" to="/add-player">Go to Add Player</Link></p>
      <p><Link className="link" to="/player-list">Go to Player List</Link></p>
    </div>
  );
}

export default Home;
