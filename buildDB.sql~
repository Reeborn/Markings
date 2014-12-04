-- clean tables --
DROP TABLE Mark IF EXISTS
DROP TABLE Student IF EXISTS
DROP TABLE TeachingUnit IF EXISTS
DROP TABLE StudyBranch IF EXISTS

-- Etudiant --
CREATE TABLE Student (
	id INTEGER IDENTITY,
	lastname VARCHAR(30) NOT NULL,
	firstname VARCHAR(30) NOT NULL,
	StudyBranchID INTEGER NOT NULL
);

-- Filière --
CREATE TABLE StudyBranch (
	id INTEGER IDENTITY,
	label VARCHAR(30) NOT NULL
);

--UE--
CREATE TABLE TeachingUnit (
	id INTEGER IDENTITY,
	label VARCHAR(30) NOT NULL,
	StudyBranchID INTEGER NOT NULL
);

-- Note --
CREATE TABLE Mark (
	value DECIMAL(10,1) NOT NULL,
	TeachingUnitID INTEGER NOT NULL,
	StudentID INTEGER NOT NULL
);

-- Etudiant foreign key --
ALTER TABLE Student ADD FOREIGN KEY(StudyBranchID) REFERENCES StudyBranch(id)
-- UE foreign key --
ALTER TABLE TeachingUnit ADD FOREIGN KEY(StudyBranchID) REFERENCES StudyBranch(id)
-- Note foreign key --
ALTER TABLE Mark ADD FOREIGN KEY(TeachingUnitID) REFERENCES TeachingUnit(id)
ALTER TABLE Mark ADD FOREIGN KEY(StudentID) REFERENCES Student(id)


