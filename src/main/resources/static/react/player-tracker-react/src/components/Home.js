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
    <div>
      <h1>Player Tracker</h1>
      <p>Welcome to the Player Tracker app!</p>
      <p>Here's a list of players:</p>
      <ul>
        {players.map(player => (
          <li key={player.id}>
            <Link to={`/player/${player.id}`}>{player.name}</Link>
          </li>
        ))}
      </ul>
      <p><Link to="/add-player">Go to Add Player</Link></p>
      <p><Link to="/player-list">Go to Player List</Link></p>
    </div>
  );
}

export default Home;