#DDL Process

CREATE DATABASE IF NOT EXISTS service_motor_db;

USE service_motor_db;

#Tabel Service Motorcycle
CREATE TABLE IF NOT EXISTS ServiceMotorcycle(
    id INT AUTO_INCREMENT,
    nama VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    merk VARCHAR(255) NOT NULL,
    motorcycle_type VARCHAR(255) NOT NULL,
		status_service  ENUM('WAITING','PROCESSING','DONE') NOT NULL DEFAULT 'WAITING',
    service_type ENUM("PERIODIC_SERVICE", "OIL_CHANGE", "etc") NOT NULL,
    complaint VARCHAR(255),
    cost INT NOT NULL, 
    created_at VARCHAR(255) NOT NULL,
    created_by  VARCHAR(255) NOT NULL,
    updated_at VARCHAR(255),
    is_deleted TINYINT(1) NOT NULL DEFAULT FALSE,
    PRIMARY KEY(id)
);