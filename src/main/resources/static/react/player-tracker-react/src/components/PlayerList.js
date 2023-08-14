import React, { useEffect, useState } from 'react';

function PlayerList() {
  const [players, setPlayers] = useState([]);

  useEffect(() => {
    fetch('/api/players')
      .then(response => response.json())
      .then(data => setPlayers(data))
      .catch(error => console.error('Error fetching players:', error));
  }, []);

  return (
    <div>
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
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default PlayerList;
