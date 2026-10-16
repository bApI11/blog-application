# Chandra Blog 📝

A blog web application developed using Java and Spring Boot. Chandra Blog provides a user-friendly interface for displaying blog posts and can be extended with features such as searching, authentication, and blog management.

## 🚀 Features

- Display blog posts on the home page.
- View individual blog posts.
- Search blog posts by keyword (if implemented).
- Responsive user interface using Bootstrap.
- Server-side HTML rendering using Thymeleaf.
- MySQL database integration (if configured).
- Create, update, and delete blog posts (if implemented).

## 🛠️ Technology Stack

- **Backend:** Java, Spring Boot, Spring MVC
- **Frontend:** HTML5, CSS3, JavaScript, Bootstrap
- **Template Engine:** Thymeleaf
- **Database:** MySQL
- **Build Tool:** Maven
- **Version Control:** Git and GitHub

## 📋 Prerequisites

Make sure the following tools are installed:

- JDK version configured in `pom.xml`
- Maven
- MySQL Server, if using MySQL
- IntelliJ IDEA, Eclipse, or Spring Tool Suite
- Git

## ⚙️ Installation and Setup

### 1. Clone the repository

```bash
git clone https://github.com/bApI11/blog-application.git

cd chandra-blog
```

Replace `YOUR_USERNAME` and `chandra-blog` with your actual GitHub username and repository name.

### 2. Create the database

If your application uses MySQL, create a database:

```sql
CREATE DATABASE chandra_blog;
```

### 3. Configure the database

Update `src/main/resources/application.properties` with your database settings:

```properties
spring.application.name=chandra-blog

spring.datasource.url=jdbc:mysql://localhost:3306/chandra_blog
spring.datasource.username=root
spring.datasource.password=root
```

Set `DB_USERNAME` and `DB_PASSWORD` as environment variables. Adapt these settings to match your actual application configuration.

### 4. Build the application

```bash
mvn clean package
```

### 5. Run the application

```bash
mvn spring-boot:run
```

Alternatively, run the main Spring Boot application class from your IDE.

### 6. Open the application

```text
http://localhost:8080/
```

## 🔗 Application Endpoints

The following are example routes for a Spring MVC blog application. They are not confirmed as implemented in this project.

### Page Endpoints

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/` | Display the home page |
| GET | `/posts/{id}` | Display a specific blog post |
| GET | `/search?keyword=java` | Search blog posts |
| GET | `/login` | Display the login page, if implemented |
| GET | `/register` | Display the registration page, if implemented |
| GET | `/posts/create` | Display the create-post form, if implemented |
| GET | `/posts/edit/{id}` | Display the edit-post form, if implemented |

### Blog Management Endpoints

| HTTP Method | Endpoint | Description |
|---|---|---|
| POST | `/posts` | Create a blog post |
| POST | `/posts/{id}/update` | Update a blog post |
| POST | `/posts/{id}/delete` | Delete a blog post |

These are illustrative form-submission routes. Your actual routes may use different paths or HTTP methods.

## 📁 Project Structure

A typical Spring Boot project structure is shown below. Adjust it to match your actual package and file names.

```text
chandra-blog/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/chandra/blog/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       ├── entity/
│   │   │       └── ChandraBlogApplication.java
│   │   └── resources/
│   │       ├── templates/
│   │       ├── static/
│   │       │   ├── css/
│   │       │   ├── js/
│   │       │   └── images/
│   │       └── application.properties
├── pom.xml
├── README.md
├── LICENSE
└── .gitignore
```

## 🧪 Testing

Run the automated tests using:

```bash
mvn test
```

Test the home page, blog post retrieval, search functionality, and blog management operations that your application implements.

## 🔐 Security Best Practices

- Do not commit database passwords or API keys.
- Validate user input.
- Restrict blog editing and deletion to authorized users.
- Keep dependencies updated.
- Use secure configuration for production deployments.

## 🔮 Future Enhancements

- Pagination and sorting.
- Blog categories and tags.
- User registration and authentication.
- Comments and likes.
- Image uploads.
- Role-based access control.
- Automated tests and CI/CD deployment.

## 📄 License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Chandra Blog**

Developed as a Java and Spring Boot web application project.
