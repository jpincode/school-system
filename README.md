# School Management System

## 📝 Description
System developed in Java for managing students and subjects in an educational institution. The project implements CRUD operations (Create, Read, Update, Delete) and follows the MVC (Model-View-Controller) architecture pattern. The system now uses DTOs (Data Transfer Objects) for data transfer between layers, enhancing separation of concerns.

## 🏗️ Project Structure

```
src/
├── business/
│   ├── dto/
│   │   ├── DisciplineDTO.java        # DTO for subject
│   │   └── StudentDTO.java           # DTO for student
│   └── services/
│       ├── DisciplineService.java    # Business rules for subjects (now using DTO)
│       ├── IOService.java            # Input/output service
│       └── StudentService.java       # Business rules for students (now using DTO)
├── models/
│   ├── entities/
│   │   ├── Discipline.java           # Subject entity
│   │   └── Student.java              # Student entity
│   └── repositories/
│       ├── DisciplineRepository.java # Subject repository
│       ├── ManagerRepository.java    # Repository manager (Singleton)
│       └── StudentRepository.java    # Student repository
└── presentations/
    ├── controllers/
    │   ├── DisciplineController.java # Subject controller (now using DTO)
    │   └── StudentController.java    # Student controller (now using DTO)
    └── views/
        ├── DeleteView.java           # Delete interface
        ├── ListView.java             # Listing interface
        ├── Main.java                 # Application entry point
        ├── MenuView.java             # Main menu
        ├── RegisterView.java         # Registration interface
        └── UpdateView.java           # Update interface
```

## 🚀 New Features and Improvements

- **Use of DTOs:** Data now flows between layers through DTO objects, improving code organization and maintainability.
- **Updated Controllers and Services:** Registration and update methods now receive DTOs as parameters.
- **Enhanced Validations:** Required fields and uniqueness validation remain, but are now centralized in DTOs and services.
- **More Modular Code:** Clear separation between entities, DTOs, business logic, persistence, and presentation.

## 🛠️ Technologies Used
- Java 17
- MVC Pattern
- Object-Oriented Programming
- Singleton Pattern (ManagerRepository)
- DTO Pattern

## ⚙️ How to Run

### Prerequisites
- Java Development Kit (JDK) 17 or higher
- Visual Studio Code with "Extension Pack for Java"

### Steps to Run

1. Clone the repository:
```bash
git clone https://github.com/jpdevv/school-system.git
```

2. Open the project in Visual Studio Code:
```bash
code school-system
```

3. Compile and run the Main class:
```bash
cd src
javac presentations/views/Main.java
java presentations.views.Main
```

## 📱 How to Use

### Main Menu
The system presents the following options:
1. Register Subject
2. Register Student
3. Enroll Student in Subject
4. Delete Subject
5. Delete Student
6. Unenroll Student from Subject
7. Update Subject
8. Update Student
9. List
0. Exit

### Listing Menu
1. List Subjects
2. List Students
0. Return to Main Menu

### Main Operations

#### Student Registration
- Required information:
  - Registration number (unique)
  - Name
  - Email (unique)
  - Address

#### Subject Registration
- Required information:
  - Name
  - Code (unique)
  - Workload

## 🏗️ Architecture

### System Layers
1. **Presentation** (`presentations/`)
   - Views: User interface divided into multiple specialized views
   - Controllers: Input validation and routing, now using DTOs

2. **Business** (`business/`)
   - DTOs: Data transfer objects between layers
   - Services: Business rules and application logic, now using DTOs
   - IOService: Input/output management

3. **Model** (`models/`)
   - Entities: Domain classes
   - Repositories: In-memory data persistence

## 👥 Design Patterns Used

### MVC (Model-View-Controller)
- **Model**: Entidades e repositórios
- **View**: Classes especializadas em `presentations/views`
- **Controller**: Classes em `presentations/controllers` (agora usando DTOs)

### Repository Pattern
- Data persistence abstraction
- Implemented in `models/repositories`
- Managed by ManagerRepository

### Singleton Pattern
- Implemented in ManagerRepository to ensure a single instance
- Centralizes repository access
- Ensures data consistency

### DTO Pattern
- Used to transfer data between layers in a decoupled way

## 🔍 Validations
- Unique registration number for students
- Unique email for students
- Unique code for subjects
- Required fields cannot be empty
- Confirmation for deletions

## 🤝 Contributing
1. Fork the project
2. Create a branch for your feature (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Open a Pull Request

## 📄 License
This project is under the MIT license. See the [LICENSE](LICENSE) file for more details.

## 📫 Contact
- Email: joaoaraujo.developer@gmail.com
- LinkedIn: [João Paulo](https://www.linkedin.com/in/joaodevv/)
- GitHub: [jpdevv](https://github.com/jpdevv)