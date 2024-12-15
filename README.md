# Job Portal Application

This project is a Job Portal Application designed to facilitate job postings and applications. It includes functionality for categorizing job listings and associating them with specific locations. The following document outlines the technologies used and details the database tables.

## Technologies Used

### Backend:
- **Java**
- **Servlets**
- **HikariCP**
- **JDBC**

### Frontend:
- **HTML/CSS/JavaScript**
- **JSP**

### Database:
- **PostgreSQL**

### Build Tool:
- **Maven**

---

## Database Schema

### Table: `category`

| Column Name | Data Type    | Constraints         |
|-------------|--------------|---------------------|
| `id`        | SERIAL       | PRIMARY KEY         |
| `cName`     | VARCHAR(255) | NOT NULL            |

#### Sample SQL for `category`:
```sql
CREATE TABLE category (
    id SERIAL PRIMARY KEY,
    cName VARCHAR(255) NOT NULL
);
```

#### Sample Data for `category`:
```sql
INSERT INTO category (cName) VALUES 
('IT'),
('Finance'),
('Healthcare'),
('Education'),
('Marketing');
```

### Table: `location`

| Column Name | Data Type    | Constraints         |
|-------------|--------------|---------------------|
| `id`        | SERIAL       | PRIMARY KEY         |
| `lName`     | VARCHAR(255) | NOT NULL            |

#### Sample SQL for `location`:
```sql
CREATE TABLE location (
    id SERIAL PRIMARY KEY,
    lName VARCHAR(255) NOT NULL
);
```

#### Sample Data for `location`:
```sql
INSERT INTO location (lName) VALUES 
('Mumbai'),
('Delhi'),
('Bangalore'),
('Hyderabad'),
('Chennai'),
('Pune'),
('Kolkata'),
('Ahmedabad');
```

### Table: `users`

| Column Name  | Data Type    | Constraints         |
|--------------|--------------|---------------------|
| `id`         | SERIAL       | PRIMARY KEY         |
| `username`   | VARCHAR(255) | NOT NULL            |
| `password`   | VARCHAR(255) | NOT NULL            |
| `email`      | VARCHAR(255) | NOT NULL UNIQUE     |

#### Sample SQL for `users`:
```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);
```

#### Sample Data for `users`:
```sql
INSERT INTO users (username, password, email) VALUES 
('john_doe', 'password123', 'john.doe@example.com'),
('jane_smith', 'password456', 'jane.smith@example.com');
```

### Table: `jobs`

| Column Name      | Data Type    | Constraints            |
|------------------|--------------|------------------------|
| `id`             | SERIAL       | PRIMARY KEY            |
| `title`          | VARCHAR(255) | NOT NULL               |
| `description`    | TEXT         | NOT NULL               |
| `category_id`    | INT          | FOREIGN KEY (category) |
| `location_id`    | INT          | FOREIGN KEY (location) |

#### Sample SQL for `jobs`:
```sql
CREATE TABLE jobs (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    category_id INT REFERENCES category(id),
    location_id INT REFERENCES location(id)
);
```

#### Sample Data for `jobs`:
```sql
INSERT INTO jobs (title, description, category_id, location_id) VALUES 
('Software Engineer', 'Develop and maintain software.', 1, 1),
('Data Analyst', 'Analyze business data.', 2, 2);
```

### Table: `users_problems`

| Column Name  | Data Type    | Constraints         |
|--------------|--------------|---------------------|
| `id`         | SERIAL       | PRIMARY KEY         |
| `user_id`    | INT          | FOREIGN KEY (users) |
| `problem`    | TEXT         | NOT NULL            |

#### Sample SQL for `users_problems`:
```sql
CREATE TABLE users_problems (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    problem TEXT NOT NULL
);
```

#### Sample Data for `users_problems`:
```sql
INSERT INTO users_problems (user_id, problem) VALUES 
(1, 'Unable to apply for jobs'),
(2, 'Issue with resetting password');
```

---

## Project Setup

1. Clone the repository.
2. Configure the database connection in `application.properties`.
3. Run `mvn clean install` to build the project.
4. Deploy the application using `Tomcat` or a compatible server.
5. Access the application on `http://localhost:8080`.

---

Feel free to contribute or suggest improvements to this project!
