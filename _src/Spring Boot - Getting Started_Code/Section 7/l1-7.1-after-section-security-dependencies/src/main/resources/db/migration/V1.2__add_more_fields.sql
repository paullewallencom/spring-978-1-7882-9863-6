
ALTER TABLE BOOKMARK ADD description VARCHAR(255) NULL;
ALTER TABLE BOOKMARK ADD createdon TIMESTAMP DEFAULT current_timestamp() NULL;
ALTER TABLE BOOKMARK ADD updatedon TIMESTAMP DEFAULT current_timestamp() NULL;