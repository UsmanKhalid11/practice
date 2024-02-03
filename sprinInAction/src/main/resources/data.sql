CREATE TABLE IF NOT EXISTS registration (
                                            id INT AUTO_INCREMENT PRIMARY KEY,
                                            name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    contact VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
    );
insert into registration(name,email,contact,password,role) values('Usman','usman@gmail.com','1234567','1234','admin');