# Joe's Petitions – CT5171 Cloud DevOps

This project is a Spring Boot web application developed for the CT5171 Cloud DevOps module.  
It allows users to create petitions, view existing petitions, search by keyword, and sign a petition with contact details.  
The application is deployed using a CI/CD pipeline implemented with Jenkins, Docker, and AWS EC2.

---

## Features
- Create a new petition
- View all petitions
- Search petitions by keyword
- View petition details
- Sign a petition (name, email, optional phone number)
- In-memory data storage (no database required for the CA)

---

## Technologies Used
- **Java 17**
- **Spring Boot (WAR deployment)**
- **Maven**
- **Thymeleaf**
- **Jenkins (CI/CD)**
- **Docker + Tomcat**
- **AWS EC2 (Ubuntu 22.04)**

---

## How to Run Locally

Clone the repository:

```bash
git clone https://github.com/JoeQuigley1/CT5171_CA.git
cd CT5171_CA
