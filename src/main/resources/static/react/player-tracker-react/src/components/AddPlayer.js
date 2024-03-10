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
    rating: 0,
    team: ''
  });

  const handleInputChange = event => {
    const { name, value } = event.target;
    setPlayer(prevPlayer => ({
      ...prevPlayer,
      [name]: value
    }));
  };

  const handleAddPlayer = async () => {
    if (
        player.strength < 0 || player.strength > 100 ||
        player.speed < 0 || player.speed > 100 ||
        player.accuracy < 0 || player.accuracy > 100 ||
        player.rating < 0 || player.rating > 100
        ) {
      console.error('Rating must be between 0 and 100');
      return;
    }
    try {
      await axios.post('http://localhost:8080/api/players', player);
      console.log('Player added successfully!');
    } catch (error) {
      console.error('Error adding player:', error);
    }
  };

  return (
    <div className="container">
          <h1>Add Player</h1>
          <form>
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
              { player.speed < 0 || player.speed > 100 ? (
                <p className="error-message">Rating must be between 0 and 100</p>
                ) : null }
            </div>
            <div className="form-group">
              <label className="label" htmlFor="accuracy">Accuracy:</label>
              <input className="input" type="number" id="accuracy" name="accuracy" value={player.accuracy} onChange={handleInputChange} />
              { player.accuracy < 0 || player.accuracy > 100 ? (
                <p className="error-message">Rating must be between 0 and 100</p>
                ) : null }
            </div>
            <div className="form-group">
              <label className="label" htmlFor="strength">Strength:</label>
              <input className="input" type="number" id="strength" name="strength" value={player.strength} onChange={handleInputChange} />
              { player.strength < 0 || player.strength > 100 ? (
                <p className="error-message">Rating must be between 0 and 100</p>
                ) : null }
            </div>
            <div className="form-group">
              <label className="label" htmlFor="rating">Rating:</label>
              <input className="input" type="number" id="rating" name="rating" value={player.rating} onChange={handleInputChange} />
              { player.rating < 0 || player.rating > 100 ? (
                <p className="error-message">Rating must be between 0 and 100</p>
                ) : null }
            </div>
             <div className="form-group">
               <label className="label" htmlFor="team">Team:</label>
               <input className="input" type="text" id="team" name="team" value={player.team} onChange={handleInputChange} />
             </div>
            <button className="button" type="submit" onClick={handleAddPlayer}>Add Player</button>
          </form>
          <p><Link className="link" to="/players">Back to Player List</Link></p>
        </div>
  );
}

export default AddPlayer;
