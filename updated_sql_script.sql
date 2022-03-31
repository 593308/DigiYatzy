DROP SCHEMA IF EXISTS yatzy CASCADE;
CREATE SCHEMA yatzy;
SET search_path = yatzy;

CREATE TABLE yatzyUser
(
	username VARCHAR(20),
	email VARCHAR(20),
	pwd_hash CHAR(64),
	pwd_salt CHAR(32),
	PRIMARY KEY (username)
);

CREATE TABLE yatzyGame 
(
	gameId SERIAL,
	hostplayer VARCHAR(20),
	eventCounter INTEGER,
	gameState CHAR(20),
	roundCount INTEGER,
	currentPlayer VARCHAR(20),
	diceRollCount INTEGER,
	strikeCount INTEGER,
	die0Value INTEGER,
	die1Value INTEGER,
	die2Value INTEGER,
	die3Value INTEGER,
	die4Value INTEGER,
	lastInput TIMESTAMP,
	PRIMARY KEY (gameid)
);

CREATE TABLE player
(
	username VARCHAR(20),
	gameId INTEGER,
	playerState CHAR(20),
	onesScore INTEGER,
	twosScore INTEGER,
	threesScore INTEGER,
	foursScore INTEGER,
	fivesScore INTEGER,
	sixesScore INTEGER,
	bonusScore INTEGER,
	onePairScore INTEGER,
	twoPairsScore INTEGER,
	threeOfAKindScore INTEGER,
	fourOfAKindScore INTEGER,
	smallStraightScore INTEGER,
	largeStraightScore INTEGER,
	fullHouseScore INTEGER,
	chanceScore INTEGER,
	yatzyScore INTEGER,
	totalScore INTEGER,
	FOREIGN KEY (username) REFERENCES YatzyUser(username),
	FOREIGN KEY (gameid) REFERENCES YatzyGame(gameid),
	PRIMARY KEY (username, gameid)
);