import React, { useState } from 'react';
import axios from 'axios';
import './addPlayer.css';
import { Link } from 'react-router-dom';
import { API_BASE_URL } from './config';

function AddTeam() {
  const [team, setTeam] = useState({
    name: '',
    age: 0,
    manager: '',
    squadSize: 0
  });

  const handleInputChange = event => {
    const { name, value } = event.target;
    setTeam(prevTeam => ({
      ...prevTeam,
      [name]: value
    }));
  };

  const handleAddTeam = async () => {
    if (
        team.age < 0 || team.age > 100 ||
        team.squadSize < 0 || team.squadSize > 100
        ) {
      console.error('Must be between 0 and 100');
      return;
    }
    try {
      await axios.post('http://localhost:8080/api/teams', team);
      console.log('Team added successfully!');
    } catch (error) {
      console.error('Error adding team:', error);
    }
  };

  return (
    <div className="container">
          <h1>Add Team</h1>
          <form>
            <div className="form-group">
              <label className="label" htmlFor="name">Team Name:</label>
              <input className="input" type="text" id="name" name="name" value={team.name} onChange={handleInputChange} />
            </div>
            <div className="form-group">
              <label className="label" htmlFor="age">Age Group:</label>
              <input className="input" type="number" id="age" name="age" value={team.ageGroup} onChange={handleInputChange} />
            </div>
            <div className="form-group">
              <label className="label" htmlFor="manager">Manager:</label>
              <input className="input" type="text" id="manager" name="manager" value={team.manager} onChange={handleInputChange} />
            </div>
            <div className="form-group">
              <label className="label" htmlFor="squadSize">Squad Size:</label>
              <input className="input" type="number" id="squadSize" name="squadSize" value={team.squadSize} onChange={handleInputChange} />
            </div>
            <button className="button" type="submit" onClick={handleAddTeam}>Add Team</button>
          </form>
          <p><Link className="link" to="/teams">Back to Team List</Link></p>
        </div>
  );
}

export default AddTeam;