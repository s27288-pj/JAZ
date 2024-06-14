-- Insert Dictionary
INSERT INTO Dictionary_Entity (id, VALUE_NAME, DICTIONARY_NAME) VALUES (UUID(), 'John', 'Name');
INSERT INTO Dictionary_Entity (id, VALUE_NAME, DICTIONARY_NAME) VALUES (UUID(), 'Jane', 'Name');
INSERT INTO Dictionary_Entity (id, VALUE_NAME, DICTIONARY_NAME) VALUES (UUID(), 'Alice', 'Name');

-- Insert owner
INSERT INTO Owner (id, name, surname, email, address, phone) VALUES (UUID(), 'John', 'Doe', 'john.doe@example.com', '123 Main St', '555-1234');
INSERT INTO Owner (id, name, surname, email, address, phone) VALUES (UUID(), 'Jane', 'Doe', 'jane.doe@example.com', '456 Main St', '555-5678');
INSERT INTO Owner (id, name, surname, email, address, phone) VALUES (UUID(), 'Alice', 'Smith', 'alice.smith@example.com', '789 Main St', '555-9012');

-- Insert figurines
INSERT INTO Figurine (id, name, description, model, series, buy_Price, id_owner_id) VALUES (UUID(), 'Figurine 1', 'Description of Figurine 1', 'Model 1', 'Series A', 20.00, (SELECT id FROM Owner WHERE email = 'john.doe@example.com'));
INSERT INTO Figurine (id, name, description, model, series, buy_Price, id_owner_id) VALUES (UUID(), 'Figurine 2', 'Description of Figurine 2', 'Model 2', 'Series B', 25.00, (SELECT id FROM Owner WHERE email = 'john.doe@example.com'));
INSERT INTO Figurine (id, name, description, model, series, buy_Price, id_owner_id) VALUES (UUID(), 'Figurine 3', 'Description of Figurine 3', 'Model 3', 'Series C', 30.00, (SELECT id FROM Owner WHERE email = 'john.doe@example.com'));
INSERT INTO Figurine (id, name, description, model, series, buy_Price, id_owner_id) VALUES (UUID(), 'Figurine 4', 'Description of Figurine 4', 'Model 4', 'Series D', 35.00, (SELECT id FROM Owner WHERE email = 'jane.doe@example.com'));
INSERT INTO Figurine (id, name, description, model, series, buy_Price, id_owner_id) VALUES (UUID(), 'Figurine 5', 'Description of Figurine 5', 'Model 5', 'Series E', 40.00, (SELECT id FROM Owner WHERE email = 'jane.doe@example.com'));
INSERT INTO Figurine (id, name, description, model, series, buy_Price, id_owner_id) VALUES (UUID(), 'Figurine 6', 'Description of Figurine 6', 'Model 6', 'Series F', 45.00, (SELECT id FROM Owner WHERE email = 'jane.doe@example.com'));
INSERT INTO Figurine (id, name, description, model, series, buy_Price, id_owner_id) VALUES (UUID(), 'Figurine 7', 'Description of Figurine 7', 'Model 7', 'Series G', 50.00, (SELECT id FROM Owner WHERE email = 'alice.smith@example.com'));
INSERT INTO Figurine (id, name, description, model, series, buy_Price, id_owner_id) VALUES (UUID(), 'Figurine 8', 'Description of Figurine 8', 'Model 8', 'Series H', 55.00, (SELECT id FROM Owner WHERE email = 'alice.smith@example.com'));
INSERT INTO Figurine (id, name, description, model, series, buy_Price, id_owner_id) VALUES (UUID(), 'Figurine 9', 'Description of Figurine 9', 'Model 9', 'Series I', 60.00, (SELECT id FROM Owner WHERE email = 'alice.smith@example.com'));
