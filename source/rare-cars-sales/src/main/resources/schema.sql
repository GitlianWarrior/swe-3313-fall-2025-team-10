CREATE TABLE IF NOT EXISTS users (
    userID           INTEGER PRIMARY KEY AUTOINCREMENT,
    username         TEXT    NOT NULL UNIQUE,
    password         TEXT    NOT NULL,
    firstName        TEXT    NOT NULL,
    lastName         TEXT    NOT NULL,
    email            TEXT    NOT NULL,
    isAdministrator  INTEGER NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS inventory (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    price REAL NOT NULL,
    image TEXT,
    description TEXT,
    status TEXT NOT NULL DEFAULT 'Available'
);

CREATE TABLE IF NOT EXISTS sales (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    sale_date TEXT NOT NULL,
    total REAL NOT NULL,
    tax REAL NOT NULL,
    buyer_id INTEGER NOT NULL,
    FOREIGN KEY (buyer_id) REFERENCES users(id)
    );

CREATE TABLE IF NOT EXISTS sale_items (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    sale_id INTEGER NOT NULL,
    car_id INTEGER NOT NULL,
    FOREIGN KEY (sale_id) REFERENCES sales(id),
    FOREIGN KEY (car_id) REFERENCES inventory(id)
    );