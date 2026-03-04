# Selenium Automation – CURA Health Project

This project demonstrates a automation implementation using Selenium WebDriver and TestNG to test the CURA Healthcare Service web application.

The automation simulates real user behavior by performing essential flows such as login validation (positive & negative scenarios) and appointment booking. Each interaction is validated using TestNG assertions to ensure the application behaves as expected.

In addition to functional validation, this project showcases best practices in UI automation including proper test structure, clean setup & teardown using TestNG annotations, and reliable locator strategies. This project reflects practical hands on experience in building maintainable and reliable UI automation tests using Java based frameworks.

---

## 🔗 Demo Application

https://katalon-demo-cura.herokuapp.com/

---

## 📌 Project Overview

This automation project covers:

- Successful login with valid credentials
- Login validation with invalid password
- Login validation with empty fields
- Error message verification
- URL validation after login
- Navigation to appointment page
- Creating a new appointment
- Form submission validation
- Independent test execution using @BeforeTest and @AfterTest
---

## 🛠 Tech Stack

- Java
- Selenium 
- IntelliJ IDEA
- ChromeDriver
---

## 📂 Project Structure


├── src/
│   └── test/
│       └── java/
│           ├── HomePageTest.java
            ├── LoginPageTest.java
│           └── MakeAppointmentTest.java
├── testng.xml
├── pom.xml (if using Maven)
└── README.md

---
## ▶️ How to Run the Project

### 1️⃣ Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/selenium-cura-automation.git
```

### 2️⃣ Open the project in IntelliJ IDEA
- Open **IntelliJ IDEA**
- Click **Open**
- Select the cloned project folder

### 3️⃣ Configure Dependencies

#### ✅ If Using Maven

- Make sure `pom.xml` is available
- IntelliJ will automatically detect Maven project
- Click **Load Maven Changes** if prompted
- Wait until all dependencies are downloaded

If needed, run:

```bash
mvn clean install
```

---

#### ✅ If Not Using Maven (Manual Setup)

- Go to **File → Project Structure → Libraries**
- Click **+**
- Add the required JAR files:
  - Selenium Java
  - TestNG
  - WebDriver dependencies

### 4️⃣ Run the Test Suite

The following test classes can be executed individually:

- HomePageTest.java  
- LoginPageTest.java  
- MakeAppointmentTest.java  

---

## 🧪 Automation Approach

This project applies:

- Page level test separation  
- TestNG Assertions for validation  
- URL verification  
- Element visibility validation  
- Positive & Negative test scenarios  
- Clean setup and teardown using TestNG annotations  
- Independent test execution  

---

## 📊 Reporting

This project includes manual test documentation and execution reporting prepared as part of the automation validation process.

The report contains:
- Test Case Documentation
- Test Scenario Descriptions
- Expected vs Actual Results
- Test Execution Status (Pass/Fail)
- Evidence of automation execution

View detailed and documentation report here:

➡️ https://drive.google.com/drive/folders/1YzmSmFb51qWu2kJiZdavq2gQLJVesmiH?usp=sharing

---

## 👩‍💻 Author

**Nada Almira Maulida**  

QA Manual & Automation Enthusiast 
