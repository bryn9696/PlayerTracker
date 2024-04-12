import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import './playerList.css';

function PlayerList() {
  const [players, setPlayers] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch('http://localhost:8080/api/players')
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => setPlayers(data))
      .catch(error => {
        console.error('Error fetching players:', error);
        setError('Error fetching players. Please try again later.');
      });
  }, []);

  if (!players || players.length === 0) {
    return <p>Loading...</p>;
  }

  if (error) {
    return <p>{error}</p>;
  }

console.log(players);
  return (
    <div className="container">
      <h1>Player List</h1>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Position</th>
            <th>Speed</th>
            <th>Accuracy</th>
            <th>Strength</th>
            <th>Rating</th>
            <th>Progression</th>
            <th>Team</th>
            <th>Date Updated</th>

          </tr>
        </thead>
        <tbody>
          {players.map(player => (
            <tr key={player.id}>
              <td>{player.id}</td>
              <td>{player.name}</td>
              <td>{player.age}</td>
              <td>{player.position}</td>
              <td>{player.speed}</td>
              <td>{player.accuracy}</td>
              <td>{player.strength}</td>
              <td>{player.rating}</td>
              <td>{player.progression}%</td>
              <td>{player.team}</td>
              <td>{new Date(player.dateAdded).toLocaleDateString()}</td>

            </tr>
          ))}
        </tbody>
      </table>
      <p><Link className="link" to="/">Go Home</Link></p>
    </div>

  );
}

export default PlayerList;
