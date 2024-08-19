# The Blogs App

![The Blogs App](https://theblogsapp.netlify.app/assets/logo.png)

The Blogs App is a full-stack web application that allows users to create, manage, and share blog posts. The application is built with Spring Boot on the backend, React.js on the frontend, and uses JWT authentication for secure access. The project is containerized using Docker, enabling easy deployment and scaling.

## Website Preview

You can view a live preview of the website here: [The Blogs App](https://theblogsapp.netlify.app/)

## Features

- **User Authentication:** Secure JWT-based authentication system with role-based access control.
- **Create and Manage Blogs:** Users can create, edit, and delete blog posts.
- **Image Uploads:** Supports image uploads for blog posts, stored and served via Docker.
- **Responsive Design:** Optimized for all screen sizes using React.js and modern CSS techniques.
- **RESTful APIs:** Backend built with Spring Boot, exposing RESTful APIs for all operations.

## Technology Stack

### Backend
- **Java 17**: Core programming language.
- **Spring Boot**: Framework used for creating the backend services.
- **Spring Security**: For implementing JWT-based authentication.
- **JPA/Hibernate**: ORM for database interactions.
- **H2 Database**: In-memory database for development.
- **Docker**: Containerization of the application for easy deployment.

### Frontend
- **React.js**: JavaScript library for building user interfaces.
- **HTML/CSS/JavaScript**: Core web technologies for frontend development.
- **Bootstrap**: CSS framework for responsive design.

### Database
- **PostgreSQL**: Primary database for production.
- **H2**: In-memory database for development and testing.

## Running the Project Locally

### Prerequisites
- **Java 17**
- **Maven**
- **Docker**
- **Node.js and npm** (for frontend development)

### Backend Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/blog-app.git
   cd blog-app
