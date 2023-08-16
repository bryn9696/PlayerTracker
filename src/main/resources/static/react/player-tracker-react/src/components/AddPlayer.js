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
    <div className="container">
          <h1>Add Player</h1>
          <form onSubmit={handleAddPlayer}>
            <div className="form-group">
              <label className="label" htmlFor="name">Name:</label>
              <input className="input" type="text" id="name" name="name" value={player.name} onChange={handleInputChange} />
            </div>
            <div className="form-group">
              <label className="label" htmlFor="age">Age:</label>
              <input className="input" type="number" id="age" name="age" value={player.age} onChange={handleInputChange} />
            </div>
            <div className="form-group">
              <label className="label" htmlFor="position">Position:</label>
              <input className="input" type="text" id="position" name="position" value={player.position} onChange={handleInputChange} />
            </div>
            <div className="form-group">
              <label className="label" htmlFor="speed">Speed:</label>
              <input className="input" type="number" id="speed" name="speed" value={player.speed} onChange={handleInputChange} />
            </div>
            <div className="form-group">
              <label className="label" htmlFor="accuracy">Accuracy:</label>
              <input className="input" type="number" id="accuracy" name="accuracy" value={player.accuracy} onChange={handleInputChange} />
            </div>
            <div className="form-group">
              <label className="label" htmlFor="strength">Strength:</label>
              <input className="input" type="number" id="strength" name="strength" value={player.strength} onChange={handleInputChange} />
            </div>
            <div className="form-group">
              <label className="label" htmlFor="rating">Rating:</label>
              <input className="input" type="number" id="rating" name="rating" value={player.rating} onChange={handleInputChange} />
            </div>
            <button className="button" type="submit">Add Player</button>
          </form>
          <p><Link className="link" to="/player-list">Back to Player List</Link></p>
        </div>
  );
}

export default AddPlayer;
