-- Drop existing tables
DROP TABLE IF EXISTS player;

-- Create the Player table
CREATE TABLE IF NOT EXISTS player (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT,
    position VARCHAR(255),
    speed INT,
    accuracy INT,
    strength INT,
    rating INT
);
