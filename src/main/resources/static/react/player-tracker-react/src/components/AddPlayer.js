import React, { useState } from 'react';
import axios from 'axios';
import './addPlayer.css';

function AddPlayer() {
  const [player, setPlayer] = useState({
    name: '',
    age: '',
    position: '',
    speed: '',
    accuracy: '',
    strength: '',
    rating: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setPlayer(prevPlayer => ({
      ...prevPlayer,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('/api/add-players', player)
      .then(response => {
        // Handle success or redirect
        console.log(response.data);
        // Redirect to player list or handle accordingly
      })
      .catch(error => {
        // Handle error
        console.error(error);
      });
  };

  return (
    <div>
      <h2>Add Player</h2>
      <form onSubmit={handleSubmit}>
        <label>Name:</label>
        <input type="text" name="name" value={player.name} onChange={handleChange} required />
        {/* Other input fields for age, position, speed, accuracy, strength, rating */}
        <button type="submit">Add Player</button>
      </form>
    </div>
  );
}

export default AddPlayer;
