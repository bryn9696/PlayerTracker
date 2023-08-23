import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { Link } from 'react-router-dom';
import './playerDetails.css';

function PlayerDetails() {
  const { id } = useParams();
  const [player, setPlayer] = useState(null);

  useEffect(() => {
    fetchPlayerDetails(id);
  }, [id]);

  const fetchPlayerDetails = async (playerId) => {
    try {
      const response = await axios.get(`http://localhost:8080/api/players/${id}`);
      setPlayer(response.data);
    } catch (error) {
      console.error('Error fetching player details:', error);
    }
  };

  if (!player) {
    return <p>Loading player details...</p>;
  }

  return (
    <div className="player-details">
      <h2>{player.name}</h2>
      <p>Age: {player.age}</p>
      <p>Position: {player.position}</p>
      <p>Speed: {player.speed}</p>
      <p>Accuracy: {player.accuracy}</p>
      <p>Strength: {player.strength}</p>
      <p>Rating: {player.rating}</p>
      <p><Link className="link" to="/">Go Home</Link></p>
    </div>
  );
}

export default PlayerDetails;

