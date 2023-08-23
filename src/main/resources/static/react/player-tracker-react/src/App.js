
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './components/Home';
import PlayerList from './components/PlayerList';
import AddPlayer from './components/AddPlayer';
import PlayerDetails from './components/PlayerDetails';
//import RatingsForm from './components/ratings-form';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/player-list" element={<PlayerList />} />
        <Route path="/add-player" element={<AddPlayer />} />
        <Route path="/player/:id" element={<PlayerDetails />} />
      </Routes>
    </Router>
  );
}

export default App;

