import React, { useState } from 'react';
import axios from 'axios';
import './addPlayer.css';
import { Link } from 'react-router-dom';
import { API_BASE_URL } from './config';

function AddPlayer() {
  const [player, setPlayer] = useState({
    name: '',
    age: 0,
    position: '',
    speed: 0,
    accuracy: 0,
    strength: 0,
    rating: 0
  });

  const handleInputChange = event => {
    const { name, value } = event.target;
    setPlayer(prevPlayer => ({
      ...prevPlayer,
      [name]: value
    }));
  };

  const handleAddPlayer = async () => {
    try {
      await axios.post('http://localhost:8080/api/players', player);
      // Player added successfully
      console.log('Player added successfully!');
    } catch (error) {
      // Handle error
      console.error('Error adding player:', error);
    }
  };

  return (
    <div>
      <h1>Add Player</h1>
      <form>
        <label>Name: <input type="text" name="name" value={player.name} onChange={handleInputChange} /></label>
        {/* ... other input fields ... */}
      </form>
      <button onClick={handleAddPlayer}>Add Player</button>
      <p><Link to="/player-list">Go to Player List</Link></p>
    </div>
  );
}

export default AddPlayer;
