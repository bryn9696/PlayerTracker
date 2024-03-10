
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './components/Home';
import Teams from './components/Teams';
import AddTeam from './components/AddTeam';
import Players from './components/Players';
import PlayerList from './components/PlayerList';
import AddPlayer from './components/AddPlayer';
import PlayerDetails from './components/PlayerDetails';
//import RatingsForm from './components/ratings-form';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/teams" element={<Teams />} />
        <Route path="/add-team" element={<AddTeam />} />
        <Route path="/players" element={<Players />} />
        <Route path="/player-list" element={<PlayerList />} />
        <Route path="/add-player" element={<AddPlayer />} />
        <Route path="/player/:id" element={<PlayerDetails />} />
      </Routes>
    </Router>
  );
}

export default App;

