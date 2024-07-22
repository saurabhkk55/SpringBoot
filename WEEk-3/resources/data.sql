INSERT INTO professor (name, title) VALUES
('John Doe', 'Assistant Professor'),
('Jane Smith', 'Associate Professor'),
('Emily Johnson', 'Professor'),
('Michael Brown', 'Assistant Professor'),
('Chris Davis', 'Associate Professor'),
('Pat Wilson', 'Professor'),
('Alex Martinez', 'Assistant Professor'),
('Jamie Anderson', 'Associate Professor'),
('Morgan Thomas', 'Professor'),
('Taylor Lee', 'Assistant Professor'),
('Jordan White', 'Associate Professor'),
('Casey Harris', 'Professor'),
('Charlie Clark', 'Assistant Professor'),
('Riley Lewis', 'Associate Professor'),
('Dakota Robinson', 'Professor'),
('Avery Walker', 'Assistant Professor'),
('Hayden Hall', 'Associate Professor'),
('Morgan Young', 'Professor'),
('Quinn King', 'Assistant Professor'),
('Sidney Wright', 'Associate Professor');

INSERT INTO subject (name, professor_id) VALUES
('Mathematics', 1),
('Physics', 1),
('Chemistry', 2),
('Biology', 3),
('Computer Science', 3),
('History', 3),
('Geography', 4),
('Economics', 5),
('English Literature', 6),
('Political Science', 6);

-- Insert 50 entries into StudentEntity with only name values
INSERT INTO student (name) VALUES
('Student1'), ('Student2'), ('Student3'), ('Student4'), ('Student5'),
('Student6'), ('Student7'), ('Student8'), ('Student9'), ('Student10'),
('Student11'), ('Student12'), ('Student13'), ('Student14'), ('Student15'),
('Student16'), ('Student17'), ('Student18'), ('Student19'), ('Student20'),
('Student21'), ('Student22'), ('Student23'), ('Student24'), ('Student25'),
('Student26'), ('Student27'), ('Student28'), ('Student29'), ('Student30'),
('Student31'), ('Student32'), ('Student33'), ('Student34'), ('Student35'),
('Student36'), ('Student37'), ('Student38'), ('Student39'), ('Student40'),
('Student41'), ('Student42'), ('Student43'), ('Student44'), ('Student45'),
('Student46'), ('Student47'), ('Student48'), ('Student49'), ('Student50');

-- Insert 50 entries into AdmissionRecordEntity
-- Insert 50 entries into AdmissionRecordEntity with specific student_id values
INSERT INTO admission_record (fees, student_id) VALUES
(5000, 1), (6000, 2), (5500, 3), (6200, 4), (5800, 5),
(4900, 6), (6100, 7), (5700, 8), (6300, 9), (5400, 10),
(6000, 11), (5900, 12), (6200, 13), (6000, 14), (5800, 15),
(5700, 16), (6100, 17), (6300, 18), (5600, 19), (6200, 20),
(5900, 21), (5800, 22), (6000, 23), (6100, 24), (5700, 25),
(5500, 26), (5800, 27), (5900, 28), (6200, 29), (6000, 30),
(6300, 31), (5400, 32), (5500, 33), (5600, 34), (5700, 35),
(5800, 36), (5900, 37), (6000, 38), (6100, 39), (6200, 40),
(5900, 41), (5800, 42), (6000, 43), (6100, 44), (6200, 45),
(5900, 46), (5800, 47), (6000, 48), (6100, 49), (6200, 50);




-- Insert 50 entries into StudentEntity
--INSERT INTO student (name, admission_record_id) VALUES
--('Student1', 1), ('Student2', 2), ('Student3', 3), ('Student4', 4), ('Student5', 5),
--('Student6', 6), ('Student7', 7), ('Student8', 8), ('Student9', 9), ('Student10', 10),
--('Student11', 11), ('Student12', 12), ('Student13', 13), ('Student14', 14), ('Student15', 15),
--('Student16', 16), ('Student17', 17), ('Student18', 18), ('Student19', 19), ('Student20', 20),
--('Student21', 21), ('Student22', 22), ('Student23', 23), ('Student24', 24), ('Student25', 25),
--('Student26', 26), ('Student27', 27), ('Student28', 28), ('Student29', 29), ('Student30', 30),
--('Student31', 31), ('Student32', 32), ('Student33', 33), ('Student34', 34), ('Student35', 35),
--('Student36', 36), ('Student37', 37), ('Student38', 38), ('Student39', 39), ('Student40', 40),
--('Student41', 41), ('Student42', 42), ('Student43', 43), ('Student44', 44), ('Student45', 45),
--('Student46', 46), ('Student47', 47), ('Student48', 48), ('Student49', 49), ('Student50', 50);
