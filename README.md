# demo_prolog_java
This project uses a MySQL database called **`test`** and requires the MySQL JDBC driver to run properly.

## Database setup (MySQL)

Execute the following SQL script:

```sql
CREATE DATABASE test;
USE test;

CREATE TABLE organismo (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    especie VARCHAR(150) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO organismo (nombre, especie) VALUES 
('jaguar', 'panthera_onca'),
('condor_andino', 'vultur_gryphus'),
('cafe_arabigo', 'coffea_arabica'),
('trucha_arcoiris', 'oncorhynchus_mykiss'),
('guadua', 'guadua_angustifolia');
```

## Drivers
You should add the following dependency to the pom file
```bash
<dependencies>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>9.5.0</version>
    </dependency>
</dependencies>
```sql
