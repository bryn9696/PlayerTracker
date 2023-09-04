import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { Link } from 'react-router-dom';
import './playerDetails.css';

function PlayerDetails() {
  const { id } = useParams();
  const [player, setPlayer] = useState(null);
  const [editing, setEditing] = useState(false);
  const [editedPlayer, setEditedPlayer] = useState({});

  useEffect(() => {
    fetchPlayerDetails(id);
  }, [id]);

  const fetchPlayerDetails = async (playerId) => {
    try {
      const response = await axios.get(`http://localhost:8080/api/players/${playerId}`);
      setPlayer(response.data);
    } catch (error) {
      console.error('Error fetching player details:', error);
    }
  };

  const handleEditClick = () => {
    setEditedPlayer({ ...player });
    setEditing(true);
  };

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setEditedPlayer((prevEditedPlayer) => ({
      ...prevEditedPlayer,
      [name]: value,
    }));
  };

  const handleSaveClick = async () => {
    try {
      await axios.put(`http://localhost:8080/api/players/${player.id}`, {
        ...editedPlayer,
        dateAdded: new Date(),
      });
      setPlayer({ ...editedPlayer, dateAdded: new Date() });
      setEditing(false);
    } catch (error) {
      console.error('Error updating player:', error);
    }
  };

  const formatDate = (date) => {
    return new Date(date).toLocaleString();
  };

  if (!player) {
    return <p>Loading player details...</p>;
  }

  return (
    <div className="player-details">
      {editing ? (
        <>
          <h2>Edit Player</h2>
          <div className="edit-form">
            <label>Name:</label>
            <input type="text" name="name" value={editedPlayer.name} onChange={handleInputChange} />
          </div>
          <div className="form-group">
            <label className="label" htmlFor="age">Age:</label>
            <input className="input" type="number" id="age" name="age" value={editedPlayer.age} onChange={handleInputChange} />
          </div>
          <div className="form-group">
            <label className="label" htmlFor="position">Position:</label>
            <input className="input" type="text" id="position" name="position" value={editedPlayer.position} onChange={handleInputChange} />
          </div>
          <div className="form-group">
            <label className="label" htmlFor="speed">Speed:</label>
            <input className="input" type="range" id="speed" name="speed" min="0" max="100" value={editedPlayer.speed} onChange={handleInputChange} />
          </div>
          <div className="form-group">
            <label className="label" htmlFor="accuracy">Accuracy:</label>
            <input className="input" type="range" id="accuracy" name="accuracy" min="0" max="100" value={editedPlayer.accuracy} onChange={handleInputChange} />
          </div>
          <div className="form-group">
            <label className="label" htmlFor="strength">Strength:</label>
            <input className="input" type="range" id="strength" name="strength" min="0" max="100" value={editedPlayer.strength} onChange={handleInputChange} />
          </div>
          <div className="form-group">
            <label className="label" htmlFor="rating">Rating:</label>
            <input className="input" type="range" id="rating" name="rating" min="0" max="100" value={editedPlayer.rating} onChange={handleInputChange} />
          </div>
            <button onClick={handleSaveClick}>Save</button>
            <p><Link className="link" to="/">Go Home</Link></p>

        </>
      ) : (
        <>
          <h2>{player.name}</h2>
          <p>Age: {player.age}</p>
          <p>Position: {player.position}</p>
          <p>Speed: {player.speed}</p>
          <p>Accuracy: {player.accuracy}</p>
          <p>Strength: {player.strength}</p>
          <p>Rating: {player.rating}</p>
          <p>Team: {player.team}</p>
          <p>Edited On: {formatDate(player.dateAdded)}</p>
          <button onClick={handleEditClick}>Edit</button>
          <p><Link className="link" to="/">Go Home</Link></p>
        </>
      )}
    </div>
  );
}

export default PlayerDetails;

